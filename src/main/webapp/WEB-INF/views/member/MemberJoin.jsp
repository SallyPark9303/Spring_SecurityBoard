<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<%@include file="../includes/header.jsp"%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form name="form1" method="post" action="/member/MemberJoin">
	<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }"/>	
		<table align="center">
		<tr>
			<td  colspan="2">
			<p align="center"><b>회원가입</b></p>
			</td>
		</tr>
		<tr>
			<td colspan="2">
			<hr>
			</td>
		</tr>
		<tr>
			<td width="104">
			<p><code><b>아이디</b></code></p>
			</td>
			<td width="359">
			<p><code><input type="text" name="userid" size="30"></code></p>
			</td>
		</tr>
		<tr>
			<td width="104">
			<p><code><b>비밀번호</b></code></p>
			</td>
			<td width="359">
			<p><code><input type="password" name="userpw" size="30"></code></p>
			</td>
		</tr>
		<tr>
			<td width="104">
			<p><code><b>성명</b></code></p>
			</td>
			<td width="359">
			<p><code><input type="text" name="userName" size="30"></code></p>
			</td>
		</tr>
		<tr>
			<td width="479" colspan="2">
			<p align="center">
			<input type="submit" name="formbutton1"	value="회원가입"></p>
			</td>
		</tr>
		</table>
	</form>
</body>
</html>


<%@include file="../includes/footer.jsp" %>
