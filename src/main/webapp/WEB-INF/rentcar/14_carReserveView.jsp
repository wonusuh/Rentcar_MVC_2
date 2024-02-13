
<%@page import="java.util.ArrayList"%>
<%@page import="com.basic.rentcar.vo.CarViewVO"%>
<%@page import="com.basic.rentcar.dao.RentcarDao"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

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
						
			RentcarDao rdao = RentcarDao.getInstance();
			ArrayList<CarViewVO> v = rdao.getAllReserve(id);
%> 
 <div align="center">
		<table>
			<tr height="100">
				<td align="center" colspan="11"> 
					<font size="6" color="gray"> 차량 예약 완료 화면 </font> 
				</td>
			</tr>
		</table>
		<table border="1">
			<tr height="40">
				<td width="150" align="center"> 이미지 </td>
				<td width="150" align="center"> 이름 </td>
				<td width="150" align="center"> 대여일 </td>
				<td width="60" align="center"> 대여기간 </td>
				<td width="100" align="center"> 금액 </td>
				<td width="60" align="center"> 수량 </td>
				<td width="60" align="center"> 보험 </td>
				<td width="60" align="center"> wifi </td>
				<td width="60" align="center"> 베이비시트 </td>
				<td width="60" align="center"> 네비게이션 </td>
				<td width="90" align="center"> 삭제 </td>
			</tr>
	<%
	for(CarViewVO bean : v){
	%>		
		<tr height="70">	
			<td height="70" align="center">
				<img src="img/<%=bean.getImg() %>"  width="120" height="70">
			</td>
			<td width="100" align="center"><%=bean.getName() %></td>
			<td width="150" align="center"><%=bean.getRday() %></td>
			<td width="150" align="center"><%=bean.getDday() %></td>
			<td width="100" align="center"><%=bean.getPrice() %> 원</td>
			<td width="60" align="center"><%=bean.getQty() %></td>
			<td width="100" align="center"><%=bean.getUsein() %></td>
			<td width="60" align="center"><%=bean.getUsewifi() %></td>
			<td width="60" align="center"><%=bean.getUseseat() %></td>
			<td width="60" align="center"><%=bean.getUsenavi() %></td>
			<td width="90" align="center">
				<button onclick="location.href='15_carReserveDel.jsp?resSeq=<%=bean.getReserveSeq()%>&qty=<%=bean.getQty()%>&no=<%=bean.getNo()%>'">삭제</button>
			</td>
			
		</tr>

	<%
	}
	%>			
			
		</table>
	</div>
</body>
</html>