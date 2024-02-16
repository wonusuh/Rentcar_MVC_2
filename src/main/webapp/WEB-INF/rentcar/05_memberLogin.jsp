<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="./02_top.jsp"%>
<link href="css/style_loginForm.css" rel="stylesheet" type="text/css">
<div class="loginForm">
	<form action="${ctx}/memberLogin.do" method="post">
		<table border="1">
			<tr height="100">
				<td align="center" colspan="2"><font size="6" color="gray">
						로그인 </font></td>
			</tr>
			<tr height="50">
				<td width="120" align="center">아이디</td>
				<td width="180" align="center"><input type="text" name="id" required="required"
					size="20" /></td>
			</tr>
			<tr height="50">
				<td width="120" align="center">패스워드</td>
				<td width="180" align="center"><input type="password" name="pw"
					required="required" size="20" /></td>
			</tr>
			<tr height="50">
				<td align="center" colspan="2">
					<button>로그인</button>
				</td>
			</tr>
		</table>
	</form>
</div>
<%@include file="./03_bottom.jsp"%>
