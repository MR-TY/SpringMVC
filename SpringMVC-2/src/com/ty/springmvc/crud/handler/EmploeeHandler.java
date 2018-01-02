package com.ty.springmvc.crud.handler;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.tomcat.jni.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ty.springmvc.crud.dao.DepartmentDao;
import com.ty.springmvc.crud.dao.EmployeeDao;
import com.ty.springmvc.crud.entities.Department;
import com.ty.springmvc.crud.entities.Employee;

@Controller
public class EmploeeHandler {

	@Resource
	private EmployeeDao employeeDao;

	@Resource
	private DepartmentDao departmentDao;

	@RequestMapping("/emps")
	public String list(Map<String, Object> map) {
		System.out.println("进来了");
		map.put("employees", employeeDao.getAll());
		return "list";
	}

	@RequestMapping(value = "/emp/{id}", method = RequestMethod.GET)
	public String input(@PathVariable("id")Integer id,Map<String, Object> map) {
		map.put("employee", employeeDao.get(id));
		map.put("department", departmentDao.getDepartments());
		return "input";
	} 
	
	@RequestMapping(value = "/emp", method = RequestMethod.GET)
	public String input(Map<String, Object> map) {
		map.put("department", departmentDao.getDepartments());
		map.put("employee", new Employee());
		return "input";
	}
	
	@RequestMapping(value = "/emp", method = RequestMethod.POST)
	public String save(Employee employee) {
		employeeDao.save(employee);
		return "redirect:/emps";//转发：通过查询全部，看是否保存成功
	}
	
	@RequestMapping(value="/emp/{id}", method=RequestMethod.DELETE)
	public String delete(@PathVariable("id") Integer id){
		System.out.println("-------"+id);
		employeeDao.delete(id);
		return "redirect:/emps";
	}
	
	@RequestMapping(value="/emp/emp", method=RequestMethod.PUT)
	public String update(Employee employee){
		employeeDao.save(employee);
		return "redirect:/emps";
	}
	@ModelAttribute
	public void getEmp(@RequestParam(value="id",required=false) Integer id,Map<String, Object> map){
		if (id!=null) {
			map.put("employee", employeeDao.get(id));
		}
	}

//	@InitBinder
//	public void testInitBinder(WebDataBinder binder){
//		binder.setDisallowedFields("lastName");
//	}
}
