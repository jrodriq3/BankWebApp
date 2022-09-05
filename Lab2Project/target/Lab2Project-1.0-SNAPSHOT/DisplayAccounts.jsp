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
    <body style="
    margin: 0px;
    display: flex;
    background-image: url('img/vault.jpeg');
    background-position: center center;
    background-repeat: no-repeat;
    background-attachment: fixed;
    background-size: cover;
    backdrop-filter: blur(2px);
    ">
        <div style="
    display: flex;
    min-height: 100vh;
    min-width: 100vw;
    
    
    background:rgba(0, 0, 0, 0.6);
    ">
        
        
        <div class="mask text-center justify-content-center align-items-center" style="
                 background-color: rgba(0, 0, 0, 0.5);
                 display: flex;
                 min-width: 100vw;
                 max-height: 50px;
                 position: fixed;
                 align-items: center;
                 justify-content: center;
                 
                 ">
                 <img src="img/ctclogo.png" style="
                 width: 50px;
                 height: 50px;
                 align-self: center;
                 "></img>
                 <div style="
                    font-size: 50px;
                    color: white;
                    display: inline-block;
                    align-self: center;
                    ">ChattBank</div>
            </div>
        
        
        
        
        
<div class="container">
	
	<div class="table">
		<div class="table-header">
			
			<div class="header__item"><a id="wins" class="filter__link filter__link--number" href="#">Account Number</a></div>
			<div class="header__item"><a id="draws" class="filter__link filter__link--number" href="#">Customer Id</a></div>
			<div class="header__item"><a id="losses" class="filter__link filter__link--number" href="#">Type</a></div>
			<div class="header__item"><a id="total" class="filter__link filter__link--number" href="#">Balance</a></div>
		</div>
		<div class="table-content">
                    <%
                        //Getting Customer obj c1 from session
                        Customer c1 = (Customer) session.getAttribute("c1");
                        //Getting number of accounts for the customer
                        int numOfAccounts = c1.aList.getCount();
                        for (int i = 0; i < numOfAccounts; i++) {
                            Account currentAccount = c1.aList.accArr.get(i);
                            out.println("<div class='table-row'>");
                                out.println("<div class='table-data'>" + currentAccount.getAccountNumber() + "</div>");
                                out.println("<div class='table-data'>" + currentAccount.getCustomerId() + "</div>");
                                out.println("<div class='table-data'>" + currentAccount.getType() + "</div>");
                                out.println("<div class='table-data'>" + currentAccount.getBalance() + "</div>");
                                out.println("</div>");
                        }
                    %>
		</div>	
	</div>
</div>
        </div>
    </body>
</html>
