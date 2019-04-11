package com.ssm.exception;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class MyExceptionHandler implements HandlerExceptionResolver {

	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		Map<String,Object>model=new HashMap<String, Object>();
		model.put("ex", ex);
		//根据不同错误转向不同页面（统一处理），即异常与View的对应关系
		if(ex instanceof SQLException){
			return new ModelAndView("sql-error",model);
		}else {
			return new ModelAndView("error",model);
		}
	}

}
