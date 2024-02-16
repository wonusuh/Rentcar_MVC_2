<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/style_top.css" rel="stylesheet" type="text/css">
<title>Rentcar MVC 2</title>
</head>
<body>
	<div align="center">

		<header>
			<div class="logo" onclick="location.href='${ctx}/main.jsp'">
				<img alt="홈으로" src="${ctx}/img/rent_logo.jpg" />
			</div>
			<c:if test="${user eq null}">
				<div class="log">GUEST 님</div>
			</c:if>
			<c:if test="${user ne null and user.getId() ne 'admin'}">
				<div class="log">${user.id}님</div>
			</c:if>
			<c:if test="${user.getId() eq 'admin'}">
				<div class="log">관리자 님</div>
			</c:if>
		</header>

		<div class="top-menu">
			<div onclick="location.href='${ctx}/rentcarReserveMain.do'">예 약
				하 기</div>
			<div onclick="location.href='${ctx}/carReserveView.do'">예 약 확 인</div>
			<c:if test="${user eq null}">
				<div onclick="location.href='${ctx}/memberLogin.do'">로 그 인</div>
				<div onclick="location.href='${ctx}/memberJoin.do'">회 원 가 입</div>
			</c:if>
			<c:if test="${user ne null and user.getId() ne 'admin'}">
				<div onclick="location.href='${ctx}/memberLogout.do'">로 그 아 웃</div>
				<div onclick="location.href='${ctx}/memberQuit.do'">회 원 탈 퇴</div>
			</c:if>
			<c:if test="${user.getId() eq 'admin'}">
				<div onclick="location.href='${ctx}/memberLogout.do'">로 그 아 웃</div>
				<div onclick="location.href='${ctx}/adminAddCar.do'">차량 등록하기</div>
			</c:if>
		</div>
	</div>