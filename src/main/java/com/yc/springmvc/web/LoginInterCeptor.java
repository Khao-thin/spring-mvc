package com.yc.springmvc.web;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component   
public class LoginInterCeptor implements HandlerInterceptor{
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response,Object handler) throws IOException {
		//判断当前是否登录
		if(request.getSession().getAttribute("loginedUser")==null) {
			//根据当前的请求方式返回不同结果
			//判断当前是页面跳转还是ajax请求
			String accept=request.getHeader("Accept");
			if(accept.startsWith("application/json")) {
				response.setContentType("application/json;charset=utf-8");
				response.getWriter().append("{code:0,msg:'请先登录系统'}");
			}else {
				response.setContentType("text/html;charset=utf-8");
				response.sendRedirect("/login.html");
			}return false;
		}
		return true;
	}
}
