package com.basic.rentcar.controller.rentcar;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.basic.rentcar.frontcontroller.Controller;
import com.basic.rentcar.model.dao.CarDAO;
import com.basic.rentcar.model.vo.CarVO;

public class CarReserveInfoController implements Controller {
	@Override
	public String requestHandler(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		int no = Integer.parseInt(req.getParameter("no"));
		CarDAO cDAO = CarDAO.getInstance();
		CarVO carVO = cDAO.getOneCar(no);
		HttpSession session = req.getSession();
		session.setAttribute("carVO", carVO);
		String carSize = "";
		if (carVO.getCategory() == 1)
			carSize = "소형";
		if (carVO.getCategory() == 2)
			carSize = "중형";
		if (carVO.getCategory() == 3)
			carSize = "대형";
		session.setAttribute("carSize", carSize);
		return "10_carReserveInfo";
	}
}
