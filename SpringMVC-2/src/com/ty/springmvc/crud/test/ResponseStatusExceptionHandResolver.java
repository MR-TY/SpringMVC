package com.ty.springmvc.crud.test;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN,reason="用户名或者密码不匹配")
public class ResponseStatusExceptionHandResolver extends RuntimeException{
	
}
