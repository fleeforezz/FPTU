<%-- 
    Document   : product
    Created on : Oct 31, 2024, 10:49:51 PM
    Author     : jso
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

        <div class="product">
            <div class="product-view">
                <img src="${productDetail.productImage}" />
                <div class="product-info">
                    <h1 class="product-name">
                        ${productDetail.productName}
                    </h1>
                    <span class="review">
                        <c:forEach begin="1" end="5" >
                            <i class="ph ph-star"></i>
                        </c:forEach>
                        Reviews
                    </span>
                    <p class="price">
                        $${productDetail.price}
                    </p>
                    <p class="Availability">
                        <span class="title">Availability:</span>
                        ${productDetail.unit}
                    </p>
                    <p class="Manufacturing">
                        <span class="title">Manufacturing:</span>
                        ${productDetail.postedDate}
                    </p>
                    <p class="Category">
                        <span class="title">Category:</span>
                        ${productDetail.postedDate}
                    </p>
                    <p class="mini-description">
                        ${productDetail.brief}
                    </p>
                    <div class="product-action">
                        <a href="" class="add-cart">
                            <i class="ph-bold ph-shopping-bag"></i>
                            Add to cart
                        </a>
                        <a href="" class="buy-now">
                            Buy now
                        </a>
                    </div>
                    <p class="delivery">
                        <i class="ph-bold ph-truck"></i>
                        Free delivery on orders over $30.0
                    </p>
                </div>
            </div>

            <div class="product-description">
                <h1>Details</h1>

                <div class="description-container">
                    <div class="description">
                        ${productDetail.brief}

                        <h2>Shipping policy of our store</h2>
                        <p>
                            Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate

                        <ul>
                            <li>
                                1-2 business days (Typically by end of day)
                            </li>
                            <li>
                                30 days money back guaranty
                            </li>
                            <li>
                                24/7 live support
                            </li>
                            <li>
                                odio dignissim qui blandit praesent
                            </li>
                            <li>
                                luptatum zzril delenit augue duis dolore
                            </li>
                            <li>
                                te feugait nulla facilisi.
                            </li>
                        </ul>

                        Nam liber tempor cum soluta nobis eleifend option congue nihil imperdiet doming id quod mazim placerat facer possim assum. Typi non habent claritatem insitam; est usus legentis in iis qui facit eorum

                        claritatem. Investigationes demonstraverunt lectores legere me lius quod ii legunt saepius. Claritas est etiam processus dynamicus, qui sequitur mutationem consuetudium lectorum. Mirum est notare quam littera gothica, quam nunc putamus parum claram, anteposuerit litterarum formas humanitatis per

                        seacula quarta decima et quinta decima. Eodem modo typi, qui nunc nobis videntur parum clari, fiant sollemnes in futurum.F
                        </p>
                    </div>

                    <div class="review">
                        <div class="rating">
                            <c:forEach begin="1" end="5" >
                                <i class="ph-fill ph-star"></i>
                            </c:forEach>
                            <span>4.8</span>
                        </div>
                        <div class="separator"></div>
                        <p class="discount">
                            Todays product
                            <br>
                            discount over
                            ${productDetail.discount}%
                        </p>
                    </div>
                </div>
            </div>
        </div>

        <script src="script/main.js"></script>
        <jsp:include page="components/footer.jsp"></jsp:include>
    </body>
</html>
