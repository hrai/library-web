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

<title>Feedback Form</title>
<link href="<c:url value = '/resources/css/main.css'/>" rel="stylesheet"
	type="text/css" />
<link href="<c:url value = '/resources/css/form.css'/>" rel="stylesheet"
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
				<td>
				<div class="faq">
						<h1>Frequently Asked Question</h1>
						<hr />
						<table>
							<tr>
								<td><p>Q1: How do I borrow the book?</p>
									<p>It is mandatory for a student to register for library
										services to borrow or access any of the library facilities and
										the services provided by the CSU. Once you get registered then
										you will receive the library card, which you have to present
										to library staff while borrowing and returning the borrowed
										items.</p></td>
							</tr>
							<tr>
								<td><p>Q2: Do I need a card to borrow the book?</p>
									<p>Yes, all students and staff need a current CSU ID card
										to borrow from the Library and also to use the photocopiers at
										the library. If you don't have a CSU ID card, you can apply
										for one online or by visiting university.</p></td>
							</tr>
							<tr>
								<td><p>Q2: How many items can I borrow at one time?</p>
									<p>In order to accommodate the need of the each student and
										ensure the availability of items for increasing number of
										students, students are allowed to borrow there items only.</p></td>
							</tr>
							<tr>
								<td><p>Q2: How do I renew the borrowed item?</p>
									<p>Student can either renew the item from online themselves
										or can get assistance for library staff by visiting library.</p></td>
							</tr>
							<tr>
								<td><p>Q2: How do I search for library item?</p>
									<p>Student has to visit search page to search for library
										items. Student can either search item by catalogue title or
										author or ISBN number. Then displayed result will have a hyper
										link, clicking on link directs user to book detail.</p></td>
							</tr>
							<tr>
								<td><p>Q2: How do I pay library fines?</p>
									<p>All library fines will appear on your financial
										statement with the University. Instructions on the methods for
										payment can be found at: Division of Finance - Student Payment
										Methods.</p></td>
							</tr>
							<tr>
								<td><p>Q2: How do I reserve the item?</p>
									<p>For the reservation of item student should search the
										book and clicking on the desired results will forward to item
										detail page. Now student has to click on reservation button at
										the bottom. Then system checks the validity of input and
										display reservation confirmation upon availability of the item
										requested.</p></td>
							</tr>
							<tr>
								<td><p>Q2: I am a CSU student and I live close to
										another University. Can I borrow from their library?</p>
									<p>Yes you can join their library as a reciprocal borrower.
										For more information see the: University Library Australia and
										New Zealand website.</p></td>
							</tr>
						</table>
						</div>
				</td>
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