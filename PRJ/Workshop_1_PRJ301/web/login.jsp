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
        <script src="https://unpkg.com/@phosphor-icons/web"></script>
        <link rel="shortcut icon" href="assets/coffee.png" type="image/x-icon">
        <title>Login - Espresso</title>
    </head>
    <body>
        <jsp:include page="components/navbar.jsp"></jsp:include>
        <div class="login-form">
            <h1>Welcome back!</h1>
            <p>Fill your account information to login</p>
            <form method="post" action="login">
                <label>Username</label>
                <input class="username" type="text" name="account" placeholder="Enter username" required="required"/>

                <label>Password</label>
                <input class="password" type="password" name="pass" placeholder="Enter password" required="required"/>
                <p>
                    Don't have account yet?<a href="signup">Sign Up</a>
                </p>
                <button class="submit-btn" type="submit">Login</button>
            </form>
        </div>

        <jsp:include page="components/footer.jsp"></jsp:include>
    </body>
</html>
