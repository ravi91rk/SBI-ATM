<%@page import="com.atm.CardBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
CardBean cb =(CardBean)session.getAttribute("cbean");
out.println("Welcome to "+cb.getName());
out.println("Balance"+cb.getBalance());

%>
<a href="viewDetails.jsp"><button>Back</button></a>
</body>
</html>