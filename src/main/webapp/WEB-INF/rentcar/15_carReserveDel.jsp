
<%@page import="com.basic.rentcar.dao.TempRentcarDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	int resSeq = Integer.parseInt(request.getParameter("resSeq"));
		int qty = Integer.parseInt(request.getParameter("qty"));
		int no = Integer.parseInt(request.getParameter("no"));
		TempRentcarDao rdao = TempRentcarDao.getInstance();
		// 예약삭제 메소드 호출
		rdao.carRemoveReserve(resSeq,qty,no);
		response.sendRedirect("01_carMain.jsp?center=14_carReserveView.jsp");
	%>
</body>
</html>