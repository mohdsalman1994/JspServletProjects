<%@page import="com.luv2code.jdbc.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Student Tracker App</title>

<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Login Page</title>

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css"
	integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ"
	crossorigin="anonymous">


<!-- <link rel="stylesheet" type="text/css" href="css/style.css" /> -->
</head>
<body>

	<div id="header">
		<h2 class="text-center">Student Tracker</h2>
	</div>

	<div class="container">
		<a class="btn btn-primary" href="add-student-form.jsp">Add Student</a>
		<a class="btn btn-primary float-right" href="login.jsp?message=LOGOUT">
			Logout</a>
	</div>

	<br />
	<br />

	<div class="container">
		<!-- <input type="button" value="Add Student"
			onclick="window.location.href='add-student-form.jsp'; return false;"
			class="add-student-button" /> -->

		<table class="table table-striped">
			<thead class="thead-inverse">
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
			</thead>

			<c:forEach var="student" items="${students_list}">
				<!-- set up a link for each student -->

				<c:url var="updateLink" value="StudentControllerServlet">
					<c:param name="command" value="load"></c:param>
					<c:param name="studentId" value="${student.id}"></c:param>
				</c:url>

				<c:url var="deleteLink" value="StudentControllerServlet">
					<c:param name="command" value="delete"></c:param>
					<c:param name="studentId" value="${student.id}"></c:param>
				</c:url>

				<tr>
					<td>${student.firstName}</td>
					<td>${student.lastName}</td>
					<td>${student.email}</td>
					<td><a href="${updateLink}">Update</a> | <a
						href="${deleteLink}" onclick="confirmDelete()">Delete</a></td>
				</tr>
			</c:forEach>
		</table>

	</div>

	<!-- jQuery first, then Tether, then Bootstrap JS. -->
	<script src="https://code.jquery.com/jquery-3.1.1.slim.min.js"
		integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js"
		integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb"
		crossorigin="anonymous"></script>

	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js"
		integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn"
		crossorigin="anonymous"></script>

	<script type="text/javascript">		
		function confirmDelete() {
			if (!(confirm('Are you sure you want to delete?'))) {
				return false;
			}
		}
		
	</script>

</body>
</html>