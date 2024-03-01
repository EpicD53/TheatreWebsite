<%-- 
    Document   : movieManager
    Created on : Feb 29, 2024, 2:49:54 p.m.
    Author     : andrewsudyk
--%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8" import="ryerson.lab3.helper.ticket"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Movie Management</title>
    </head>
    <body>
<center><h2>Hello <%=session.getAttribute("uname")%></h2></center>
<br>
<center><h3> Movie Management</h3></center>
<br>
<table border="2" align="center" cellpadding="5" cellspacing="5">

<tr>
   
<th> First Name </th>
<th> Last Name </th>
<th> Username </th>
<th> Age </th>
<th> Address </th>
<th width=200"> Email </th>


</table>
    <form action="Logout" method="post">
        <input type="submit" value="Logout">
    </form>

    <form action="CreateMovie.html" method="post">
        <input type="submit" value="Add Movie">
    </form>

</body>
</html>
