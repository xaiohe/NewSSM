package com.ssm.controller;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.ssm.model.User;

@Controller
@RequestMapping("/user")
public class UserController {

//	//@Resource(name="userService")
//	private IUserService userService;
//	//private IUserService userService = (IUserService) SpringContextAware.applicationContext.getBean("userService");
//	
//	
//	@RequestMapping("/login")
//	public ModelAndView login() {
//		ModelAndView view = new ModelAndView("index");
//		userService.addUser();
//		return view;//默认内部跳转
//	}
	/**
	 * 登录页面初始化
	 */
	@RequestMapping("/tologin")
	public String initLogin() {
		return "login";
	}
	/**
	 * 处理登录功能
	 */
	@RequestMapping("/login")
	public String login (User user,Model model,HttpSession session) {
		System.out.println(user.getName());
		if("xiaohe".equals(user.getName())&&"123456".equals(user.getPassword())) {
			//登陆成功，将用户信息保存到session对象中
			session.setAttribute("user", user);
			//重定向到主页面的跳转方法
			return "redirect:main";
		}else {
			model.addAttribute("msg","用户名或密码错误，请重新登录！");
			return "login";
		}
	}
	/**
	 * 跳转到主页面
	 */
	@RequestMapping("/main")
	public String toMian() {
		return "main";
	}
	/**
	 * 退出登录
	 */
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		//清除session信息
		session.invalidate();
		return "login";
	}
}
