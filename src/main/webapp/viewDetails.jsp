<%@page import="com.atm.CardBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet" href="../webapp/">
</head>
<body>
<%
CardBean cb= (CardBean)session.getAttribute("cbean");
out.println("Customer name"+cb.getName());
%>
<table>
    <tr>
        <td><a href="CheckBalance.jsp" ><button>Check Balance </button></a></td>
        <td><a href="Deposite.jsp"><button>Deposite</button></a></td>
    </tr>
    <tr>
        <td><a href="WithDraw.jsp"><button>WithDraw</button></a></td>
        <td><a href="ChangePin.jsp"><button>Change PIN</button></a></td>
    </tr>
</table>

</body>
</html>