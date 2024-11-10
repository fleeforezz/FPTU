<%-- 
    Document   : footer
    Created on : Oct 17, 2024, 1:14:13 PM
    Author     : jso
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<footer class="footer">
    <nav>
        <div class="logo">
            <img src="${pageContext.request.contextPath}/resources/assets/coffee.png" />
            <h1>Expresso</h1>
        </div>

        <ul class="footer-menu">
            <li>
                <a href="home">Home</a>
            </li>
            <li>
                <a href="collection">Product</a>
            </li>
            <li>
                <a href="#">About Us</a>
            </li>
            <li>
                <a href="#">Contact</a>
            </li>
            <li>
                <a href="#">Coffee Shop</a>
            </li>
        </ul>
    </nav>

    <div class="footer-separate"></div>

    <div class="shop-info">
        <div class="address">
            <p>
                <span>828,</span>
                <span>Đ. Sư Vạn Hạnh</span>
                <span>Phường 12,</span>
                <span>Quận 10.</span>
            </p>
        </div>
        <div class="contact">
            <p>+84 - 990 773 9311</p>
            <p>fleeforezz@gmail.com</p>
        </div>
        <div class="register">
            <p>Latest update from us</p>
            <c:if test="${sessionScope.acc == null}">
                <a href="signup">
                    Sign up now!
                </a>
            </c:if>
            <c:if test="${sessionScope.acc != null}">
                <p>
                    Hi! ${sessionScope.acc.account}
                </p>
            </c:if>
        </div>
    </div>

    <div class="social">
        <p>Espresso © 2023. Đã đăng ký bản quyền.</p>
    </div>
</footer>
