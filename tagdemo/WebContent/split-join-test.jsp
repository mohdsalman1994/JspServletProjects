<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Split Join Test</title>
</head>
<body>


	<c:set var="data" value="Singapore,Mumbai,Tokyo,London" />

	<h3>Split Demo</h3>

	<c:set var="citiesArray" value="${fn:split(data, ',')}" />

	<c:forEach var="city" items="${citiesArray}">
	${city} <br />
	</c:forEach>
	
	<br />
	
	<h3>Join Demo</h3>
	
	<c:set var="fun" value="${fn:join(citiesArray,'*')}"/>
	
	Result of joining: ${fun}
</body>
</html>