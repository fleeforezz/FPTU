<%-- 
    Document   : productList
    Created on : Oct 31, 2024, 1:34:28 PM
    Author     : jso
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://unpkg.com/@phosphor-icons/web"></script>
        <link rel="stylesheet" href="css/productList.css">
        <link rel="shortcut icon" href="assets/coffee.png" type="image/x-icon">
        <title>Products - Espresso</title>
    </head>
    <body>
        <jsp:include page="components/navbar.jsp" ></jsp:include>
            <div class="banner">
                <img class="coffee-banner" src="assets/coffee-jar.jpg" />
                <ul>
                    <li>
                        <a href="home">Home</a>
                    </li>
                    <li>
                        Products
                    </li>
                </ul>
            </div>

            <div class="product-view">
                <ul>
                <c:forEach items="${productList}" var="o" >
                    <li>
                        <a href="products?productId=${o.productId}">
                            <div class="item">
                                <img src="${o.productImage}" />
                                <div class="product-info">
                                    <div class="product-name product-price">
                                        <p class="heading">${o.productName}</p>
                                        <p class="price">$${o.price}</p>
                                    </div>
                                    <c:forEach begin="1" end="5" >
                                        <i class="ph ph-star"></i>
                                    </c:forEach>
                                </div>

                            </div>
                        </a>
                    </li>
                </c:forEach>
            </ul>
        </div>
        <jsp:include page="components/footer.jsp"></jsp:include>
    </body>
</html>
