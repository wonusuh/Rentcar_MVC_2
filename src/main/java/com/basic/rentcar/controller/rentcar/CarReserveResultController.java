package com.basic.rentcar.controller.rentcar;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.basic.rentcar.dao.CarReserveDAO;
import com.basic.rentcar.frontcontroller.Controller;
import com.basic.rentcar.vo.CarReserveVO;
import com.basic.rentcar.vo.CarVO;
import com.basic.rentcar.vo.MemberVO;

public class CarReserveResultController implements Controller {
	@Override
	public String requestHandler(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();

		MemberVO memVO = (MemberVO) session.getAttribute("user");
		String id = memVO.getId();
		CarVO carVO = (CarVO) session.getAttribute("carVO");
		CarReserveVO resVO = new CarReserveVO();

		resVO.setNo(carVO.getNo());
		resVO.setId(id);

		int qty = Integer.parseInt(String.valueOf(session.getAttribute("qty")));
		resVO.setQty(qty);
		System.out.println("qty : " + qty);

		int rentalDuration = Integer.parseInt(req.getParameter("dday"));
		resVO.setDday(rentalDuration);
		System.out.println("rentalDuration : " + rentalDuration);

		String rday = req.getParameter("rday");
		//

		// 날짜 비교
		Date d1 = new Date();
		Date d2 = new Date();

		//
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			d1 = sdf.parse(rday);
			d2 = sdf.parse(sdf.format(d2)); // format() 메서느는 SimpleDateFormat과 같은 역할(yyyy-MM-dd)
		} catch (ParseException e) {
			e.printStackTrace();
		}

		// 날짜비교 메서드 사용
		int compare = d1.compareTo(d2);
		// 예약하려는 날짜가 현재 날짜보다 이전이라면 -1
		// 예약하려는 날짜와 현재 날짜가 같다면 0
		// 예약하려는 날짜가 현재 날짜보다 이후라면 1을 리턴
		// System.out.println(compare);
		if (compare < 0) {
			// 오늘보다 이전 날짜를 선택했을 시
			System.out.println("현재 시스템 날짜보다 이전 날짜는 선택할 수 없음");
			return "11_carOptionSelect";
		}

		//
		resVO.setRday(rday);
		System.out.println("rday : " + rday);

		int insurance = Integer.parseInt(req.getParameter("usein"));
		resVO.setUsein(insurance);
		if (insurance == 1) {
			insurance = rentalDuration * 10000;
		} else {
			insurance = 0;
		}
		System.out.println("insurance : " + insurance);

		int wifi = Integer.parseInt(req.getParameter("usewifi"));
		resVO.setUsewifi(wifi);
		if (wifi == 1) {
			wifi = rentalDuration * 10000;
		} else {
			wifi = 0;
		}
		System.out.println("wifi : " + wifi);

		int navi = Integer.parseInt(req.getParameter("usenavi"));
		resVO.setUsenavi(navi);
		if (navi == 1) {
			navi = rentalDuration * 0;
		} else {
			navi = 0;
		}
		System.out.println("navi : " + navi);

		int seat = Integer.parseInt(req.getParameter("useseat"));
		resVO.setUseseat(seat);
		if (seat == 1) {
			seat = rentalDuration * 10000;
		} else {
			seat = 0;
		}
		System.out.println("seat : " + seat);

		CarReserveDAO rDAO = CarReserveDAO.getInstance();
		rDAO.setReserveCar(resVO, qty);

		int reserveFee = qty * rentalDuration * carVO.getPrice();
		int optionFee = (insurance + wifi + navi + seat) * qty;
		int total = reserveFee + optionFee;
		session.setAttribute("reserveFee", reserveFee);
		session.setAttribute("optionFee", optionFee);
		session.setAttribute("total", total);
		System.out.printf("%d %d %d\n", reserveFee, optionFee, total);

		return "12_carReserveResult";
	}
}
