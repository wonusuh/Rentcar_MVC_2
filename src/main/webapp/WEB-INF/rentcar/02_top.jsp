<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/style.css" rel="stylesheet" type="text/css">
<title>Rentcar MVC 2</title>
</head>
<body>
	<div align="center">
		<table>
			<tr height="70">
				<td colspan="4"><a href="${ctx}/main.jsp"
					style="text-decoration: none"> <img alt="홈으로"
						src="${ctx}/img/rent_logo.jpg" height="120">
				</a></td>
				<c:if test="${user eq null}">
					<td align="center" width="200">GUEST 님
						<button onclick="location.href='${ctx}/memberLogin.do'">로그인</button>
						<button onclick="location.href='${ctx}/memberJoin.do'">회원가입</button>
					</td>
				</c:if>
				<c:if test="${user ne null and user.getId() ne 'admin'}">
					<td align="center" width="200">${user.id}님
						<button onclick="location.href='${ctx}/memberLogout.do'">로그아웃</button>
						<button onclick="location.href='${ctx}/memberQuit.do'">회원탈퇴</button>
					</td>
				</c:if>
				<c:if test="${user.getId() eq 'admin'}">
					<td align="center" width="200">관리자 님
						<button onclick="location.href='${ctx}/memberLogout.do'">로그아웃</button>
						<button onclick="location.href='${ctx}/adminAddCar.do'">차량등록하기</button>
					</td>
				</c:if>
			</tr>
			<tr height="50">
				<td align="center" width="200" bgcolor="pink"><font
					color="white" size="5"><a
						href="${ctx}/rentcarReserveMain.do" style="text-decoration: none">예
							약 하 기</a></font></td>
				<td align="center" width="200" bgcolor="pink"><font
					color="white" size="5"><a href="${ctx}/carReserveView.do"
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
	</div>