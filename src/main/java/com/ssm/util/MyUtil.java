/**   
* @Title: MyUtil.java 
* @Package com.ssm.util 
* @Description: TODO(用一句话描述该文件做什么) 
* @author 徐文昌  
* @date 2019年4月11日 下午3:00:58 
* @version V1.0   
*/
package com.ssm.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import com.ssm.model.User;

/**  
* 自定义工具类
* 
* @author heshihui 
* @date 2019年4月11日  
*/
public class MyUtil {
	/**
	 * 获得时间字符串
	 */
	public static String getStringID() {
		String id=null;
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		id=sdf.format(date);
		return id;
	}
	/**
	 * 获取用户id
	 */
	public static String getUserId(HttpSession session) {
		User user=(User) session.getAttribute("user");
		return user.getName();
	}
}
