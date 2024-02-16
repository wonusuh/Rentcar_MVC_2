package com.basic.rentcar.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.basic.rentcar.frontcontroller.Controller;
import com.basic.rentcar.model.vo.CarVO;

public class AddCarController implements Controller {
	@Override
	public String requestHandler(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		if (req.getParameter("name") == null)
			return "16_adminAddCarForm";
		String name = req.getParameter("name");
		String category = req.getParameter("category");
		String price = req.getParameter("price");
		String usepeople = req.getParameter("usepeople");
		String total_qtyrentcar = req.getParameter("total_qtyrentcar");
		String company = req.getParameter("company");
//		String img = req.getParameter("img");
		String info = req.getParameter("info");
		System.out.println(name);
		System.out.println(category);
		System.out.println(price);
		System.out.println(usepeople);
		System.out.println(total_qtyrentcar);
		System.out.println(company);
		System.out.println(info);
		CarVO newCar = new CarVO();
		newCar.setName(name);
		newCar.setCategory(Integer.parseInt(category));
		newCar.setPrice(Integer.parseInt(price));
		newCar.setUsepeople(Integer.parseInt(usepeople));
		newCar.setTotalQty(Integer.parseInt(total_qtyrentcar));
		newCar.setCompany(company);
		newCar.setInfo(info);
		HttpSession session = req.getSession();
		session.setAttribute("newCar", newCar);
		return "17_addImgForm";
	}
}
