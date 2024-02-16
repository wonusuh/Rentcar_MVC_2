package com.basic.rentcar.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.basic.rentcar.frontcontroller.Controller;
import com.basic.rentcar.model.dao.MemberDAO;
import com.basic.rentcar.model.vo.MemberVO;

public class MemberJoinController implements Controller {
	@Override
	public String requestHandler(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		if (req.getParameter("id") == null) {
			return "18_memberJoinForm";
		}
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		String email = req.getParameter("email");
		String tel = req.getParameter("tel");
		String hobby = req.getParameter("hobby");
		String job = req.getParameter("job");
		String age = req.getParameter("age");
		String info = req.getParameter("info");
		System.out.println("id " + id);
		System.out.println("pw " + pw);
		System.out.println("email " + email);
		System.out.println("tel " + tel);
		System.out.println("hobby " + hobby);
		System.out.println("job " + job);
		System.out.println("age " + age);
		System.out.println("info " + info);
		MemberVO vo = new MemberVO();
		vo.setId(id);
		vo.setPw(pw);
		vo.setEmail(email);
		vo.setTel(tel);
		vo.setHobby(hobby);
		vo.setJob(job);
		vo.setAge(age);
		vo.setInfo(info);
		int cnt = MemberDAO.getInstance().memberInsert(vo);
		if (cnt > 0) {
			return "main";
		} else {
			throw new ServletException("not insert");
		}
	}
}
