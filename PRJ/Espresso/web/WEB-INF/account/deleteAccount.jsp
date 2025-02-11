<%-- 
    Document   : destroy_confirm
    Created on : Oct 20, 2024, 10:05:31 AM
    Author     : jso
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/destroy_confirm.css">
        <script src="https://unpkg.com/@phosphor-icons/web"></script>
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/assets/coffee.png" type="image/x-icon">
        <title>Edit - Espresso</title>
    </head>
    <body>
        <jsp:include page="../../components/navbar.jsp"></jsp:include>
            <div class="confirm-container">
                <div class="confirm-child">
                    <img src="${pageContext.request.contextPath}/resources/assets/depression.png" />
                    <h1>
                        We’re sorry to see you go
                    </h1>
                    <p class="para-1">
                        If you just want to change your username, you can<br> <a href="profile">do that here.</a>
                    </p>
                    <p class="para-1">
                        Be advised, account deletion is final. There will be<br> no way to restore your account.
                    </p>

                    <div class="decision-button">
                        <a href="general" class="nevermind">Nevermind</a>
                        <!--<a href="deleteUser" class="confirmDelete">Delete My Account!</a>-->
                        <form method="post" action="delete">
                            <button type="submit">Delete My Account!</button>
                        </form>
                    </div>
                </div>
            </div>
            <script src="${pageContext.request.contextPath}/resources/script/main.js"></script>
        <jsp:include page="../../components/footer.jsp"></jsp:include>
    </body>
</html>
