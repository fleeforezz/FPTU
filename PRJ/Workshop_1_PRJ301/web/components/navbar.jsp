<%-- 
    Document   : navbar
    Created on : Oct 17, 2024, 10:43:33 AM
    Author     : jso
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<body>
    <nav class="nav-bar">
        <div class="logo">
            <img src="assets/coffee.png" />
            <h1>Espresso</h1>
        </div>

        <ul class="menu">
            <li>
                <a href="home">Home</a>
            </li>
            <li>
                <a href="#" class="product">Product</a>
                <i class="ph ph-caret-down"></i>
                <div class="product-dropdown">
                    <ul>
                        <li>
                            <a href="#" class="element">Coffee</a>
                        </li>
                        <li>
                            <a href="#" class="element">Coffee Shop</a>
                        </li>
                        <li>
                            <a href="#" class="element">Espresso Bar</a>
                        </li>
                        <li>
                            <a href="#" class="element">Coffee Roaster</a>
                        </li>
                        <li>
                            <a href="#" class="element">Coffee Bistro</a>
                        </li>
                        <li>
                            <a href="#" class="element">Tea House</a>
                        </li>
                    </ul>
                </div>
            </li>
            <li>
                <a href="#">About Us</a>
            </li>
            <li>
                <a href="#">Contact</a>
            </li>
        </ul>

        <c:if test="${sessionScope.acc != null}" >
            <div class="account">
                <img src="assets/profile-1.jpg" />
                <p>${sessionScope.acc.account}</p>
                <i class="ph ph-caret-down"></i>
                <div class="dropdown">
                    <ul>
                        <c:if test="${sessionScope.acc.roleInSystem == 1}">
                            <li>
                                <a href="admin">Admin Dashboard</a>
                            </li>
                        </c:if>
                        <c:if test="${sessionScope.acc.roleInSystem == 2}">
                            <li>
                                <a href="manager">Manager Dashboard</a>
                            </li>
                        </c:if>
                        <li>
                            <a href="logout">Logout</a>
                        </li>
                    </ul>
                </div>
            </div>
        </c:if>

        <c:if test="${sessionScope.acc == null}" >
            <div class="account">
                <a href="home" class="register-butn">
                    <i class="ph ph-user"></i>
                </a>
                <div class="dropdown">
                    <ul>
                        <li>
                            <a href="login" class="login">Login</a>
                        </li>
                        <li>
                            <a href="signup" class="signup">Sign up</a>
                        </li>
                    </ul>
                </div>
            </div>
        </c:if>
    </nav>
</body>
