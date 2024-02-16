<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="02_top.jsp"%>
<link href="css/style_carByCategory.css" rel="stylesheet"
	type="text/css">
<div class="carByCategory">
	<div>
		<font size="6" color="gray">모든 차량 보기</font>
	</div>
	<br> <br>
	<c:forEach var="carVO" items="${list}">
		<div class="singleRow"
			onclick="location.href='${ctx}/carReserveInfo.do?no=${carVO.getNo()}'">
			<div>
				<img alt="temp car image" src="Uploads/${carVO.getImg()}" />
			</div>
			<div>
				<font size="5"><b>${carVO.getName()}</b></font> <br> <font
					size="4" color="gray"> <b>${carVO.getInfo()}</b></font>
			</div>
		</div>
	</c:forEach>
</div>
<%@include file="03_bottom.jsp"%>
