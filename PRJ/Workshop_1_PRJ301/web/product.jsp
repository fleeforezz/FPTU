<%-- 
    Document   : product
    Created on : Oct 31, 2024, 10:49:51 PM
    Author     : jso
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/product.css">
        <script src="https://unpkg.com/@phosphor-icons/web"></script>
        <link rel="shortcut icon" href="assets/coffee.png" type="image/x-icon">
        <title>Product - Espresso</title>
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
                        ${productDetail.productName}
                    </li>
                </ul>
            </div>

            <div class="product-view">
                <img src="${productDetail.productImage}" />
            <div class="product-info">
                <h1 class="product-name">
                    ${productDetail.productName}
                </h1>
                <p class="price">
                    $${productDetail.price}
                </p>
                <p class="description">
                    ${productDetail.brief}
                </p>
                <div class="add-cart buy-now">
                    <a href="">Add to cart</a>
                    <a href="">Buy now</a>
                </div>
            </div>
        </div>
        <jsp:include page="components/footer.jsp"></jsp:include>
    </body>
</html>
