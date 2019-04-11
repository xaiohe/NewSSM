package com.ssm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		//获取请求的url
		String url=request.getRequestURI();
		//login.jsp或登录请求放行，不拦截
		if(url.indexOf("/toLogin")>=0||url.indexOf("login")>=0) {
			return true;
		}
		//获取session；
		HttpSession session=request.getSession();
		Object obj=session.getAttribute("user");
		if(obj!=null) 
			return true;
			//没有登录且不是登录页面，转发到登录页面，并给出提示错误信息
			request.setAttribute("msg", "没有登录，请先登录！");
			request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
			return false;
		}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
	}
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
	}
}
