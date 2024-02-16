package com.basic.rentcar.controller.rentcar;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.basic.rentcar.frontcontroller.Controller;
import com.basic.rentcar.model.dao.CarDAO;
import com.basic.rentcar.model.vo.CarVO;

public class RentcarReserveMainController implements Controller {
	@Override
	public String requestHandler(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		CarDAO cDAO = CarDAO.getInstance();
		ArrayList<CarVO> list = cDAO.getSelectCar();
		session.setAttribute("list", list);
		return "08_carReserveMain";
	}
}
