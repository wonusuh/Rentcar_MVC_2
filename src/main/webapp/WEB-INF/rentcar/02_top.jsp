<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr height="70">
			<td colspan="4"><a href="${ctx}/01_carMain.jsp"
				style="text-decoration: none"> <img alt="홈으로"
					src="${ctx}/img/rent_logo.jpg" height="120">
			</a></td>
<%
	
%>
			<c:if test="${log eq null}">
				<td align="center" width="200">GUEST 님
					<button
						onclick="location.href='${ctx}/memberLogin.do'">로그인</button>
				</td>
			</c:if>
			<c:if test="${log ne null}">
				<td align="center" width="200">${vo.id}님
					<button onclick="location.href='07_memberLogout.jsp'">로그아웃</button>
				</td>
			</c:if>
		</tr>

		<tr height="50">
			<td align="center" width="200" bgcolor="pink"><font
				color="white" size="5"><a
					href="01_carMain.jsp?center=08_carReserveMain.jsp"
					style="text-decoration: none">예 약 하 기</a></font></td>
			<td align="center" width="200" bgcolor="pink"><font
				color="white" size="5"><a
					href="01_carMain.jsp?center=14_carReserveView.jsp"
					style="text-decoration: none">예 약 확 인</a></font></td>
			<td align="center" width="200" bgcolor="pink"><font
				color="white" size="5"><a href="#"
					style="text-decoration: none">자유게시판</a></font></td>
			<td align="center" width="200" bgcolor="pink"><font
				color="white" size="5"><a href="#"
					style="text-decoration: none">이 벤 트</a></font></td>
			<td align="center" width="200" bgcolor="pink"><font
				color="white" size="5"><a href="#"
					style="text-decoration: none">고 객 센 터</a></font></td>
		</tr>
	</table>
</body>
</html>
