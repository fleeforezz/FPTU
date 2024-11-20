<%-- 
    Document   : sidebar
    Created on : Oct 18, 2024, 10:21:28 PM
    Author     : jso
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<body>
    <div class="sidebar" id="mySidenav">
        <div class="container">
            <div class="logo">
                <img src="${pageContext.request.contextPath}/resources/assets/coffee.png" />
                <h1>Espresso</h1>
            </div>
            <c:if test="${sessionScope.acc.roleInSystem == 1}" >
                <p>Admin Dashboard</p>
            </c:if>
            <div class="general-menu">
                <p>General Menu</p>
                <ul>
                    <li>
                        <a href="${pageContext.request.contextPath}/home" class="home">
                            <i class="ph-bold ph-house"></i>
                            Home
                        </a>
                    </li>
                    <c:if test="${sessionScope.acc.roleInSystem == 1}">
                        <li>
                            <a href="admin" class="admin">
                                <i class="ph-bold ph-user-circle"></i>
                                Accounts
                            </a>
                        </li>
                    </c:if>
                    <li>
                        <a href="${pageContext.request.contextPath}/manager/dashboard" class="manager">
                            <i class="ph-bold ph-package"></i>
                            Product
                        </a>
                    </li>
                    <li>
                        <a href="manager" class="finance">
                            <i class="ph-bold ph-chart-line"></i>
                            Finance
                        </a>
                    </li>
                    <li>
                        <a href="analytics" class="analytics">
                            <i class="ph-bold ph-chart-pie"></i>
                            Analytics
                        </a>
                    </li>
                </ul>
            </div>
            <div class="help-center">
                <p>Help Center</p>
                <ul>
                    <li>
                        <a href="setting" class="setting">
                            <i class="ph-bold ph-gear-six"></i>
                            Setting
                        </a>
                    </li>
                    <li>
                        <a href="#" class="help">
                            <i class="ph-bold ph-question"></i>
                            Help
                        </a>
                    </li>
                </ul>
            </div>
        </div>

        <div class="account-container">
            <div class="account">
                <img src="${pageContext.request.contextPath}/resources/assets/account.png" />
                <div class="account-name">
                    ${sessionScope.acc.account}
                </div>
<!--                <a onclick="openNav()">
                    <i class="ph ph-arrows-left-right"></i>
                </a>
                <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">
                    <i class="ph ph-arrows-left-right"></i>
                </a>-->
            </div>
        </div>
    </div>
</body>
