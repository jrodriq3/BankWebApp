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
        <link rel="stylesheet" href="ErrorPage.css">
        <title>Error Page</title>
    </head>
    <body>
        <%
          Customer c1 = (Customer)session.getAttribute("c1");
          if (c1.getPassword().equals("")) {
              out.println("<div class='wrapper'>");
              out.println("<div class='box'>");
              out.println("<p>Error logging in for user with id: " + c1.getId() + ".</p>");
              out.println("</div>");
              out.println("</div>");
          }
          else {
              out.println("<div class='wrapper'>");
              out.println("<div class='box'>");
              out.println("<p>Error logging in for user with id: " + c1.getId() + "... Incorrect password.</p>");
              out.println("</div>");
              out.println("</div>");
          }
          
        %>
        
        
    </body>
</html>
