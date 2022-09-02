<%-- 
    Jason Rodriguez
    Lab 8
    Aug 31, 2022
    CIST 2373
    I PROMISE I WROTE THIS CODE
--%>


<%@page import="java.util.ArrayList"%>
<%@page import="Business.Customer"%>
<%@page import="Business.Account"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="DisplayAccounts.css">
        <title>Display Accounts</title>
    </head>
    <body>
    <center>
        <h1>ACCOUNTS</h1>
        <table class="zigzag">
            <thead>
                <tr>
                  <th>Account Number</th>
                  <th>Customer id</th>
                  <th>Type</th>
                  <th>Balance</th>
                </tr>
            </thead>
            <tbody>
  <% 
                // Getting Customer obj c1 from session
                Customer c1 = (Customer)session.getAttribute("c1");
                // Getting number of accounts for the customer
                int numOfAccounts = c1.aList.getCount();
                for (int i = 0; i < numOfAccounts; i++) {
                    Account currentAccount = c1.aList.accArr.get(i);
                    out.println("<tr>");
                    out.println("<td>" + currentAccount.getAccountNumber() + "</td>");
                    out.println("<td>" + currentAccount.getCustomerId() + "</td>");
                    out.println("<td>" + currentAccount.getType() + "</td>");
                    out.println("<td>" + currentAccount.getBalance() + "</td>");
                    out.println("</tr>");
                }
                
  %>
            </tbody>
</table>
</center>
    </body>
</html>
