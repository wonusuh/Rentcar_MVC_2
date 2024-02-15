package com.basic.rentcar.frontcontroller;

import java.util.HashMap;

import com.basic.rentcar.controller.admin.AddCarController;
import com.basic.rentcar.controller.admin.AddImageController;
import com.basic.rentcar.controller.member.MemberIdValidAjaxController;
import com.basic.rentcar.controller.member.MemberJoinController;
import com.basic.rentcar.controller.member.MemberLoginController;
import com.basic.rentcar.controller.member.MemberLogoutController;
import com.basic.rentcar.controller.member.MemberPwValidController;
import com.basic.rentcar.controller.member.MemberQuitContorller;
import com.basic.rentcar.controller.rentcar.CarAllListController;
import com.basic.rentcar.controller.rentcar.CarByCategoryController;
import com.basic.rentcar.controller.rentcar.CarOptionSelectController;
import com.basic.rentcar.controller.rentcar.CarReserveInfoController;
import com.basic.rentcar.controller.rentcar.CarReserveResultController;
import com.basic.rentcar.controller.rentcar.CarReserveViewController;
import com.basic.rentcar.controller.rentcar.RentcarReserveMainController;
import com.basic.rentcar.controller.rentcar.ReserveDeleteController;

public class HandlerMapping {
	private HashMap<String, Controller> mappings;

	public HandlerMapping() {
		mappings = new HashMap<String, Controller>();
		mappings.put("/memberLogin.do", new MemberLoginController());
		mappings.put("/memberLogout.do", new MemberLogoutController());
		mappings.put("/rentcarReserveMain.do", new RentcarReserveMainController());
		mappings.put("/carCategoryList.do", new CarByCategoryController());
		mappings.put("/carAllList.do", new CarAllListController());
		mappings.put("/carReserveInfo.do", new CarReserveInfoController());
		mappings.put("/carOptionSelect.do", new CarOptionSelectController());
		mappings.put("/carReserveResult.do", new CarReserveResultController());
		mappings.put("/carReserveView.do", new CarReserveViewController());
		mappings.put("/reserveDelete.do", new ReserveDeleteController());
		mappings.put("/adminAddCar.do", new AddCarController());
		mappings.put("/addImage.do", new AddImageController());
		mappings.put("/memberJoin.do", new MemberJoinController());
		mappings.put("/memberQuit.do", new MemberQuitContorller());
		mappings.put("/memberIdValidAjax.do", new MemberIdValidAjaxController());
		mappings.put("/memberPwValid.do", new MemberPwValidController());
	}

	public Controller getController(String key) {
		return mappings.get(key);
	}
}
