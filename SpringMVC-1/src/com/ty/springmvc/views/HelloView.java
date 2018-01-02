package com.ty.springmvc.views;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.View;
@Component
public class HelloView implements View{

	@Override
	public String getContentType() {
		System.out.println("test customer view");
		//------返回内容的类型---------
		return "text/html";
	}

	@Override
	public void render(Map<String, ?> arg0, HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.getWriter().print("time:"+new Date());
	}
}
