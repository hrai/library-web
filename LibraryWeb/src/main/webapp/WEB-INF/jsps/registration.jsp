<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Page</title>
<link href="<c:url value = '/resources/css/main.css'/>" rel="stylesheet"
	type="text/css" />
<link href="<c:url value = '/resources/css/form.css'/>" rel="stylesheet"
	type="text/css" />
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.2/themes/smoothness/jquery-ui.css" />
</head>
<script src="//ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js"></script>
<script
	src="//ajax.googleapis.com/ajax/libs/jqueryui/1.10.2/jquery-ui.min.js"></script>

<!-- This is a main page -->

<body>
	<!--banner-->

	<div class="banner"></div>
	<!--CSU  banner-->
	<hr />
	<!--main body-->

	<div class="main_body">
		<div class="registration">
			<form:form method="POST" action="register" commandName="user"
				id="stylised">
				<h1>Registration Form</h1>
				<hr />
				<table>
					<tr>
						<td><form:label path="firstName">First Name: </form:label></td>
						<td><form:input path="firstName" /></td>
						<td><form:errors path="firstName" cssClass="error" /></td>
					</tr>
					<tr>
						<td><form:label path="lastName">Last Name: </form:label></td>
						<td><form:input path="lastName" /></td>
						<td><form:errors path="lastName" cssClass="error" /></td>
					</tr>
					<tr>
						<td><form:label path="username">Username: </form:label></td>
						<td><form:input path="username" /></td>
						<td><form:errors path="username" cssClass="error" /></td>
					</tr>
					<tr>
						<td><form:label path="password">Password: </form:label></td>
						<td><form:input path="password" type="password" /></td>
						<td><form:errors path="password" cssClass="error" /></td>
					</tr>
					<tr>
						<td><label>User Type: </label></td>
						<td><select name="selectedType">
								<c:forEach items="${userTypes}" var="type">
									<option value="${type.key}">
										<c:out value="${type.value}" />
									</option>
								</c:forEach>
						</select></td>
					</tr>

					<tr>
						<td><form:label path="DOB">Date Of Birth: </form:label></td>
						<td><form:input path="DOB" id="dob" /></td>
						<td><form:errors path="DOB" cssClass="error" /></td>
					</tr>
					<tr>
						<td><form:label path="emailAddress">Email Address: </form:label></td>
						<td><form:input path="emailAddress" /></td>
						<td><form:errors path="emailAddress" cssClass="error" /></td>
					</tr>
					<tr>
						<td><b>Address: </b><br></td>
						<td></td>
					</tr>
					<tr>
						<td><form:label path="address.unit">Unit:</form:label></td>
						<td><form:input path="address.unit" /></td>
						<td><form:errors path="address.unit" cssClass="error" /></td>
					</tr>
					<tr>
						<td><form:label path="address.streetNumber">Street Number: </form:label></td>
						<td><form:input path="address.streetNumber" /></td>
						<td><form:errors path="address.streetNumber" cssClass="error" /></td>
					</tr>
					<tr>
						<td><form:label path="address.streetName">Street Name: </form:label></td>
						<td><form:input path="address.streetName" /></td>
						<td><form:errors path="address.streetName" cssClass="error" /></td>
					</tr>
					<tr>
						<td><form:label path="address.suburb">Suburb: </form:label></td>
						<td><form:input path="address.suburb" /></td>
						<td><form:errors path="address.suburb" cssClass="error" /></td>
					</tr>
					<tr>
						<td><form:label path="address.state">State: </form:label></td>
						<td><form:select path="address.state">
								<form:options items="${states}" />
							</form:select></td>
						<td><form:errors path="address.state" cssClass="error" /></td>
					</tr>
					<tr>
						<td><form:label path="address.postcode">Postcode: </form:label></td>
						<td><form:input path="address.postcode" /></td>
						<td><form:errors path="address.postcode" cssClass="error" /></td>
					</tr>
					<tr>
						<td><form:label path="securityQuestion">Security Question: </form:label></td>
						<td><form:select path="securityQuestion">
								<form:options items="${securityQuestions}" />
							</form:select></td>
						<td><form:errors path="firstName" cssClass="error" /></td>
					</tr>
					<tr>
						<td><form:label path="securityAnswer">Security Answer: </form:label></td>
						<td><form:input path="securityAnswer" /></td>
						<td><form:errors path="securityAnswer" cssClass="error" /></td>
					</tr>
					<tr>
						<td colspan=3>
							<div style="padding-left: 100px;">
								<input type="reset" value="CLEAR" class="button" /> <input
									type="submit" value="SUBMIT" class="button" />
							</div>
						</td>
					</tr>
				</table>
			</form:form>
		</div>
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
