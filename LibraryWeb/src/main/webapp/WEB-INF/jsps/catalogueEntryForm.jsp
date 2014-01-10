<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Add Catalogue Entry</title>
<link href="<c:url value = '/resources/css/main.css'/>" rel="stylesheet"
	type="text/css" />
<link href="<c:url value = '/resources/css/form.css'/>" rel="stylesheet"
	type="text/css" />
<script type="text/javascript" src="<c:url value='/resources/javascript/super.js'/>"></script>
<script type="text/javascript"
	src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js">
	
</script>
</head>

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
				<td><c:choose>
						<c:when test='${oldCatalogueEntry==null}'>
							<form:form method="POST" action="/add_item"
								commandName="catalogueEntry" id="stylised">
								<h1>Catalogue Entry Form</h1>
								<hr />
								<table>
									<tr>
										<td><form:label path="title">Title Of Book:</form:label></td>
										<td><form:input path="title" /></td>
										<td colspan="2"><form:errors path="title"
												cssClass="error" /></td>
									</tr>
									<tr>
										<td><form:label path="yearPublished">Year Published:</form:label></td>
										<td><form:input path="yearPublished" /></td>
										<td colspan="2"><form:errors path="yearPublished"
												cssClass="error" /></td>
									</tr>
									<tr>
										<td><form:label path="isbn">ISBN Number:</form:label></td>
										<td><form:input path="isbn" /></td>
										<td colspan="2"><form:errors path="isbn" cssClass="error" /></td>
									</tr>
									<tr>
										<td><form:label path="publisher">Publisher:</form:label></td>
										<td><form:input path="publisher" /></td>
										<td colspan="2"><form:errors path="publisher"
												cssClass="error" /></td>
									</tr>
									<tr>
										<td><form:label path="countryOfPublication">Country Of Publication</form:label></td>
										<td><form:input path="countryOfPublication" /></td>
										<td colspan="2"><form:errors path="countryOfPublication"
												cssClass="error" /></td>
									</tr>
									<tr>
										<td><form:label path="authors">Authors</form:label></td>
										<td><form:input path="authors" /></td>
										<td colspan="2"><form:errors path="authors"
												cssClass="error" /></td>
									</tr>
									<tr>
										<td><form:label path="barcode">Barcode</form:label></td>
										<td><form:input path="barcode" /></td>
										<td colspan="2"><form:errors path="barcode"
												cssClass="error" /></td>
									</tr>
									<tr>
										<td><input type="reset" value="CLEAR" class="button" /></td>
										<td><input type="submit" value="ADD" class="button" /></td>
									</tr>
								</table>
							</form:form>
						</c:when>
						<c:otherwise>
							<form:form method="POST" action="/update_item"
								commandName="oldCatalogueEntry" id="stylised">
								<h1>Catalogue Entry Form</h1>
								<hr />
								<table>
									<tr>
										<td><form:label path="title">Title Of Book:</form:label></td>
										<td><form:input path="title"
												value="${oldCatalogueEntry.title}" /></td>
										<td colspan="2"><form:errors path="title"
												cssClass="error" /></td>
									</tr>
									<tr>
										<td><form:label path="yearPublished">Year Published:</form:label></td>
										<td><form:input path="yearPublished"
												value="${oldCatalogueEntry.yearPublished}" /></td>
										<td colspan="2"><form:errors path="yearPublished"
												cssClass="error" /></td>
									</tr>
									<tr>
										<td><form:label path="isbn">ISBN Number:</form:label></td>
										<td><form:input path="isbn"
												value="${oldCatalogueEntry.isbn}" /></td>
										<td colspan="2"><form:errors path="isbn" cssClass="error" /></td>
									</tr>
									<tr>
										<td><form:label path="publisher">Publisher:</form:label></td>
										<td><form:input path="publisher"
												value="${oldCatalogueEntry.publisher}" /></td>
										<td colspan="2"><form:errors path="publisher"
												cssClass="error" /></td>
									</tr>
									<tr>
										<td><form:label path="countryOfPublication">Country Of Publication</form:label></td>
										<td><form:input path="countryOfPublication"
												value="${oldCatalogueEntry.countryOfPublication}" /></td>
										<td colspan="2"><form:errors path="countryOfPublication"
												cssClass="error" /></td>
									</tr>
									<tr>
										<td><form:label path="authors">Authors</form:label></td>
										<td><form:input path="authors"
												value="${oldCatalogueEntry.authors}" /></td>
										<td colspan="2"><form:errors path="authors"
												cssClass="error" /></td>
									</tr>
									<tr>
										<td><form:label path="barcode">Barcode</form:label></td>
										<td><form:input path="barcode"
												value="${oldCatalogueEntry.barcode}" /></td>
										<td colspan="2"><form:errors path="barcode"
												cssClass="error" /></td>
									</tr>
									<tr>
										<td><input type="reset" value="RESET" class="button" /></td>
										<td><input type="submit" value="UPDATE" class="button" /></td>
									</tr>
								</table>
							</form:form>

						</c:otherwise>
					</c:choose></td>
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