package com.yc.springmvc.web;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;
//import org.springframework.web.bind.annotation.SessionAttributes;

import com.yc.springmvc.bean.DmUser;
/**
 * @Controller注解，表示该类所有的方法返回值是跳转到某个页面
 * @RestController注解，表示该类所有的方法返回值都是JSON数据
 * @author 23163
 *
 */
@RestController
@RequestMapping("user")
/**
 * @SessionAttribute
 * names 用于监控数据模型中出现指定名字的对象
 * types 用于监控数据模型中出现指定类型的对象
 */
//@SessionAttributes(names="loginUser",types=Date.class)
public class HelloAction {
	@RequestMapping("**/hello")
	public String head(@RequestHeader String accept,
			@RequestHeader(value="Connection",required=true) String conn) {
		return accept+"<br>"+conn;
	}
	@RequestMapping("**/cookie")
	public String cookie(@CookieValue String user,@CookieValue int age,
			@RequestHeader String cookie) {
		return user+"<br>"+age+"<br>"+cookie;
	}
	
	@RequestMapping("**/servlet")
	public String servlet(HttpServletRequest request,
						HttpServletResponse response,
						HttpSession session,
						InputStream in,
						OutputStream out) {
		return ""+request+"<br>"+response+"<br>"+session+"<br>"+in+"<br>"+out;
	}
	/**
	 * 地址参数get请求的参数格式
	 * 标准URL中的参数格式login?user=root&pwd=123
	 * 地址参数user/root/123/login
	 * @param user
	 * @param password
	 * @return
	 */
	@RequestMapping("{user}/{pwd}/login")
	public String login(
			@PathVariable("user") 
			String user,
			@PathVariable
			String pwd) {
		return user+"<br>"+pwd;
	}
	/**
	 * 会话对象的注入
	 * @SessionAttribute	从会话中获取一个对象
	 * @SessionAttributes	将指定的对象设置到会话中
	 * SpringMVC数据模型	Model
	 */
	@RequestMapping("{user}/{pwd}/login.do")
	public String logindo(
			@PathVariable("user")
			String user,
			@PathVariable
			String pwd,
			Model model,
			HttpSession session) {
		
		DmUser du=new DmUser();
		du.setEname(user);
		du.setPassword(pwd);
		//将用户对象添加到数据模型中
		session.setAttribute("loginedUser",du);
		session.setAttribute("now",new Date());
		session.setAttribute("age",100);
		return du.toString();
	}
	
	/**
	 * 验证会话中值
	 */
	@RequestMapping("testLogin")
	public String testLogin(
			@SessionAttribute("loginedUser") DmUser du,
			@SessionAttribute("now") Date date,
			@SessionAttribute(value="age",required=false) Integer age){
		return du+"<br>"+date+"<br>"+age;	
	}
	
}
