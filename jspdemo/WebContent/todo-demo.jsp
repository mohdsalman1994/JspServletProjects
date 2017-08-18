<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- Step 1: Create HTML Form -->
<form action="todo-demo.jsp">

Add new item: <input type="text" name="theItem"/>

<input type="submit" value="Submit" />

<br /><br />


</form>

<!-- Step 2: Add new item to TODO List -->

<%

// get the todo items from the session
List<String> itemList = (List<String>)session.getAttribute("myTodoList");

// if todo list doesn't exist then create one
if(itemList == null) {
	itemList = new ArrayList<String>();
	session.setAttribute("myTodoList", itemList);	
}

// add new data to list if entered
String theItem = request.getParameter("theItem");
if ( (theItem != null) && (!theItem.trim().equals("")) ) {
    itemList.add(theItem);
 }

%>

<!-- Display all items from TODO List -->
<hr />
<strong>To Do List Items:</strong> <br /><br />
<%
for(String item:itemList) {
	out.print("<li>"+item+"</li> <br/>");
}
%>


</body>
</html>