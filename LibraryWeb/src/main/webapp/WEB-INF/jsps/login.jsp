<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Log in page</title>
<link href="<c:url value = '/resources/css/main.css'/>" rel="stylesheet"
	type="text/css" />
<link href="<c:url value = '/resources/css/login.css'/>"
	rel="stylesheet" type="text/css" />
</head>
<!-- This is a login page -->
<%@ page session="false"%>
<body onload='document.form.username.focus();'>

	<!--banner-->
	<div class="banner"></div>
	<!--CSS  banner-->


	<hr />
	<!--horizontal  line -->

	<!--main body-->

	<div class="main_body">
		<div>
			<img src="<c:url value='/resources/img/board.jpg'/>" />
		</div>
		<div id="content">
			<!-- servlet redirection URL-->
			<c:url value='/j_spring_security_check' var='security_gateway' />
			<form:form method="POST"
				action="${security_gateway}"
				modelAttribute="userLogin" name="form">
				<h1>Library Login</h1>
				<div>
					<form:input path="username" placeholder="Username" required=""
						id="username" name="j_username" />
					<form:errors path="username" cssClass="error" />
				</div>
				<div>
					<form:input path="password" placeholder="Password" required=""
						id="password" name="j_password" type="password" />
					<form:errors path="password" cssClass="error" />
				</div>
				<div class="error">
					<c:if test="${userLogin.errorFindingUser!=null}">
						<c:out value="${userLogin.errorFindingUser}" />
					</c:if>
				</div>
				<div class="clear"></div>
				<div>
					<input type="submit" value="Log in" /> <a href="#">Lost your
						password?</a> <a href="<c:url value = 'registration'/>">Register</a>
				</div>
			</form:form>
		</div>
	</div>

	<!-- Footer banner-->
	<div class="footer">
		<p>
			Copyright 2013 | SofTech Developers| All Rights Reserved<br /> CSU
			ITC 303/9
		</p>
	</div>
</body>
</html>
