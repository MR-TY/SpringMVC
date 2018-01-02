package com.ty.springmvc.crud.test;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionHandler1 {
	//处理异常
	@ExceptionHandler({ArithmeticException.class})
	public ModelAndView handleArithmeticException(Exception ex){
		ModelAndView modelAndView = new ModelAndView("error");
		modelAndView.addObject("exception", ex);
		System.out.println("========出异常了："+ex);
		return modelAndView;
	}
}
