<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<%@include file="includes/header.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

 

</head>



<body>
	<h1>Custom Login Page</h1>
	<h2><c:out value="${error }"/></h2>
	<h2><c:out value="${logout }"/></h2>

	
	<form role="form" method="post" action="/login">
	<fieldset>
	
	<div class="form-group">
	<input class="form-control" placeholder="userid"
	name="username" type="text" autofocus>
	</div>
	<div class="form-group">
	<input class="form-control" placeholder="Password"
	name="password" type="password" value="">
	</div>
	<div class="checkbox">
	<label><input name="remember-me" type="checkbox">Remember me</label>
	</div>
	<!-- Change this to a button or input when using this as a form-->
	<button type="submit" id=loginBtn class="btn btn-lg btn-success btn-block">Login</button>
		<button type="button" id=JoinBtn class="btn btn-lg btn-success btn-block" onclick="location.href='/member/MemberJoin'">회원가입</button>
	</fieldset>
	<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }"/>	
	</form>
	
</body>





</html>



<%@include file="includes/footer.jsp" %>