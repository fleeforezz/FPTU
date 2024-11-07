<%-- 
    Document   : sidebar
    Created on : Oct 18, 2024, 10:21:28 PM
    Author     : jso
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<body>
    <div class="sidebar">
        <div class="logo">
            <img src="assets/coffee.png" />
            <h1>Espresso</h1>
        </div>
        <div class="general-menu">
            <p>General Menu</p>
            <ul>
                <li>
                    <a href="home" class="home">
                        <i class="ph-bold ph-house"></i>
                        Home
                    </a>
                </li>
                <li>
                    <a href="manager" class="manager active">
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
</body>
