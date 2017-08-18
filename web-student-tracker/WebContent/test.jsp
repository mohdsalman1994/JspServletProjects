<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>  
<head>  
<title>Using JSTL Functions</title>  
</head>  
<body>  
  
<c:set var="str1" value="Welcome-to-JSP-Programming."/>  
<c:set var="str2" value="${fn:split(str1, '-')}" />  
<c:set var="str3" value="${fn:join(str2, ' ')}" />  
  
<c:forEach var="word" items="${str2}">
${word} <br />
</c:forEach>
<c:set var="str4" value="${fn:split(str3, ' ')}" />  
<c:set var="str5" value="${fn:join(str4, '-')}" />  
  
<p>String-5 : ${str5}</p>  
  
</body>  
</html>