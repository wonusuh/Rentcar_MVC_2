<%@page import="com.basic.rentcar.dao.RentcarDao"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% request.setCharacterEncoding("UTF-8"); %>

	<%
	    	String id = request.getParameter("id"); 
			String pw = request.getParameter("pw");
			
			// 회원 아이디와 패스워드가 일치하는지 비교
			RentcarDao rdao = RentcarDao.getInstance();
			
			// 해당 회원이 있는지 여부를 숫자로 표현
			int result = rdao.getMember(id, pw);	
			if(result == 0){
	%>
	<script>
			alert("회원 아이디 또는 패스워드가 틀립니다.");
			location.href='01_carMain.jsp?center=05_memberLogin.jsp';
		</script>
	<%
		}else{	
			// 로그인 처리가 되었다면,
			session.setAttribute("id", id);
			response.sendRedirect("01_carMain.jsp");
	%>

	<%
		}
	%>
</body>
</html>