<%-- 
    Document   : usermovies
    Created on : Jan 24, 2021, 1:00:48 AM
    Author     : student
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html>" pageEncoding="UTF-8" import="ryerson.lab3.helper.ticket"%>
<%@page import="ryerson.lab3.persistence.Ticket_CRUD"%>
<!DOCTYPE html>


<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Your Movies</title>
    </head>
    <style>

body {
  background-color: #E6E6FA;

}
</style>
<body>
<center><h2>Hello <%=session.getAttribute("uname")%></h2></center>
<br>
<center><h3> The following are your tickets</h3></center>
<br>
<table border="2" align="center" cellpadding="5" cellspacing="5">

<tr>
   
<th> Movie Name </th>
<th> Seat Number </th>
<th> Screening Date </th>
<th> Buy </th>
</tr>
            <%
                String username = (String) session.getAttribute("uname");
                ticket tk = Ticket_CRUD.read(username); 
                if(tk != null) {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    Date dateormatted = sdf.parse(SimpleDateFormat);
                    %>
                    <tr>
                        <td><%= tk.getMovieName() %></td>
                        <td><%= tk.getSeatNumber() %></td>
                        <td><%= sdf.format(tk.getScreeningDate()) %></td>
                        <td><form action="BuyTicket" method="post">
                            <!-- Include fields such as ticket ID if necessary for the BuyTicket action -->
                            <input type="submit" value="Buy">
                        </form></td>
                    </tr>
                    <%
                }
            %>
</table>
    <form action="Logout" method="post">
        <input type="submit" value="Logout">
    </form>
</body>
</html>
