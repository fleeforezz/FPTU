<%-- 
    Document   : permissionDenied
    Created on : Nov 1, 2024, 11:59:21 AM
    Author     : jso
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/permissionDenied.css">
        <script src="https://unpkg.com/@phosphor-icons/web"></script>
        <link rel="shortcut icon" href="assets/coffee.png" type="image/x-icon">
        <title>Permission Denied</title>
    </head>
    <body>
        <div class="permission">
            <img src="assets/padlock.png" />
            <h1>Oops! Access denied </h1>
            <p>
                You don't have permission to access this page.
                <br>
                Contact your administrator to get permissions.
            </p>
            <a href="home">
                Go to home
            </a>
        </div>

    </body>
</html>
