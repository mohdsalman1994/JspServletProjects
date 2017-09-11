// js code for bringing data when user clicks on any bookcategory

$('#viewBookModal')
		.on(
				'show.bs.modal',
				function(event) {
					console.log('yipekayee2');
					var button = $(event.relatedTarget); // Button that
															// triggered
					// the modal
					var bookCategory = button.data('whatever'); // Extract info
					// from data-*
					// attributes
					var modal = $(this);
					modal.find('.modal-title').text(
							'My ' + bookCategory + ' books');
					console.log('Before ajax');

					// Using the core $.ajax() method
					$
							.ajax({

								// The URL for the request
								url : "LibraryController",

								// The data to send (will be converted to a
								// query string)
								data : {
									category : bookCategory,
									command : 'list'
								},

								// Whether this is a POST or GET request
								type : "GET",

								// The type of data we expect back
								dataType : "json",
							})
							// Code to run if the request succeeds (is done);
							// The response is passed to the function
							.done(
									function(responseJson) {
										console.log(responseJson);
										if (responseJson != null) {
											console.log("Inside done function"
													+ responseJson);
											$("#bookTable").html("");
											var html = "";
											html += "<tr><td>Book Name</td><td>Action</td></tr>";

											$
													.each(
															responseJson,
															function(key, value) {

																html += "<tr><td>"
																		+ value["bookName"]
																		+ "</td><td>"
																		+ "<button type='button' onClick=editBook class='btn btn-secondary'><i class='fa fa-pencil-square-o' aria-hidden='true'></i></button>     "
																		+ "<button type='button' class='btn btn-success'><i class='fa fa-trash-o' aria-hidden='true'></i></button ></td></tr>";

															});

											$("#bookTable").html(html);
										}

									})
							// Code to run if the request fails; the raw request
							// and
							// status codes are passed to the function
							.fail(function(xhr, status, errorThrown) {
								$("#bookTable").html("");
								alert("No books found!");
								console.log("Error: " + errorThrown);
								console.log("Status: " + status);
								console.dir(xhr);
							});
					// Code to run regardless of success or failure;
					// .always(function (xhr, status) {
					// alert("The request is complete!");
					// });

					console.log('After ajax');
				});


$(function () {
	$('#addForm').submit(function(event) {
		
		event.preventDefault();
		console.log("inside submit;");
		
		
		var bookName = $('#bookName').val();
		var bookAuthor = $('#bookAuthor').val();
		var bookCategory = $('#category').val();
		var bookDescription = $('#bookDescription').val();
		
		
		console.log('bookname '+bookName+' bookAuthor '+bookAuthor+' category '+category+' bookDescription '+bookDescription);
		// Using the core $.ajax() method
$.ajax({
	
	// The URL for the request
	url: "LibraryController",
	
	// The data to send (will be converted to a query string)
	data: {
					
		command:'add',
		bookName:bookName,
		bookAuthor: bookAuthor,
		category:bookCategory, 
		bookDescription:bookDescription
	},
	
	// Whether this is a POST or GET request
	type: "POST",
	
	// The type of data we expect back
	dataType: "text",
	})
	// Code to run if the request succeeds (is done);
	// The response is passed to the function
	.done(function (text) {
	console.log('Inside done');
	if(text === 'success') {
	alert('Book added successfully');
	$('#addForm').trigger('reset');
	$('.modal').modal('hide');
	} else if(text === 'duplicate') {
	alert('Book already exists');
	}
					
	})
	// Code to run if the request fails; the raw request and
	// status codes are passed to the function
	.fail(function (xhr, status, errorThrown) {
	alert("Sorry, there was a problem!");
	console.log("Error: " + errorThrown);
	console.log("Status: " + status);
	console.dir(xhr);
	return false;
	})
	// Code to run regardless of success or failure;
	.always(function (xhr, status) {
	alert("I will keep annoying you until you don't remove me!");
	});
	
	console.log('After ajax');	
	return;
	});
});
