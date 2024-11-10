<%-- 
    Document   : login
    Created on : Oct 16, 2024, 10:39:45 PM
    Author     : jso
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/login.css">
        <script src="https://unpkg.com/@phosphor-icons/web"></script>
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/assets/coffee.png" type="image/x-icon">
        <title>Login - Espresso</title>
    </head>
    <body>
        <jsp:include page="components/navbar.jsp"></jsp:include>
            <div class="login-form">
                <h1>Welcome back!</h1>
                <p>Fill your account information to login</p>
            <c:set var="coolie" value="${pageContext.request.cookies}" />
            <form method="post" action="login">
                <%
                    if (request.getAttribute("ErrorMessage") != null) {
                        String error_message = (String) request.getAttribute("ErrorMessage");
                %>
                <div class="error-banner">
                    <i class="ph-bold ph-warning-circle"></i>
                    <div class="error-message">
                        <span>Login failed</span>
                        <br>
                        <%=error_message%>
                    </div>
                </div>
                <%
                    }
                %>
                <label>Username</label>
                <input class="username" type="text" name="account" placeholder="Enter username" required="required" value="${cookie.username_cookie.value}"/>

                <label>Password</label>
                <input class="password" type="password" name="pass" placeholder="Enter password" required="required" value="${cookie.password_cookie.value}"/>

                <span class="dont-have-account">
                    <div class="remember-me">
                        <input type="checkbox" name="remember" value="ON" ${(cookie.remember_cookie != null ?'checked' : '')}/>
                        <label>Remember me</label>
                    </div>
                    Don't have account yet?<a href="signup">Sign Up</a>
                </span>


                <button class="submit-btn" type="submit">Login</button>
            </form>
        </div>

        <jsp:include page="components/footer.jsp"></jsp:include>
    </body>
</html>
