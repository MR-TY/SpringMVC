package com.ty.springmvc.crud.test;

import java.util.Date;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ty.springmvc.crud.dao.EmployeeDao;
import com.ty.springmvc.crud.entities.Employee;

import net.sf.cglib.core.Local;

@Controller
public class SpringMVCTest {
	@Resource
	private EmployeeDao employeeDao;

	@RequestMapping("/testConversionServiceConverer")
	public String testConverter(@RequestParam("employee") Employee employee) {
		System.out.println("employee:" + employee);
		employeeDao.save(employee);
		return "redirect:/emps";
	}

	@ResponseBody
	@RequestMapping("/testHttpMessageConverter")
	public String testHttpMessageConverter(@RequestBody String body) {
		System.out.println(body);
		return "hello" + new Date();
	}

	@Resource
	private ResourceBundleMessageSource messageSource;

	@RequestMapping("/i18n")
	public String TestI18n(Locale local) {
		String val = messageSource.getMessage("i18n.user", null, local);
		System.out.println(val);
		return "i18n";
	}

	@RequestMapping("/testFileUpload")
	public String testUploadPage(@RequestParam("desc") String desc, @RequestParam("file") MultipartFile file) {
		System.out.println("desc:" + desc);
		System.out.println("fileName:" + file.getName());
		return "success";
	}

	@RequestMapping("/ExceptionHandResolver")
	public String testExceptionHandResolver(@RequestParam("i") Integer i) {
		System.out.println("result:" + i / 0);
		return "success";
	}

	@RequestMapping("/ResponseStatusExceptionHandResolver")
	public String testResponseStatusExceptionHandResolver(@RequestParam("i") Integer i) {

		if (i == 13) {
			throw new ResponseStatusExceptionHandResolver();
		}
		return "success";
	}
}
