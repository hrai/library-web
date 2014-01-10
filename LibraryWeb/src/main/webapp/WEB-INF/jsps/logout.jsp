<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Logout</title>
<link href="<c:url value = '/resources/css/main.css'/>" rel="stylesheet"
	type="text/css" />
<link href="<c:url value = '/resources/css/form.css'/>" rel="stylesheet"
	type="text/css" />
<script type="text/javascript"
	src="<c:url value='/resources/javascript/super.js'/>">
	
</script>
</head>
<%@ page session="false"%>
<body>
	<div class="banner"></div>
	<!--CSU  banner-->
	<hr />

	<div class="main_body">

		<div style="padding: 200px; align: center;">
			<h3 align="center">You have been successfully logged out.</h3>
			<div style="align: center; padding-left: 250px;">
				<input type="button" value="LOGIN PAGE" onclick="goToLoginPage();" />
			</div>
		</div>
	</div>
</body>
</html>