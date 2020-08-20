package com.yc.springmvc.web;

import javax.validation.Valid;

import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yc.springmvc.bean.DmUser;
import com.yc.springmvc.bean.Result;

@RestController
@RequestMapping("demo")
public class ValidAction {
	@RequestMapping("reg.do")
	public Result reg(@Valid DmUser user,Errors errors) {
		/**
		 * errors.hasErrors() 判断是否有错误
		 * errors.hasFieldErrors 判断是否有字段错误
		 */
		if(errors.hasErrors()) {
			return new Result(0,"验证错误",errors.getAllErrors());
		}else {
			return new Result(1,"注册成功");
		}
		
	}
}
