<!DOCTYPE html>
<%@page import="com.atm.CardBean"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
CardBean  cb=(CardBean)session.getAttribute("cbean");

%>

<form action="Deposite" method="post">
    <table>
        <tr>
            <td><label >Enter Ammout</label></td>
            <td><input type="number" name="amount"  ></td>
            <td><input type="hidden" name="cardnum" value=<%=cb.getCardNumber()%>></td>
        </tr>
        <tr><td><input type="submit" value="Submit"></td></tr>
    </table>

</form>
</body>
</html>