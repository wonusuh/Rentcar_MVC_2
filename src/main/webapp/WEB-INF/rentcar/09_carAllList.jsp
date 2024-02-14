<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="02_top.jsp"%>
<div align="center">
	<table>
		<tr height="60">
			<td align="center" colspan="3"><font size="6" color="gray">${carSize}
					자동차</font></td>
		</tr>
		<c:forEach var="vo" items="${list}">
			<tr>
				<td width="500" align="center"><a
					href="${ctx}/carReserveInfo.do?no=${vo.getNo()}"> <img alt=""
						src="img/${vo.getImg()}" width="500" height="250">
				</a></td>
				<td align="center" width="500"><font size="3" color="gray"><b>차량명
							| ${vo.getName()}</b></font></td>
			</tr>
		</c:forEach>
	</table>
</div>
<%@include file="03_bottom.jsp"%>
