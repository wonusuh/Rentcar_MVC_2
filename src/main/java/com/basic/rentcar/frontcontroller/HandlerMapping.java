package com.basic.rentcar.frontcontroller;

import java.util.HashMap;

import com.basic.rentcar.controller.member.MemberLoginController;

public class HandlerMapping {
	private HashMap<String, Controller> mappings;

	public HandlerMapping() {
		mappings = new HashMap<String, Controller>();
		mappings.put("/memberLogin.do", new MemberLoginController());
	}

	public Controller getController(String key) {
		return mappings.get(key);
	}
}
