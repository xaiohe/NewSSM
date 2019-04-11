package com.ssm.exception;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.ssm.model.User;

public class MyExceptionHandler implements HandlerExceptionResolver {

	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		Map<String,Object>model=new HashMap<String, Object>();
		model.put("ex", ex);
		//根据不同错误转向不同页面（统一处理），即异常与View的对应关系
		if(ex instanceof AdminLoginNoException ) {
			//登录页面需要user对象
			request.setAttribute("user", new User());
			request.setAttribute("msg", "没有登录，请登录！");
			return new ModelAndView("/login",model);
		}
		else if(ex instanceof UserLoginNoException){
			request.setAttribute("user", new User());
			request.setAttribute("msg", "没有登录，请登录！");
			return new ModelAndView("/login",model);
		}else {
			return new ModelAndView("/error",model);
		}
	}
}
