<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<!DOCTYPE>
	<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Homepage</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ"
		 crossorigin="anonymous">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">


		<link rel="stylesheet" href="css/homepage.css" />
	</head>

	<body>
		<div class="container-fluid">
			<nav class="navbar navbar-toggleable-sm navbar-inverse bg-inverse fixed-top">
				<button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo02"
				 aria-controls="navbarTogglerDemo02" aria-expanded="true" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

				<div class="collapse navbar-collapse" id="navbarTogglerDemo02">
					<ul class="navbar-nav mr-auto mt-2 mt-md-0">
						<li class="nav-item"><a class="nav-link disabled" href="#">Welcome
							${user.fullName} <span class="sr-only">(current)</span>
					</a></li>

					</ul>
					<form class="form-inline my-2 my-lg-0">
						<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Logout</button>
					</form>
				</div>
			</nav>
		</div>
		<div class="container" id="categories">

			<div class="row">
				<div class="col-md-4 col-sm-12">
					<div class="card">
						<div class="card-block">
							<h3 class="card-title">Arts</h3>
							<p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
							<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#viewBookModal" data-whatever="Arts">View
							Books</button>
						</div>
					</div>
				</div>

				<div class="col-md-4 col-sm-12">
					<div class="card">
						<div class="card-block">
							<h3 class="card-title">Commerce</h3>
							<p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
							<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#viewBookModal" data-whatever="Commerce">View
							Books</button>
						</div>
					</div>
				</div>

				<div class="col-md-4 col-12">
					<div class="card">
						<div class="card-block">
							<h3 class="card-title">Science</h3>
							<p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
							<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#viewBookModal" data-whatever="Science">View
							Books</button>
						</div>
					</div>
				</div>

			</div>

			<!-- Modal for viewing books in a particular category -->
			<div class="modal fade" id="viewBookModal" tabindex="-1" role="dialog" aria-labelledby="viewBookModalLabel" aria-hidden="true">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="viewBookModalLabel"></h5>
							<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
						</div>
						<div class="modal-body">
							<table id="bookTable"></table>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
						</div>
					</div>
				</div>
			</div>

			<br />

			<div class="row" align="right">
				<div class="col">

					<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">
					<i class="fa fa-plus" aria-hidden="true"></i>
				</button>
					<!-- Button trigger modal -->

					<!-- Modal -->
					<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="viewBookModalLabel" aria-hidden="true">
						<div class="modal-dialog" role="document">
							<div class="modal-content">
								<div class="modal-header">
									<h5 class="modal-title" id="viewBookModalLabel">Modal title</h5>
									<button type="button" class="close" data-dismiss="modal" aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
								</div>
								<div class="modal-body">...</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
									<button type="button" class="btn btn-primary">Save
									changes</button>
								</div>
							</div>
						</div>
					</div>
				</div>


			</div>

			<c:url var="testLink" value="StudentControllerServlet">
				<c:param name="command" value="load"></c:param>
				<c:param name="studentId" value="${student.id}"></c:param>
			</c:url>

			<a href="" data-toggle="modal" data-target="#viewBookModal" data-whatever="@mdo" class="btn btn-primary">Test</a>

			<div class="modal fade" id="viewBookModal" tabindex="-1" role="dialog" aria-labelledby="viewBookModalLabel" aria-hidden="true">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="viewBookModalLabel">New message</h5>
							<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						</div>
						<div class="modal-body">
							<form>
								<div class="form-group">
									<label for="recipient-name" class="form-control-label">Recipient:</label>
									<input type="text" class="form-control" id="recipient-name">
								</div>
								<div class="form-group">
									<label for="message-text" class="form-control-label">Message:</label>
									<textarea class="form-control" id="message-text"></textarea>
								</div>
							</form>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
							<button type="button" class="btn btn-primary">Send
							message</button>
						</div>
					</div>
				</div>
			</div>
		</div>




		<!-- jQuery first, then Tether, then Bootstrap JS. -->
		<script src="https://code.jquery.com/jquery-3.1.1.slim.min.js" integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n"
		 crossorigin="anonymous"></script>

		<script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js" integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb"
		 crossorigin="anonymous"></script>

		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn"
		 crossorigin="anonymous"></script>

		<script>
			$('#viewBookModal').on('show.bs.modal', function (event) {
				var button = $(event.relatedTarget) // Button that triggered the modal
				var category = button.data('whatever'); // Extract info from data-* attributes
				var modal = $(this);
				modal.find('.modal-title').text('My ' + category + ' books');

				$.ajax({

					url: "LibraryController",

					data: {
						category: category
					},

					type: "POST",

					dataType: JSON,
				}).done(function (json) {
					// Update the modal's body.
					if (responseJson != null) {
						$("#bookTable").find("tr:gt(0)").remove();
						var table1 = $("#bookTable");
						$.each(responseJson, function (key, value) {
							var rowNew = $("<tr><td></td><td></td><td></td><td></td><td></td><td></td></tr>");
							rowNew.children().eq(0).text(value['bookName']);
							rowNew.children().eq(1).text(value['bookAuthor']);
							rowNew.children().eq(2).text(value['bookCategory']);
							rowNew.children().eq(3).text(value['bookDescription']);							
							rowNew.appendTo(table1);
						});
					}
					modal.find('.modal-body').val('Testing ' + category);
					}).fail(function (xhr, status, errorThrown) {
						alert("Sorry, there was a problem!");
						console.log("Error: " + errorThrown);
						console.log("Status: " + status);
						console.dir(xhr);
					});


			});
		</script>


	</body>

	</html>