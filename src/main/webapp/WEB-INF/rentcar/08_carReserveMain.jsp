<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="./02_top.jsp"%>
<link href="css/style_carReserveMain.css" rel="stylesheet"
	type="text/css">
<div align="center">
	<div class="carReserveMain">
		<div align="center">
			<font size="6" color="gray">최신형 자동차</font> <br> <br>
		</div>
		<div class="carList">
			<c:forEach var="vo" items="${list}">
				<div
					onclick="location.href='${ctx}/carReserveInfo.do?no=${vo.getNo()}'">
					<img alt="temp image" src="Uploads/${vo.getImg()}">
					<p>${vo.getName()}</p>
				</div>
			</c:forEach>
		</div>

		<!-- ================================================== -->

		<br>
		<div class="line"></div>
		<p>
			<font size="4" color="gray"><b>차량 검색 하기</b></font>
		<form action="${ctx}/carCategoryList.do" method="post">
			<font size="3" color="gray"><b>차량 검색 하기</b></font>&nbsp;&nbsp; <select
				name="category">
				<option value="1">소형</option>
				<option value="2">중형</option>
				<option value="3">대형</option>
			</select> <input type="submit" value="검색" />&nbsp;&nbsp;
		</form>
		<%-- button은 form 밖에 위치시키기 --%>
		<div>
			<button onclick="location.href='carAllList.do'">전체 검색</button>
		</div>
	</div>
</div>
<%@include file="./03_bottom.jsp"%>