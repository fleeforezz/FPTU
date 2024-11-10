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
            <img src="${pageContext.request.contextPath}/resources/assets/coffee.png" />
            <h1>Espresso</h1>
        </div>

        <ul class="menu">
            <li>
                <a href="${pageContext.request.contextPath}/home">Home</a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/collection/list" class="product">Product</a>
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


        <div class="right-nav">
            <div class="hamburger-menu">
                <span style="font-size:30px;cursor:pointer" onclick="openNav()">
                    <i class="ph ph-list"></i>
                </span>
            </div>
            <div class="shopping-cart">
                <a href="">
                    <i class="ph ph-magnifying-glass"></i>
                </a>
                <a href="">
                    <i class="ph ph-shopping-bag"></i>
                </a>
            </div>
            <c:if test="${sessionScope.acc != null}" >
                <div class="account">
                    <img src="${pageContext.request.contextPath}/resources/assets/profile-1.jpg" />
                    <p>${sessionScope.acc.account}</p>
                    <i class="ph ph-caret-down"></i>
                    <div class="dropdown">
                        <ul>
                            <c:if test="${sessionScope.acc.roleInSystem == 1}">
                                <li>
                                    <a href="${pageContext.request.contextPath}/admin/dashboard">Admin Dashboard</a>
                                </li>
                            </c:if>
                            <c:if test="${sessionScope.acc.roleInSystem == 2}">
                                <li>
                                    <a href="${pageContext.request.contextPath}/manager/dashboard">Manager Dashboard</a>
                                </li>
                            </c:if>
                            <li>
                                <a href="${pageContext.request.contextPath}/account/general" >Edit Profile</a>
                            </li>
                            <li>
                                <a href="${pageContext.request.contextPath}/logout">Logout</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </c:if>

            <c:if test="${sessionScope.acc == null}" >
                <div class="account">
                    <a class="signup" href="${pageContext.request.contextPath}/signup">Sign Up</a>
                    <a class="login" href="${pageContext.request.contextPath}/login">Login</a>
                </div>
            </c:if>
        </div>

        <div id="hamburger-btn" class="overlay">
            <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">
                &times;
            </a>
            <div class="overlay-content">
                <a href="home">Home</a>	
                <a href="collection">Product</a>
                <a href="#">About Us</a>
                <a href="#">Contact</a>
            </div>
        </div>
    </nav>

</body>
