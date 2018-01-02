package com.ty.springmvc.crud.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ty.springmvc.crud.entities.Department;
import com.ty.springmvc.crud.entities.Employee;
@Component
public class EmployeeConverter implements Converter<String,Employee>{

	@Override
	public Employee convert(String source) {
		if (source!=null) {
			String[] vars = source.split("-");
			if (vars!=null&&vars.length==4) {
				String lastName = vars[0];
				String email = vars[1];
				Integer gender = Integer.parseInt(vars[2]);
				Department department = new Department();
				department.setId(Integer.parseInt(vars[3]));
				
				Employee employee = new Employee(null, lastName, email, gender, department);
				System.out.println(source+"convert"+employee);
				
				return employee;
			}
		}
		return null;
	}
	
}
