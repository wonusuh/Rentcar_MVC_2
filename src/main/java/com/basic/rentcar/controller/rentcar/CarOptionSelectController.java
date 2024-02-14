package com.basic.rentcar.controller.rentcar;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.basic.rentcar.frontcontroller.Controller;

public class CarOptionSelectController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String stringQty = req.getParameter("qty");
		if (stringQty == null) {
			System.out.println("남은 차량 수량 0");
			return "10_carReserveInfo";
		}
		int qty = Integer.parseInt(stringQty);
		HttpSession session = req.getSession();
		System.out.println("선택한 차량 수 : " + qty);
		session.setAttribute("qty", qty);
		return "11_carOptionSelect";
	}
}
