<!-- 
Jason Rodriguez
Lab #7
8/30/2022
I promise I wrote this code
-->

<%@page import="Business.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error Page</title>
    </head>
    <body>
        <%
          Customer c1 = (Customer)session.getAttribute("c1");
          if (c1.getPassword().equals("")) {
              out.println("<h1>Error logging in for user with id: " + c1.getId() + "</h1>");
          }
          else {
              out.println("<h1>Error logging in for user with id: " + c1.getId() + " Incorrect Password</h1>");
          }
          
        %>
        
        
    </body>
</html>
