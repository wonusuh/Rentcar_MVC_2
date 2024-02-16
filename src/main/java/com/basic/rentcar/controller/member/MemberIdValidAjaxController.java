package com.basic.rentcar.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.basic.rentcar.frontcontroller.Controller;
import com.basic.rentcar.model.dao.MemberDAO;

public class MemberIdValidAjaxController implements Controller {
	@Override
	public String requestHandler(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String inputId = req.getParameter("id");
		System.out.println("inputId : " + inputId);
		String isTherePw = MemberDAO.getInstance().checkMemberId(inputId);
		System.out.println("isTherePw : " + isTherePw);
		String passData = "notValid";
		if (isTherePw == null)
			passData = "valid";
		System.out.println("passData : " + passData);
		res.getWriter().print(passData);
		return null;
	}
}
