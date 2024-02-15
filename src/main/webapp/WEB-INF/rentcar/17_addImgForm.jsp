<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="./02_top.jsp"%>
<div align="center">${newCar}
	<form action="${ctx}/addImage.do" method="post"
		enctype="multipart/form-data">
		<input type="file" name="img" /> <input type="submit"
			value="서버로 이미지 전송하기">
	</form>
</div>
<%@include file="./03_bottom.jsp"%>
