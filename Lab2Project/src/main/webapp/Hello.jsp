<%-- 
    Jason Rodriguez
    Lab #7
    Aug 30, 2022
    CIST 2373
    I promise I wrote this code
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>HELLO JSP</title>
    </head>
    <body>
        <% 
        
            for(int i = 1; i < 7; i++) {
                out.println("<h" + i + ">Hello World</h" + i + ">");
            } 
        %>
    </body>
</html>
