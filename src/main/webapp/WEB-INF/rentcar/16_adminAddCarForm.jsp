<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="./02_top.jsp"%>
<div align="center">
	<form class="addCarForm" method="post" action="${ctx}/adminAddCar.do">
		<table border="1">
			<tr>
				<td>name VARCHAR(20), -- 차량 이름</td>
				<td><input type="text" name="name" required="required" /></td>
			</tr>
			<tr>
				<td>category INT, -- 차량 종류</td>
				<td><input type="text" name="category" required="required" /></td>
			</tr>
			<tr>
				<td>price INT, -- 렌트 가격</td>
				<td><input type="text" name="price" required="required" /></td>
			</tr>
			<tr>
				<td>usepeople INT, -- 승차 인원</td>
				<td><input type="text" name="usepeople" required="required" /></td>
			</tr>
			<tr>
				<td>total_qtyrentcar int, -- 렌트카 총 수량</td>
				<td><input type="text" name="total_qtyrentcar"
					required="required" /></td>
			</tr>
			<tr>
				<td>company VARCHAR(50), -- 차량 회사 정보</td>
				<td><input type="text" name="company" required="required" /></td>
			</tr>
			<tr>
				<td>info VARCHAR(500), -- 차량 정보</td>
				<td><input type="text" name="info" required="required" /></td>
			</tr>
		</table>
		<button>이미지 등록하기</button>
	</form>
</div>
<%@include file="./03_bottom.jsp"%>
