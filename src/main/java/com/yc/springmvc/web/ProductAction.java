package com.yc.springmvc.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yc.springmvc.bean.DmCart;
import com.yc.springmvc.bean.DmUser;

@RestController
public class ProductAction {
	
	@RequestMapping(path="product.do",params="op=query",produces="text/html;charset=UTF-8")
	public String query() {
		return "按时间大苏打";
	}
	@RequestMapping(path="product.do",params="op=add")
	public String add() {
		return "add";
	}
	@RequestMapping(path="product.do",params="op=mod",method = RequestMethod.POST)
	public String mod() {
		return "mod";
	}
	@RequestMapping(path="product.do",params="op=mgr",headers = {"Host=localhost","Cookie"})
	public String mgr() {
		return "mgr";
	}
	
	
	/**
	 * SpringMVC 对于简单请求参数：数字String Boolean
	 * 可以直接将请求参数注入到方法参数中
	 * 必须满足：1、方法参数名==请求参数名
	 * 		  2、类型要兼容 int num==>num==123
	 */
	@GetMapping("login.do")
	public String login(String user,String password) {
		return user+":"+password;
	}
	/**
	 * 如果对象接收请求参数，对象的属性名与请求参数名称映射
	 * 请求参数===>对象  装箱  ===>java包装类装箱
	 * 对于一些特殊对象（日期），需要用springMVC转换器进行值的转换
	 */
	@GetMapping("reg.do")
	public String login(DmUser user,DmCart cart) {
		return user.toString()+"<br>"+cart;
	}
	
	@GetMapping("pay.do")
	public String pay(@RequestParam(
			name="userid",required = true
			)
			String uid,Double money) {
		return uid+":"+money;
	}
	
	@GetMapping("findUser.do")
	public DmUser findUser() {
		DmUser user=new DmUser();
		user.setCname("玩到晚上都");
		user.setId(100);
		user.setPassword("123");
		return user;
	}
	
}
