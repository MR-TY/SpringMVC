package com.ty.springmvc.crud.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class FirstInterceptor implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		System.out.println("[FirstInterceptor] afterCompletion");
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		System.out.println("[FirstInterceptor] postHandle");
	}
/**
 * 1.preHandle该方法：目标方法之前调用，若返回值为true继续调用后边的拦截器和目标方法，若返回为false，则不会在调用后边的拦截器和目标方法
 * 
 *2. postHandle：当preHandle为false的时候，这个方法就不能被执行，在preHandle方法之后，渲染视图之前
 *
 *3.afterCompletion：渲染视图之后被调用
 *
 *作用：
 *1.preHandle：可以考虑做权限，日志、事务等
 *
 *2.可以对请求域中的属性，或者试图做修改
 *
 *3.释放资源
 */
	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
		System.out.println("[FirstInterceptor] preHandle");
		return true;
	}
	
}
