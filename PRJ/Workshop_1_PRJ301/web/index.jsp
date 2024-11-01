<%-- 
    Document   : index
    Created on : Oct 16, 2024, 5:04:25 PM
    Author     : jso
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://unpkg.com/@phosphor-icons/web"></script>
        <link rel="stylesheet" href="css/style.css">
        <link rel="shortcut icon" href="assets/coffee.png" type="image/x-icon">
        <title>Espresso</title>
    </head>
    <body>

        <div class="header">
            <jsp:include page="components/navbar.jsp"></jsp:include>

                <section class="hero">
                    <div class="upper-hero">
                        <h1>
                            Master the quality of every <span>coffee bean</span>
                        </h1>
                        <p>
                            The quality of Expresso coffee has become one of its strengths and 
                            is famous all over the world. Our coffee is produced from quality coffee beans. 
                            <br>
                            <a href="collection" class="explore-more">
                                Explore more
                                <i class="ph-fill ph-arrow-circle-up-right"></i>
                            </a>
                        </p>
                    </div>
                    <video autoplay="autoplay" loop="loop" muted="muted" src="assets/Coffee-ad.mkv" ></video>
                </section>
            </div>

            <div class="buy-now">
                <img class="coffee-roaster" src="assets/battlecreek-coffee-roasters.jpg" />
                <div class="buy-now-container">
                    <div class="buy-now-heading">
                        <p>
                            Collaborative Services
                        </p>
                        <h1>
                            Exquisite Coffee
                            <br>
                            Bean Quality
                        </h1>
                    </div>
                    <div class="buy-now-para">
                        <p>
                            We put product quality and hygiene safety in 
                            <br>
                            the production process first.
                        </p>
                        <p>
                            <span>01.</span>
                            Different blends
                        </p>
                        <div class="separate-line"></div>
                        <p>
                            <span>02.</span>
                            Professional roasting
                        </p>
                    </div>
                    <a href="#">Buy Now!</a>
                </div>
                <img class="leaf-deco" src="assets/roaster-deco-1.webp" />
            </div>

            <div class="list-product">
                <div class="heading">
                    <p>
                        Featured Products
                    </p>
                    <h1>
                        Discover the taste
                        <br>
                        of the perfect coffee
                    </h1>
                </div>

                <div class="product-gallary">
                <c:forEach items="${productList}" var="o" >
                    <a href="#" class="product-item">
                        <img src="${o.productImage}" />
                        <p>${o.productName}</p>
                        <div>
                            <p>${o.price}</p>
                            <c:if test="${o.discount > 0}" >
                                <span class="discountPrice">Sale ${o.discount}%</span>
                            </c:if>
                        </div>
                    </a>
                </c:forEach>
            </div>
        </div>
            <script src="script/main.js"></script>
        <jsp:include page="components/footer.jsp"></jsp:include>
    </body>
</html>
