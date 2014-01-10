<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Update User Info Page</title>
<link href="<c:url value = '/resources/css/main.css'/>" rel="stylesheet"
	type="text/css" />
<link href="<c:url value = '/resources/css/form.css'/>" rel="stylesheet"
	type="text/css" />
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.2/themes/smoothness/jquery-ui.css" />
</head>
<script type="text/javascript" src="<c:url value='/resources/javascript/super.js'/>"></script>
<script src="//ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js"></script>
<script
	src="//ajax.googleapis.com/ajax/libs/jqueryui/1.10.2/jquery-ui.min.js"></script>

<!-- This is a main page -->

<body>
	<div class="banner"></div>
	<!--CSU  banner-->
	<hr />

	<div class="main_body">
		<!-- Navigation Menu -->

		<ul id="menu" class="black">
			<li><a href="<c:url value='/welcome'/>">Home</a></li>
			<li><a href="<c:url value='/edit_user_details'/>">Edit User	Info</a></li>
			<li><a href="<c:url value='/faq'/>">FAQ</a></li>
			<li><a href="<c:url value='/contact_us/'/>">Contact Us</a></li>
			<li><a href="<c:url value='/feedback_form'/>">Feedback</a></li>
			<li><a href="<c:url value = '/logout' />">Log out</a></li>
		</ul>
		<!--- End of menu-->





		<table class="side_bar">
			<tr>
				<td id="side_bar">
					<div id="side_bar">
						<hr>
						<c:if test="${isLibrarian == true}">
							<a href="<c:url value='/catalogue_entry_form'/>">Add
								Catalogue Entry</a>
							<br>
							<hr>
							<a href="Javascript:loan_item();">Issue Loan</a>
							<br>
							<hr>
						</c:if>
						<a href="<c:url value='/search'/>">Search</a><br>
						<hr>
						<c:if test="${isLibrarian == false}">
						<a href="<c:url value='/display_reservations'/>">Current
							Reservations</a><br>
						<hr>
						<a href="<c:url value='/display_loans'/>">Display Loans</a><br>
						<hr>
						</c:if>
						<a href="Javascript:reserve_item();">Reserve Item</a><br>
						<hr>
					</div>
				</td>
				<td><fmt:formatDate pattern="dd/MM/yyyy"
						value="${editableUser.DOB}" var="dob" /> <form:form method="POST"
						action="/update_user_details" commandName="user"
						id="stylised">
						<h1>User Information</h1>
						<hr />
						<table>
							<tr>
								<td><form:label path="firstName">First Name: </form:label></td>
								<td><form:input path="firstName"
										value="${editableUser.firstName}" /></td>
							</tr>
							<tr>
								<td><form:label path="lastName">Last Name: </form:label></td>
								<td><form:input path="lastName"
										value="${editableUser.lastName}" /></td>
							</tr>
							<tr>
								<td><form:label path="username">Username: </form:label></td>
								<td><form:input path="username"
										value="${editableUser.username}" /></td>
							</tr>
							<tr>
								<td><form:label path="password">Password: </form:label></td>
								<td><form:input path="password" type="password"
										value="${editableUser.password}" /></td>
							</tr>
							<tr>
								<td><form:label path="DOB">Date Of Birth: </form:label></td>
								<td><form:input path="DOB" id="dob" value="${dob}" /></td>
							</tr>
							<tr>
								<td><form:label path="emailAddress">Email Address: </form:label></td>
								<td><form:input path="emailAddress"
										value="${editableUser.emailAddress}" /></td>
							</tr>
							<tr>
								<td><b>Address: </b><br></td>
								<td></td>
							</tr>
							<tr>
								<td><form:label path="address.unit">Unit:</form:label></td>
								<td><form:input path="address.unit"
										value="${editableUser.address.unit}" /></td>
							</tr>
							<tr>
								<td><form:label path="address.streetNumber">Street Number: </form:label></td>
								<td><form:input path="address.streetNumber"
										value="${editableUser.address.streetNumber}" /></td>
							</tr>
							<tr>
								<td><form:label path="address.streetName">Street Name: </form:label></td>
								<td><form:input path="address.streetName"
										value="${editableUser.address.streetName}" /></td>
							</tr>
							<tr>
								<td><form:label path="address.suburb">Suburb: </form:label></td>
								<td><form:input path="address.suburb"
										value="${editableUser.address.suburb}" /></td>
							</tr>
							<tr>
								<td><form:label path="address.state">State: </form:label></td>
								<td><form:input path="address.state"
										value="${editableUser.address.state}" /></td>
							</tr>
							<tr>
								<td><form:label path="address.postcode">Postcode: </form:label></td>
								<td><form:input path="address.postcode"
										value="${editableUser.address.postcode}" /></td>
							</tr>
							<tr>
								<td><form:label path="securityQuestion">Security Question: </form:label></td>
								<td><form:select path="securityQuestion">
										<form:options items="${securityQuestions}" />
									</form:select></td>
							</tr>
							<tr>
								<td><form:label path="securityAnswer">Security Answer: </form:label></td>
								<td><form:input path="securityAnswer"
										value="${editableUser.securityAnswer}" /></td>
							</tr>
							<tr>
								<td><input type="reset" value="RESET" class="button" /></td>
								<td><input type="submit" value="UPDATE" class="button" /></td>
							</tr>
						</table>
					</form:form></td>
			</tr>
		</table>
	</div>


	<!-- Footer banner -->
	<div class="footer">
		<p>
			Copyright 2013 | SofTech Developers| All Rights Reserved<br /> CSU
			ITC 303/9
		</p>
	</div>

</body>
</html>

<script type="text/javascript">
<!--
	$(function() {
		$("#dob").datepicker({
			dateFormat : "dd/mm/yy"
		});
	});
//-->
</script>
