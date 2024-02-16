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

public class CarByCategoryController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		int value = Integer.parseInt(req.getParameter("category"));
		CarDAO cDAO = CarDAO.getInstance();
		ArrayList<CarVO> list = cDAO.getCategoryCar(value);
		HttpSession session = req.getSession();
		session.setAttribute("list", list);
		if (value == 1) {
			session.setAttribute("carSize", "소형");
		}
		if (value == 2) {
			session.setAttribute("carSize", "중형");
		}
		if (value == 3) {
			session.setAttribute("carSize", "대형");
		}
		return "13_carCategoryList";
	}
}
