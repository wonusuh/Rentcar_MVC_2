package com.basic.rentcar.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.basic.rentcar.frontcontroller.Controller;
import com.basic.rentcar.model.dao.MemberDAO;
import com.basic.rentcar.model.vo.MemberVO;

public class MemberLoginController implements Controller {
	@Override
	public String requestHandler(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		if (id == null || pw == null)
			return "05_memberLogin";
		MemberDAO mDAO = MemberDAO.getInstance();
		MemberVO vo = mDAO.getMember(id, pw);
		if (vo != null) {
			System.out.println("[ 로그인에 성공했습니다. ]");
			HttpSession session = req.getSession();
			System.out.println(vo);
			session.setAttribute("user", vo);
			return "main";
		} else {
			System.out.println("[ 로그인에 실패했습니다. ]");
			return "05_memberLogin";
		}
	}
}
