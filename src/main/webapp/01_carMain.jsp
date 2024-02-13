<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>rentcar MVC2</title>
</head>
<body>
	<div align="center">
		<%
		String center = request.getParameter("center");

		// 처음 실행시에는 center값이 넘어오지 않기에
		// null처리 해줌
		if (center == null) {
			center = "/WEB-INF/rentcar/04_center.jsp"; // defulat center값을 부여
		}
		%>
		<table>
			<%-- top 부분 --%>
			<tr height="120" align="center">
				<td align="center" width="1000"><jsp:include
						page="WEB-INF/rentcar/02_top.jsp"></jsp:include></td>
			</tr>
			<%-- center 부분 --%>
			<tr align="center">
				<td align="center" width="1000"><jsp:include page="<%=center%>" /></td>
			</tr>
			<%-- bottom 부분 --%>
			<tr height="100" align="center">
				<td align="center" width="1000"><jsp:include
						page="WEB-INF/rentcar/03_bottom.jsp"></jsp:include></td>
			</tr>
		</table>
	</div>
</body>
</html>
