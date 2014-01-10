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

<title>Welcome page</title>
<link href="<c:url value = '/resources/css/main.css'/>" rel="stylesheet"
	type="text/css" />
<link href="<c:url value = '/resources/css/homepage.css'/>"
	rel="stylesheet" type="text/css" />
<script src="<c:url value = '/resources/javascript/super.js'/>"
	type="text/javascript"></script>
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
			<li><a href="<c:url value='/logout' />">Log out</a></li>
		</ul>
		<!--- End of menu-->

		<table class="side_bar">
			<tr>
				<td>
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
							<a href="<c:url value='/display_feedback_list'/>">Display Feedbacks</a><br>
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
				<td><form:form method="GET" action="search_result"
						commandName="search" id="stylised">
						<table>
							<tr>
								<td>Search</td>
								<td><form:input path="searchQuery" class="search" /></td>
								<td><form:select path="searchOption">
										<form:options items="${sessionScope.searchOptions}" />
									</form:select></td>
								<td><input type="submit" value="SEARCH" class="submit"></td>
							</tr>
						</table>
					</form:form></td>
			</tr>
		</table>

		<table width="1024" height="165" border="0" cellpadding="12"
			cellspacing="6">
			<tr>
				<td width="710" valign="top">
					<!-- 
				<c:if test="${librarian == null}">
						
						<table id="inner_table">
							<tr>
								<td><c:out value="${sessionScope.user.firstName}" /> <c:out
										value="${sessionScope.user.lastName}" /></td>
							</tr>
							<tr>
								<td>ID: <c:out value="${sessionScope.user.userId}" /></td>
							</tr>
							<tr>
								<td><c:if test="${sessionScope.user.address.unit} != null">
										<c:out value="${sessionScope.user.address.unit}" />/
										</c:if> <c:out value="${sessionScope.user.address.streetNumber}" />
									<c:out value="${sessionScope.user.address.streetName}" />, <c:out
										value="${sessionScope.user.address.suburb}" />, <c:out
										value="${sessionScope.user.address.state}" /> <c:out
										value="${sessionScope.user.address.postcode}" /></td>
							</tr>
						</table>
						
					</c:if> <br /> <br />
					 --> <c:if test="${fn:length(currentLoans) != 0}">
						<div>
							<fieldset>
								<legend>Current Loans</legend>
								<table class="display_records">
									<tr>
										<th>#</th>
										<th>Author</th>
										<th>Title</th>
										<th>Year Published</th>
										<th>Loaned Date</th>
										<th>Due Date</th>
										<th>No of Renewals</th>
										<th>Fine</th>
										<th></th>
										<th></th>
									</tr>
									<c:forEach items="${currentLoans}" var="loan"
										varStatus="status">

										<!-- data to be rendered from database-->

										<tr>
											<td><c:out value="${status.count}" /></td>
											<td><c:out value="${loan.authors}" /></td>
											<td><c:out value="${loan.title}" /></td>
											<td><c:out value="${loan.yearPublished}" /></td>
											<td><fmt:formatDate type="date"
													value="${loan.outDate.time}" /></td>
											<td><fmt:formatDate type="date"
													value="${loan.dueDate.time}" /></td>
											<td><c:out value="${loan.noOfRenewals}" /></td>
											<td><c:out value="${loan.amount}" /></td>
											<!-- 
											<td><a
												href="<c:url value='/return_item/${loan.loanId}'/>">Return</a></td>
											-->
											<td><a
												href="<c:url value='/renew_item/${loan.loanId}/${loan.userId}'/>">Renew</a></td>
										</tr>
									</c:forEach>
								</table>
							</fieldset>
						</div>
					</c:if>
			</tr>
		</table>
	</div>


	<!-- this is footer section-->
	<div class="footer">
		<p>
			Copyright 2013 | SofTech Developers| All Rights Reserved<br /> CSU
			ITC 303/9
		</p>
	</div>
</body>
</html>
