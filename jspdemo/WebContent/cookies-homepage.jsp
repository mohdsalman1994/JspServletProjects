<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Training Portal</title>
</head>
<body>


	<h3>Training Portal</h3>

	<!-- Read the programming language from the cookie -->

	<%
		// the default .. if there are no cookies
		String favouriteLanguage = "Java";

		// get the cookies from the response
		Cookie[] cookies = request.getCookies();

		// find our favourite language cookie
		if (cookies != null) {

			for (Cookie cookie : cookies) {
				if ("myApp.favouriteLanguage".equals(cookie.getName())) {
					favouriteLanguage = cookie.getValue();
					break;
				}
			}
		}
	%>
	
	
	<!-- Now show the personalized webpage -->
	
	<h4>New Books for <%= favouriteLanguage %></h4>
	
	<ul>
		<li>blah blah blah</li>
		<li>blah blah blah</li>
	</ul>
	
	
	<h4>Latest News Report for <%= favouriteLanguage %></h4>
	
	<ul>
		<li>blah blah blah</li>
		<li>blah blah blah</li>
	</ul>
	
	<h4>Hot Jobs for <%= favouriteLanguage %></h4>
	
	<ul>
		<li>blah blah blah</li>
		<li>blah blah blah</li>
	</ul>
	
	<br /><br />
	
	<a href="cookie-personalize-form.html">Personalize this page</a>
</body>
</html>