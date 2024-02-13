<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 <%
 		String id = (String) session.getAttribute("id");
 		
 		if (id == null) {
 %>
	<script type="text/javascript">
		alert("로그인을 먼저 해주세요.");
		location.href = '01_carMain.jsp?center=05_memberLogin.jsp';
	</script>
	
	
	<%
       return;
 		} 
 		%>	
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<%
		int no = Integer.parseInt(request.getParameter("no"));

		// 수량
		int qty = Integer.parseInt(request.getParameter("qty"));
		// 이미지
		String img = request.getParameter("img");
	%>


	<form action="01_carMain.jsp?center=12_carReserveResult.jsp"
		method="post">
		<table>
			<tr height="100">
				<td align="center" colspan="3"><font size="6" color="gray">
						옵션 선택</font></td>
			</tr>
			<tr>
				<td rowspan="7" width="500" align="center"><img alt=""
					src="img/<%=img%>" width="450"></td>
				<td width="250" align="center">대여기간</td>
				<td width="250" align="center"><select name="dday">
						<option value="1">1일</option>
						<option value="2">2일</option>
						<option value="3">3일</option>
						<option value="4">4일</option>
						<option value="5">5일</option>
						<option value="6">6일</option>
						<option value="7">7일</option>
				</select></td>
			</tr>
			<tr>
				<td width="250" align="center">대여일</td>
				<td width="250" align="center"><input type="date" name="rday" id="today"
					size="15"></td>
			</tr>
			<script>
				document.getElementById("today").value= new Date().toISOString().substring(0,10);
			</script>
			
			<tr>
				<td width="250" align="center">보험적용</td>
				<td width="250" align="center"><select name="usein">
						<option value="1">적용(1일 1만원)</option>
						<option value="2">비적용</option>
				</select></td>
			</tr>
			<tr>
				<td width="250" align="center">Wifi 적용</td>
				<td width="250" align="center"><select name="usewifi">
						<option value="1">적용(1일 1만원)</option>
						<option value="2">비적용</option>
				</select></td>
			</tr>
			<tr>
				<td width="250" align="center">네비게이션 적용</td>
				<td width="250" align="center"><select name="usenavi">
						<option value="1">적용(무료)</option>
						<option value="2">비적용</option>
				</select></td>
			</tr>
			<tr>
				<td width="250" align="center">베이비시트 적용</td>
				<td width="250" align="center"><select name="useseat">
						<option value="1">적용(1일 1만원)</option>
						<option value="2">비적용</option>
				</select></td>
			</tr>
			<tr>
				<td align="center" colspan="2"><input type="hidden" name="no"
					value="<%=no%>"> <input type="hidden" name="qty"
					value="<%=qty%>"> <input type="submit" value="차량예약하기" /></td>
			</tr>

		</table>
	</form>

</body>
</html>