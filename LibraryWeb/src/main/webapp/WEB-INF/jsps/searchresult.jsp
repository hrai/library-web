<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Result</title>
<link href="<c:url value = '/resources/css/main.css'/>" rel="stylesheet"
	type="text/css" />
<script type="text/javascript" src="<c:url value='/resources/javascript/super.js'/>"></script>
</head>
<!-- This is a main page -->

<body>
	<!--banner-->

	<div class="banner"></div>
	<!--CSU  banner-->
	<hr />
	<!--main body-->

	<div class="main_body">
		<!-- Navigation Menu -->

		<ul id="menu" class="black">
			<li><a href="<c:url value='/welcome'/>">Home</a></li>
			<li><a href="<c:url value='/edit_user_details'/>">Edit User
					Info</a></li>
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
				<td><div class="search_item">

						<c:forEach items="${catalogueEntries}" var="catalogueEntry">
							<fieldset>
								<legend>
									<a href="<c:url value='/open/${catalogueEntry.barcode}'/>"><c:out
											value="${catalogueEntry.title}" /></a>
								</legend>
								Author:
								<c:out value="${catalogueEntry.authors}" />
								<br /> Year Published:
								<c:out value="${catalogueEntry.yearPublished}" />
								<br />
							</fieldset>
							<br/>
						</c:forEach>
						
					</div></td>
			</tr>
		</table>
	</div>

	<!-- this is footer section-->
	<!-- Footer banner-->

	<div class="footer">
		<p>
			Copyright 2013 | SofTech Developers| All Rights Reserved<br /> CSU
			ITC 303/9
		</p>
	</div>
</body>
</html>
