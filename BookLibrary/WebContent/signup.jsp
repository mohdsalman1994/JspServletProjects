<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!DOCTYPE html>
<html lang="en">
<head>
<!-- Standard Meta -->
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0">

<!-- Site Properties -->
<title>Bootstrap 4 Register Form</title>

<!-- Stylesheets -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">

<!-- Bootstrap4 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css"
	integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ"
	crossorigin="anonymous">

<link rel="stylesheet" href="css/signup.css" />
</head>
<body>
	<div class="container" id="form-container">
		<form class="form-horizontal" role="form" method="POST"
			action="/register">
			<div class="row">
				<div class="col-md-3"></div>
				<div class="col-md-6">
					<h2>Register New User</h2>
					<hr>
				</div>
			</div>
			<div class="row">
				<div class="col-md-3 field-label-responsive">
					<label for="name">Name</label>
				</div>
				<div class="col-md-6">
					<div class="form-group">
						<div class="input-group mb-2 mr-sm-2 mb-sm-0">
							<div class="input-group-addon" style="width: 2.6rem">
								<i class="fa fa-user"></i>
							</div>
							<input type="text" name="name" class="form-control" id="name"
								placeholder="John Doe" required autofocus>
						</div>
					</div>
				</div>
				<div class="col-md-3">
					<div class="form-control-feedback">
						<span class="text-danger align-middle"> <!-- Put name validation error messages here -->
						</span>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-3 field-label-responsive">
					<label for="email">E-Mail Address</label>
				</div>
				<div class="col-md-6">
					<div class="form-group">
						<div class="input-group mb-2 mr-sm-2 mb-sm-0">
							<div class="input-group-addon" style="width: 2.6rem">
								<i class="fa fa-at"></i>
							</div>
							<input type="text" name="email" class="form-control" id="email"
								placeholder="you@example.com" required autofocus>
						</div>
					</div>
				</div>
				<div class="col-md-3">
					<div class="form-control-feedback">
						<span class="text-danger align-middle"> <!-- Put e-mail validation error messages here -->
						</span>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-3 field-label-responsive">
					<label for="password">Password</label>
				</div>
				<div class="col-md-6">
					<div class="form-group">
						<div class="input-group mb-2 mr-sm-2 mb-sm-0">
							<div class="input-group-addon" style="width: 2.6rem">
								<i class="fa fa-key"></i>
							</div>
							<input type="password" name="password" class="form-control"
								id="password" placeholder="Password" required>
						</div>
					</div>
				</div>
				<div class="col-md-3">
					<div class="form-control-feedback">
						<span class="text-danger align-middle hidden-xl-up"> <i
							class="fa fa-close"> Example Error Message</i>
						</span>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-3 field-label-responsive">
					<label for="password">Confirm Password</label>
				</div>
				<div class="col-md-6">
					<div class="form-group">
						<div class="input-group mb-2 mr-sm-2 mb-sm-0">
							<div class="input-group-addon" style="width: 2.6rem">
								<i class="fa fa-repeat"></i>
							</div>
							<input type="password" name="password-confirmation"
								class="form-control" id="password-confirm"
								placeholder="Password" required>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-3"></div>
				<div class="col-md-6">
					<button type="submit" class="btn btn-success">
						<i class="fa fa-user-plus"></i>Register
					</button>
					<div id="signin" class="col-md-6 float-right text-right">
						Already registered? <a href="login.jsp">Sign In</a>
					</div>
				</div>
			</div>
		</form>
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

</body>