package com.yc.springmvc.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * @Controller注解，表示该类所有的方法返回值是跳转到某个页面
 * @RestController注解，表示该类所有的方法返回值都是JSON数据
 * @author 23163
 *
 */
@RestController
public class HelloAction {
	@RequestMapping("hello")
	public String hello() {
		return "hello world";
	}
}
