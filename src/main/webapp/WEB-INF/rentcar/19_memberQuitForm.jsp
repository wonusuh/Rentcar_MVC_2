<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./02_top.jsp"%>
<div align="center">
	<h1>[ 회원탈퇴 ] 비밀번호를 확인합니다.</h1>
	<form action="#" method="post">
		<input name="pw" id="pw" type="password" required="required" /> <input
			type="button" value="탈퇴하기" onclick="checkPw(form)" />
	</form>
</div>
<script type="text/javascript">
	let check = 0;
	function checkPw(form) {
		const inputPw = form.pw.value;
		console.log(inputPw);
		fetch("memberPwValid.do", {
			method : "POST",
			headers : {"Content-Type": "application/x-www-form-urlencoded; charset=UTF-8",},
			body : "inputPw=" + inputPw,
		})
		.then(response => response.text())
		.then(getResult)
		.catch((error) => console.log("error : ", error))
	}
	function getResult(data){
		if(data === "valid") {
			location.href="${ctx}/main.jsp"
			alert("탈퇴 성공");
		}else if(data === "notValid"){
			alert(`비밀번호를 확인하세요.`);
		}
	}
</script>
<%@ include file="./03_bottom.jsp"%>
