package com.basic.rentcar.frontcontroller;

import java.util.HashMap;

import com.basic.rentcar.controller.member.MemberLoginController;
import com.basic.rentcar.controller.member.MemberLogoutController;
import com.basic.rentcar.controller.rentcar.CarAllListController;
import com.basic.rentcar.controller.rentcar.CarByCategoryController;
import com.basic.rentcar.controller.rentcar.RentcarReserveMainController;

public class HandlerMapping {
	private HashMap<String, Controller> mappings;

	public HandlerMapping() {
		mappings = new HashMap<String, Controller>();
		mappings.put("/memberLogin.do", new MemberLoginController());
		mappings.put("/memberLogout.do", new MemberLogoutController());
		mappings.put("/rentcarReserveMain.do", new RentcarReserveMainController());
		mappings.put("/carCategoryList.do", new CarByCategoryController());
		mappings.put("/carAllList.do", new CarAllListController());
	}

	public Controller getController(String key) {
		return mappings.get(key);
	}
}
