package com.basic.rentcar.controller.rentcar;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.basic.rentcar.dao.CarViewDAO;
import com.basic.rentcar.frontcontroller.Controller;
import com.basic.rentcar.vo.CarViewVO;
import com.basic.rentcar.vo.MemberVO;

public class CarReserveViewController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		MemberVO memVO = (MemberVO) session.getAttribute("user");
		if (memVO == null) {
			System.out.println("로그인을 먼저 해주세요.");
			return "main";
		}
		String id = memVO.getId();
		ArrayList<CarViewVO> viewList = CarViewDAO.getInstance().getAllReserve(id);
		session.setAttribute("viewList", viewList);
		return "14_carReserveView";
	}
}
