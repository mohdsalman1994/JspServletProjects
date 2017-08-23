<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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

<link rel="stylesheet" href="css/signin.css" />

</head>

<body>

	<div class="container">

		<form class="form-signin" method="post" action="LoginController">
			<h2 class="form-signin-heading text-center">Please sign in</h2>

			<div id="warning-message" class="alert alert-danger hidden-xl-up"
				role="alert">
				<strong>Incorrect Username/Password</strong>
			</div>
			
			<div id="authorization-message" class="alert alert-warning hidden-xl-up"
				role="alert">
				<strong>You need to login to access this webpage!</strong>
			</div>
			
			<div id="logout-message" class="alert alert-success hidden-xl-up"
				role="alert">
				<strong>You have logged out successfully!</strong>
			</div>

			<label for="inputEmail" class="sr-only">Email address</label> <input
				type="email" name="email" id="inputEmail" class="form-control"
				placeholder="Email address" required autofocus> <label
				for="inputPassword" class="sr-only">Password</label> <input
				type="password" name="password" id="inputPassword"
				class="form-control" placeholder="Password" required>
			<button class="btn btn-lg btn-primary btn-block" type="submit">Sign
				in</button>
		</form>

	</div>
	<!-- /container -->

	<!-- jQuery first, then Tether, then Bootstrap JS. -->
	<script src="https://code.jquery.com/jquery-3.1.1.slim.min.js"
		integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js"
		integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn"
		crossorigin="anonymous"></script>

	<c:choose>

		<c:when test="${param.message == 'INVALID'}">
			<script>
				$('#warning-message').toggleClass('hidden-xl-up');
			</script>
		</c:when>
		
		<c:when test="${param.message == 'LOGOUT'}">
			<script>
				$('#logout-message').toggleClass('hidden-xl-up');
			</script>
		</c:when>
		
		<c:when test="${param.message == 'NOACCESS'}">
			<script>
				$('#authorization-message').toggleClass('hidden-xl-up');
			</script>
		</c:when>


	</c:choose>

</body>
</html>