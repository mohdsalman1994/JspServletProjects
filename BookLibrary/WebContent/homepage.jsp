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
					<form class="form-inline my-2 my-lg-0" action="LogoutController">
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
							<table id="bookTable" class="table"></table>
							<!-- <div id="myDiv"></div> -->
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

					<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#formModal">
					<i class="fa fa-plus" aria-hidden="true"></i>
				</button>
					<!-- Button trigger modal -->

					<!-- Modal for Adding/Updating Book -->
					<div class="modal fade" id="formModal" tabindex="-1" role="dialog" aria-labelledby="viewBookModalLabel" aria-hidden="true">
						<div class="modal-dialog" role="document">
							<div class="modal-content">
								<div class="modal-header">
									<h5 class="modal-title" id="viewBookModalLabel">Add Book</h5>
									<button type="button" class="close" data-dismiss="modal" aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
								</div>
								<div class="modal-body">
									<form id="addForm" class="text-left">

										<div class="form-group">
											<label for="bookName">Book Name</label>
											<input type="text" class="form-control" id="bookName" placeholder="Applied Physics">
										</div>

										<div class="form-group">
											<label for="bookAuthor">Book Author</label>
											<input type="text" class="form-control" id="bookAuthor" placeholder="Robert Cornell">
										</div>

										<div class="form-group">
											<label for="category">Category</label>
											<select class="form-control" id="category">
													<option>Arts</option>
													<option>Science</option>
													<option>Commerce</option>													
												  </select>
										</div>

										<div class="form-group">
											<label for="bookDescription">Book Description</label>
											<textarea class="form-control" id="bookDescription" rows="3"></textarea>
										</div>

									</form>

								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
									<button type="submit" class="btn btn-primary" form="addForm">Submit</button>
								</div>
							</div>
						</div>
					</div>
				</div>


			</div>
		</div>




		<!-- jQuery first, then Tether, then Bootstrap JS. -->
		<!-- jQuery first, then Tether, then Bootstrap JS. -->
		<script src="https://code.jquery.com/jquery-3.1.1.min.js" integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
		 crossorigin="anonymous"></script>

		<script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js" integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb"
		 crossorigin="anonymous"></script>

		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn"
		 crossorigin="anonymous"></script>

		<script>
			$('#viewBookModal').on('show.bs.modal', function (event) {
				var button = $(event.relatedTarget) // Button that triggered the modal
				var bookCategory = button.data('whatever'); // Extract info from data-* attributes
				var modal = $(this);
				modal.find('.modal-title').text('My ' + bookCategory + ' books');
				console.log('Before ajax');


				// Using the core $.ajax() method
				$.ajax({

					// The URL for the request
					url: "LibraryController",

					// The data to send (will be converted to a query string)
					data: {
						category: bookCategory,
						command: 'list'
					},

					// Whether this is a POST or GET request
					type: "GET",

					// The type of data we expect back
					dataType: "json",
				})
					// Code to run if the request succeeds (is done);
					// The response is passed to the function
					.done(function (responseJson) {
						console.log(responseJson);
						if (responseJson != null) {
							console.log("Inside done function" + responseJson);
							$("#bookTable").html("");
							var html = "";
							html += "<tr><td>Book Name</td><td>Action</td></tr>";

							$.each(responseJson, function (key, value) {

								html += "<tr><td>" + value["bookName"] + "</td><td>"
									+ "<button type='button' onClick=editBook class='btn btn-secondary'><i class='fa fa-pencil-square-o' aria-hidden='true'></i></button>  |   "
									+ "<button type='button' class='btn btn-success'><i class='fa fa-trash-o' aria-hidden='true'></i></button ></td></tr>";

							});

							$("#bookTable").html(html);
						}


					})
					// Code to run if the request fails; the raw request and
					// status codes are passed to the function
					.fail(function (xhr, status, errorThrown) {
						$("#bookTable").html("");
						alert("No books found!");
						console.log("Error: " + errorThrown);
						console.log("Status: " + status);
						console.dir(xhr);
					})
				// Code to run regardless of success or failure;
				// .always(function (xhr, status) {
				// 	alert("The request is complete!");
				// });

				console.log('After ajax');
			});
		</script>


	</body>

	</html>