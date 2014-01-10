<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Item Details</title>
<link href="<c:url value = '/resources/css/main.css'/>" rel="stylesheet"
	type="text/css" />
<link href="<c:url value = '/resources/css/display_items.css'/>"
	rel="stylesheet" type="text/css" />
<script src="//ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js"></script>
<script type="text/javascript" src="<c:url value='/resources/javascript/super.js'/>"></script>
</head>
<!-- This is a main page -->

<script>
	var appPath = "/LibraryTest1";
</script>
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
					<div class="display_item">
						<table>
							<tr>
								<td colspan=5><c:out value="${catalogueEntry.title}" /></td>
							</tr>
							<tr>
								<td>Author: <c:out value="${catalogueEntry.authors}" /></td>
								<td>Year Published: <c:out
										value="${catalogueEntry.yearPublished}" /></td>
							</tr>
							<tr>
								<td>ISBN: <c:out value="${catalogueEntry.isbn}" /></td>
								<td>Publisher: <c:out value="${catalogueEntry.publisher}" /></td>
								<td>Country of Publication: <c:out
										value="${catalogueEntry.countryOfPublication}" /></td>
							</tr>
						</table>
					</div>
				</td>
			</tr>
		</table>
		<div style="margin-left: 200px;">
			<c:if test="${isLibrarian==true}">
			<a href="javascript:loanItem(${catalogueEntry.barcode})"
				class="links">Loan Item</a> <a
				href="<c:url value='/edit_item/${catalogueEntry.barcode}'/>"
				class="links">Edit Item</a> <a
				href="javascript:confirmRemoval(${catalogueEntry.barcode})"
				class="links">Remove Item</a> 
			</c:if>
			<a href="javascript:reserveItem(${catalogueEntry.barcode})"
				class="links">Reserve Item</a>
		</div>
		<br />
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

<script type="text/javascript">
<!--
	function loanItem(barcode) {
		var userID = prompt("Enter the user ID: ");

		if (userID != null && userID != "") {
			window.location = appPath + "/loan_item/" + barcode + "/" + userID;
		}
		;
	}

	function confirmRemoval(barcode) {
		var result = confirm("Do you want to remove the item?");

		if (result) {
			window.location = appPath + "/remove_item/" + barcode;
		}
		;
	}

	function reserveItem(barcode) {
		var userID = prompt("Enter the user ID: ");

		if (userID != null && userID != "") {
			window.location = appPath + "/reserve_item/" + barcode + "/"
					+ userID;
		}
		;
	};
//-->
</script>
