<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="./02_top.jsp"%>
<div align="center">
	<table>
		<tr height="100">
			<td align="center"><font size="6" color="gray"> 차량 예약 완료
					화면 </font></td>
		</tr>
		<tr height="100">
			<td align="center"><img src="Uploads/${carVO.getImg()}" width="470" /></td>
		</tr>
		<tr height="50">
			<td align="center"><font size="5" color="red"> 차량 총예약 금액
					${reserveFee} 원 </font></td>
		</tr>
		<tr height="50">
			<td align="center"><font size="5" color="red"> 차량 총옵션 금액
					${optionFee} 원 </font></td>
		</tr>
		<tr height="50">
			<td align="center"><font size="5" color="red"> 차량 총 금액
					${total} 원 </font></td>
		</tr>
	</table>
</div>
<%@include file="./03_bottom.jsp"%>
