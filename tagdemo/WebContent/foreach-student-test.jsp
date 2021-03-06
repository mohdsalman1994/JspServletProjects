<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*, com.luv2code.tagdemo.Student"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
	// create a sample Student list which will be usually provided by MVC
	List<Student> studentList = new ArrayList<>();
	
	studentList.add(new Student("John", "Doe", false));
	studentList.add(new Student("Maxwell", "Johnson", false));
	studentList.add(new Student("Mary", "Public", true));
	
	pageContext.setAttribute("studentList",studentList);

	%>
	
	<table border="1">
	<c:forEach var="student" items="${studentList}">	
	<tr>
		<td>${student.firstName}</td>
		<td>${student.lastName}</td>
		<td>${student.goldCustomer}</td>
	</tr>
	
	</c:forEach>
	
	</table>
	
</body>
</html>