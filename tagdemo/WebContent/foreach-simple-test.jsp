<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>For Each Simple Test</title>
</head>
<body>
	<%

	// create some sample data normally provided by MVC
	String[] cities = {"Mumbai", "Singapore", "Philadelphia"};
	
	pageContext.setAttribute("myCities", cities);
		
	%>
	
	<c:forEach var="city" items="${myCities}">
	${city}
	</c:forEach>

</body>
</html>