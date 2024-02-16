package com.basic.rentcar.controller.rentcar;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.basic.rentcar.frontcontroller.Controller;
import com.basic.rentcar.model.dao.CarDAO;

public class CarAllListController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		CarDAO cDAO = CarDAO.getInstance();
		HttpSession session = req.getSession();
		session.setAttribute("list", cDAO.getAllCar());
		return "09_carAllList";
	}
}
