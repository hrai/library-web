<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Loan List</title>
<link href="<c:url value = '/resources/css/main.css'/>" rel="stylesheet"
	type="text/css" />
<link href="<c:url value = '/resources/css/homepage.css'/>"
	rel="stylesheet" type="text/css" />
<script src="//ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js"></script>
<script type="text/javascript"
	src="<c:url value='/resources/javascript/super.js'/>"></script>
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
				<td colspan = "2">
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
					</div>
				</td>
			</tr>
			<tr>
				<td><c:if test="${fn:length(loanDetailsList) != 0}">
						<div>
							<fieldset>
								<legend>Loans</legend>
								<table class="display_records">
									<tr>
										<th>#</th>
										<th>Author</th>
										<th>Title</th>
										<th>Year Published</th>
										<th>Loaned Date</th>
										<th>Due Date</th>
										<th>Returned Date</th>
										<th>No of Renewals</th>
										<th>Fine</th>
										<th></th>
										<th></th>
									</tr>
									<c:forEach items="${loanDetailsList}" var="loanDetails"
										varStatus="status">

										<!-- data to be rendered from database-->

										<tr>
											<td><c:out value="${status.count}" /></td>
											<td><c:out value="${loanDetails.catalogueEntry.authors}" /></td>
											<td><c:out value="${loanDetails.catalogueEntry.title}" /></td>
											<td><c:out value="${loanDetails.catalogueEntry.yearPublished}" /></td>
											<td><fmt:formatDate type="date"
													value="${loanDetails.loan.outDate.time}" /></td>
											<td><fmt:formatDate type="date"
													value="${loanDetails.loan.dueDate.time}" /></td>
											<td><fmt:formatDate type="date"
													value="${loanDetails.loan.returnedDate.time}" /></td>
											<td><c:out value="${loanDetails.loan.noOfRenewals}" /></td>
											<td><c:out value="${loanDetails.fine}" /></td>
										</tr>
									</c:forEach>
								</table>
							</fieldset>
						</div>
					</c:if></td>
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