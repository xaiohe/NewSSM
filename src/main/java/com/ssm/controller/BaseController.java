/**   
* @Title: BaseController.java 
* @Package com.ssm.controller 
* @Description: TODO(用一句话描述该文件做什么) 
* @author 徐文昌  
* @date 2019年4月11日 下午1:42:00 
* @version V1.0   
*/
package com.ssm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.ssm.exception.AdminLoginNoException;

/**  
* 登录权限控制，在处理方法执行前执行该方法
* 
* @author heshihui 
* @date 2019年4月11日  
*/
@Controller
public class BaseController {
	@ModelAttribute
	public void isLogin(HttpSession session,HttpServletRequest request)throws AdminLoginNoException{
		if(session.getAttribute("user")==null) {
			throw new AdminLoginNoException("没有登录");
		}
	}
}
