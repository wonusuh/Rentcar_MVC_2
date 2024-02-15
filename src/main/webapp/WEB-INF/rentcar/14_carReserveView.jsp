<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="./02_top.jsp"%>
<div align="center">
	<table>
		<tr height="100">
			<td align="center" colspan="11"><font size="6" color="gray">
					차량 예약 완료 화면 </font></td>
		</tr>
	</table>
	<table border="1">
		<tr height="40">
			<td width="150" align="center">이미지</td>
			<td width="150" align="center">이름</td>
			<td width="150" align="center">대여일</td>
			<td width="60" align="center">대여기간</td>
			<td width="100" align="center">금액</td>
			<td width="60" align="center">수량</td>
			<td width="60" align="center">보험</td>
			<td width="60" align="center">wifi</td>
			<td width="60" align="center">베이비시트</td>
			<td width="60" align="center">네비게이션</td>
			<td width="90" align="center">삭제</td>
		</tr>
		<c:forEach var="viewVO" items="${viewList}">
			<tr height="70">
				<td height="70" align="center"><img
					src="Uploads/${viewVO.getImg()}" width="120" height="70"></td>
				<td width="100" align="center">${viewVO.getName()}</td>
				<td width="150" align="center">${viewVO.getRday()}</td>
				<td width="150" align="center">${viewVO.getDday()}</td>
				<td width="100" align="center">${viewVO.getPrice()}원</td>
				<td width="60" align="center">${viewVO.getQty()}</td>
				<td width="100" align="center">${viewVO.getUsein()}</td>
				<td width="60" align="center">${viewVO.getUsewifi()}</td>
				<td width="60" align="center">${viewVO.getUseseat()}</td>
				<td width="60" align="center">${viewVO.getUsenavi()}</td>
				<td width="90" align="center">
					<button
						onclick="location.href='${ctx}/reserveDelete.do?resSeq=${viewVO.getReserveSeq()}&qty=${viewVO.getQty()}&no=${viewVO.getNo()}'">삭제</button>
				</td>
			</tr>
		</c:forEach>
	</table>
</div>
<%@include file="./03_bottom.jsp"%>
