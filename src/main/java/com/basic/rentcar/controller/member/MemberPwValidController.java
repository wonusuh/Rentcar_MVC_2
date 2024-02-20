package com.basic.rentcar.controller.member;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.basic.rentcar.frontcontroller.Controller;
import com.basic.rentcar.model.dao.CarViewDAO;
import com.basic.rentcar.model.dao.MemberDAO;
import com.basic.rentcar.model.vo.MemberVO;

public class MemberPwValidController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		String inputPw = req.getParameter("inputPw");
		MemberVO user = (MemberVO) session.getAttribute("user");
		System.out.println(user);
		System.out.println("myPw == " + user.getPw());
		System.out.println("inputPw == " + inputPw);
		if (inputPw.equals(user.getPw())) {
			MemberDAO mDao = MemberDAO.getInstance();
			CarViewDAO cvDAO = CarViewDAO.getInstance();

			ArrayList<int[]> returnedCarsList = mDao.getReturnedCarsList(user.getId());
			// 1
			for (int i = 0; i < returnedCarsList.size(); i += 1) {
				int no = returnedCarsList.get(i)[0];
				int qty = returnedCarsList.get(i)[1];
				cvDAO.backRentcarQty(no, qty);
			}
			// 2
			mDao.deleteAllReservationById(user.getId());
			// 3
			mDao.deleteUserFromDB(user);

			session.invalidate();
			res.getWriter().print("valid");
		} else {
			res.getWriter().print("notValid");
		}
		return null;
	}
}
