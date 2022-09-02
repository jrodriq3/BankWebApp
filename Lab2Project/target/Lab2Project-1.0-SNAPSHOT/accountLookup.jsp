<!DOCTYPE html>
<!-- 
Jason Rodriguez
Lab #2
8/19/2022
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
        
        <div class="body-container">
            <form name="data-form" action="AccountLookupServlet">
            <div class="item">
            <label for="account-number">Account Number</label>
            <input type="text" id="account-number" name="account-number" placeholder="0000">
            </div>
            <div class="item">
            <label for="customer-id">Customer id</label>
            <input type="text" id="customer-id" name="customer-id" placeholder="0000">
            </div>
            <div class="item">
            <label for="type">Type</label>
            <input type="text" id="type" name="type" placeholder="checking">
            </div>
            <div class="item">
            <label for="balance">Balance</label>
            <input type="text" id="balance" name="balance" placeholder="0.00">
            </div>
            <div class="button-box">
                <button type="submit">Retrieve</button>
                <button type="button">Clear</button>
                
            
            </div>
            </form>
            
        </div>
    </body>
</html>
