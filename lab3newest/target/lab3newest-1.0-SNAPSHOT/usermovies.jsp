<%-- 
    Document   : usermovies
    Created on : Jan 24, 2021, 1:00:48 AM
    Author     : student
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8" import="com.mycompany.lab2new.ticket"%>
<!DOCTYPE html>


<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Your Book</title>
    </head>
    <style>

body {
  background-color: #E6E6FA;

}
</style>
<% 
    ArrayList<ticket> tickets= (ArrayList)request.getAttribute("ticketInfo");
  
%>

<center><h2>Hello <%=session.getAttribute("uname")%></h2></center>
<br>
<center><h3> The following are your tickets</h3></center>
<br>
<table border="2" align="center" cellpadding="5" cellspacing="5">

<tr>
   
<th> Name </th>
<th> Genre </th>
<th> Screening Date </th>
<th> Extend </th>

</tr>

    <% for(ticket ticket: tickets){
    %>
<tr>
<td> <%=ticket.getMovieName()%> </td>
<td> <%=new SimpleDateFormat("yyyy-MM-dd").format(ticket.getScreeningDate())%></td>
<% }
%>
</table>
<body>
    <form action="Logout" method="post">
        <input type="submit" value="Logout">
    </form>
</body>
</html>
