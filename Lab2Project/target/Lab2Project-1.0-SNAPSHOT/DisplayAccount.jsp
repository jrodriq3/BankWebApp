<%@page import="Business.Account"%>
<!DOCTYPE html>
<!-- 
Jason Rodriguez
Lab #8 Part 1
8/30/2022
I promise I wrote this code
-->
<html>
    <head>
        <title>Account Lookup</title>
        <link rel="stylesheet" href="newcss.css">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body class="actlookbody">
        <header>
            <center><h1>Account Lookup</h1></center>
        </header>
        
        <% 
            Account a1 = (Account)session.getAttribute("a1");
        %>
        
        
        <div class="body-container">
            <form name="data-form" action="AccountLookupServlet">
            <div class="item">
            <label for="account-number">Account Number</label>
            <input type="text" id="account-number" name="account-number" value="<%= a1.getAccountNumber() %>">
            </div>
            
            <div class="item">
            <label for="customer-id">Customer id</label>
            <input type="text" id="customer-id" name="customer-id" value="<%= a1.getCustomerId() %>">
            </div>
            
            <div class="item">
            <label for="type">Type</label>
            <input type="text" id="type" name="type" value="<%= a1.getType() %>">
            </div>
            
            <div class="item">
            <label for="balance">Balance</label>
            <input type="text" id="balance" name="balance" value="<%= a1.getBalance() %>">
            </div>

            <div class="button-box">
                <button type="submit">Retrieve</button>
                <button type="button">Clear</button>
                
            
            </div>
            </form>
            
        </div>
    </body>
</html>
