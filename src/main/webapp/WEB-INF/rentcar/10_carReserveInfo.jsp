<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="./02_top.jsp"%>
<div align="center">
	<form action="${ctx}/carOptionSelect.do?no=${carVO.getNo()}"
		method="post">
		<table>
			<tr height="100">
				<td align="center" colspan="3"><font size="6" color="gray">
						${carVO.getName()} 차량 선택 </font></td>
			</tr>
			<tr>
				<td rowspan="6" width="500" align="center"><img alt=""
					src="img/${carVO.getImg()}" width="450"></td>
				<td width="250" align="center">차량이름</td>
				<td width="250" align="center">${carVO.getName()}</td>
			</tr>

			<tr>
				<td width="250" align="center">총 승차인원</td>
				<td width="250" align="center">${carVO.getUsepeople()}</td>
			</tr>
			<tr>
				<td width="250" align="center">차량수량</td>
				<td width="250" align="center"><select name="qty">
						<c:forEach var="i" begin="1" end="${carVO.getTotalQty()}">
							<option value="${i}">${i}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td width="250" align="center">차량분류</td>
				<td width="250" align="center">${carSize}</td>
			</tr>
			<tr>
				<td width="250" align="center">대여가격</td>
				<td width="250" align="center">${carVO.getPrice()}원</td>
			</tr>
			<tr>
				<td width="250" align="center">제조회사</td>
				<td width="250" align="center">${carVO.getCompany()}</td>
			</tr>
			<tr>
				<td width="250" height="100" align="center"><c:if
						test="${carVO.getTotalQty() eq 0}">
						<input type="button" value="모든 차량이 렌트중입니다." />
					</c:if></td>
				<td><c:if test="${user ne null}">
						<input type="submit" value="옵션선택후 렌트 예약 하기" />
					</c:if></td>
			</tr>
		</table>
		<br /> <br /> <br /> <font size="5" color="gray">차랑 정보 보기</font>
		<p>${carVO.getInfo()}</p>
	</form>
</div>
<%@include file="./03_bottom.jsp"%>
