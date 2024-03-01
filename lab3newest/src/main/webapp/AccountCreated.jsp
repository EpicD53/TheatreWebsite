<%-- 
    Document   : data.jsp
    Created on : Feb 8, 2024, 9:23:21 p.m.
    Author     : saadusmani
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8" import="ryerson.lab3.gui.CreateAccount"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Account Creation Success</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
            text-align: center;
        }
        .container {
            width: 80%;
            margin: auto;
            overflow: hidden;
        }
        header {
            background: #50a3a2;
            color: white;
            padding-top: 30px;
            min-height: 70px;
            border-bottom: #eaeaea 1px solid;
        }
        header a {
            color: white;
            text-decoration: none;
            text-transform: uppercase;
            font-size: 16px;
        }
    </style>
</head>
<body>
    <header>
        <div class="container">
            <h1>Account Successfully Created</h1>
        </div>
    </header>
    <div class="container">
        <p>Your account has been successfully created. You can now login and start using our services.</p>
        <a href="index.html">Login</a> 
    </div>
</body>
</html>
