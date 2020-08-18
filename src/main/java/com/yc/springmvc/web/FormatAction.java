package com.yc.springmvc.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yc.springmvc.bean.DmOrders;

@RestController
@RequestMapping("demo")
public class FormatAction {
	@RequestMapping("Orders")
	public DmOrders addOrders(DmOrders dos) {
		System.out.println(dos.getDate());
		return dos;
	}
}
