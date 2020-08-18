package com.yc.springmvc.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class TestAction {
	@RequestMapping("/toString")
	public String toString() {
		return "aaaaa";
	}
	@RequestMapping("?/add")
	public String add() {
		return "ccccccccc";
	}
	@RequestMapping("*/del")
	public String del() {
		return "ddddddddd";
	}
	@RequestMapping(path="**/insert",produces="text/html;charset=UTF-8")
	public String insert() {
		return "ask发动机阿斯利康大家";
	}
}
