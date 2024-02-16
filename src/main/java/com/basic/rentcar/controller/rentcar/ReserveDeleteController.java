package com.basic.rentcar.controller.rentcar;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.basic.rentcar.frontcontroller.Controller;
import com.basic.rentcar.model.dao.CarViewDAO;

public class ReserveDeleteController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		int resSeq = Integer.parseInt(req.getParameter("resSeq"));
		int qty = Integer.parseInt(req.getParameter("qty"));
		int no = Integer.parseInt(req.getParameter("no"));
		System.out.println("resSeq == " + resSeq);
		System.out.println("qty == " + qty);
		System.out.println("no == " + no);
		CarViewDAO cvd = CarViewDAO.getInstance();
		cvd.carRemoveReserve(resSeq, qty, no);
		String ctx = req.getContextPath();
		return "redirect:" + ctx + "/carReserveView.do";
	}
}
