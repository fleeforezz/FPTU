<%-- 
    Document   : sidebar
    Created on : Oct 18, 2024, 10:21:28 PM
    Author     : jso
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<body>
    <div class="sidebar">
        <div class="general-menu">
            <div class="logo">
                <img src="assets/coffee.png" />
                <h1>Espresso</h1>
            </div>
            <p>General Menu</p>
            <ul>
                <li>
                    <a href="home" class="home">Home</a>
                </li>
                <li>
                    <a href="manager" class="manager active">Product</a>
                </li>
                <li>
                    <a href="manager" class="finance">Finance</a>
                </li>
                <li>
                    <a href="analytics" class="analytics">Analytics</a>
                </li>
            </ul>
        </div>
        <div class="help-center">
            <p>Help Center</p>
            <ul>
                <li>
                    <a href="setting">Setting</a>
                </li>
                <li>
                    <a href="#">Help</a>
                </li>
            </ul>
        </div>
    </div>
</body>
