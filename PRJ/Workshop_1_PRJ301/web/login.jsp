<%-- 
    Document   : login
    Created on : Oct 16, 2024, 10:39:45 PM
    Author     : jso
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/login.css">
        <title>Login</title>
    </head>
    <body>
        <p class="logo">Expresso</p>
        <img src="assets/fc36fa7816fe1847b3dcbc352f227a0f.jpg" />
        
        <div class="login-form">
            <h1>
                Welcome Back !
            </h1>
            <p>
                Login to continue your shoping
            </p>
            <form method="post" action="login">
                <label>Username</label>
                <input class="username" type="text" placeholder="Enter username" name="account" required="required"/>
                <label>Password</label>
                <input class="password" type="password" placeholder="Enter password" name="pass" required="required"/>
                <button type="submit">Login</button>
            </form>
        </div>
        
    </body>
</html>
