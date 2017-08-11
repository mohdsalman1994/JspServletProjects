<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Student Form</title>

<link rel="stylesheet" type="text/css" href="css/style.css" />
<link rel="stylesheet" type="text/css" href="css/add-student-style.css" />
</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>Bridgelab University</h2>
		</div>
	</div>

	<div id="container">
		<h3>Add Student</h3>

		<form action="StudentControllerServlet" method="post">

			<input type="hidden" name="command" value="add" />

			<table>

				<tbody>

					<tr>
						<td><label>First Name:</label></td>
						<td><input type="text" name="firstName"></td>
					</tr>
					
					<tr>
						<td><label>Last Name:</label></td>
						<td><input type="text" name="lastName"></td>
					</tr>
					
					<tr>
						<td><label>Email:</label></td>
						<td><input type="text" name="email"></td>
					</tr>
					
					<tr>
						<td><label"></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>

				</tbody>

			</table>

		</form>
		
		<div style="clear: both;"></div>
		
		<p>
			<a href="StudentControllerServlet">Back to List</a>
</p>

	</div>

</body>
</html>	