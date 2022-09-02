<!DOCTYPE html>
<!-- 
Jason Rodriguez
Lab #2 - Extra Credit
8/20/2022
-->
<html>
    <head>
        <title>Login Page</title>
        <script type="text/javascript">
            var idDone = false;
            function isADecimal(n) {
                var result = (n - Math.floor(n)) !== 0; 
                return result;
            }
            function validateId() {
                var a;
                var b;
                a = document.dataForm.customerId.value;
                b = document.dataForm.password.value;
                if (a == "") {
                    alert("you must enter something in id field");
                    return;
                }
                if (isNaN(a)) {
                    alert("id must be a number in id field");
                    return;
                }
                if (a < 3000 || a > 3999) {
                    alert("id must be between 2999 and 4000");
                    return;
                }
                if (isADecimal(a) == true) {
                    alert("number cant be a decimal");
                    return;
                }
                idDone = true;
            }
            function validatePassword() {
                if (idDone == false) {
                    return;
                } 
                var a;
                var b;
                a = document.dataForm.customerId.value;
                b = document.dataForm.password.value;
                if (b == "") {
                    alert("You must enter something in password field");
                    return;
                }
            }
            function clearClicked() {
                document.dataForm.customerId.value = "";
                document.dataForm.password.value = "";
            }
        </script>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="login.css">
    </head>
    <body style="
    margin: 0px;
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
    align-items: center;
    justify-content: center;
    background:rgba(0, 0, 0, 0.6);
    ">
        
    <form Name="dataForm" action="LoginServlet">
        <div class="container">
            <div class="brand-logo"></div>
            <div class="brand-title">ChattBank</div>
            <div class="inputs">
              <label>EMAIL</label>
              <input type="email" placeholder="example@test.com" />
              <label>PASSWORD</label>
              <input type="password" placeholder="Min 6 charaters long" />
              <button type="submit">LOGIN</button>
            </div>
    </form>
</div>
    </body>
</html>
