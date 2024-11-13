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
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/assets/coffee.png" type="image/x-icon">
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
                            <a href="collection/list" class="explore-more">
                                Explore more
                                <i class="ph-fill ph-arrow-circle-up-right"></i>
                            </a>
                        </p>
                    </div>
                    <video autoplay="autoplay" loop="loop" muted="muted" src="${pageContext.request.contextPath}/resources/assets/Coffee-ad.mkv" ></video>
            </section>
        </div>

        <div class="buy-now">
            <img class="coffee-roaster" src="${pageContext.request.contextPath}/resources/assets/battlecreek-coffee-roasters.jpg" />
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
                <a href="collection/list">Buy Now!</a>
            </div>
            <img class="leaf-deco" src="${pageContext.request.contextPath}/resources/assets/roaster-deco-1.webp" />
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
                    <a href="${pageContext.request.contextPath}/collection/product?productId=${o.productId}" class="product-item">
                        <c:if test="${o.productImage != null}">
                            <img src="${pageContext.request.contextPath}/${o.productImage}" />
                        </c:if>
                        <c:if test="${o.productImage == null}">
                            <img src="${pageContext.request.contextPath}/resources/assets/image-placeholder.jpg" />
                        </c:if>
                        <p>${o.productName}</p>
                        <div>
                            <p>$${o.price}</p>
                            <c:if test="${o.discount > 0}" >
                                <span class="discountPrice">Sale ${o.discount}%</span>
                            </c:if>
                        </div>
                    </a>
                </c:forEach>
            </div>
        </div>

        <div class="infinite-scroll">
            <div class="scroll">
                <div class="RightToLeft">
                    <p>Coffee 
                        <img src="${pageContext.request.contextPath}/resources/assets/coffee-bean.png" alt="">
                        Espresso 
                        <img src="${pageContext.request.contextPath}/resources/assets/coffee-bean.png" alt="">
                        Bar 
                        <img src="${pageContext.request.contextPath}/resources/assets/coffee-bean.png" alt=""> 
                        Menu 
                        <img src="assets/coffee-bean.png" alt="">
                        Coffee 
                        <img src="${pageContext.request.contextPath}/resources/assets/coffee-bean.png" alt=""> 
                        Espresso 
                        <img src="${pageContext.request.contextPath}/resources/assets/coffee-bean.png" alt=""> 
                        Bar 
                        <img src="${pageContext.request.contextPath}/resources/assets/coffee-bean.png" alt=""> 
                        Menu
                        <img src="${pageContext.request.contextPath}/resources/assets/coffee-bean.png" alt="">
                    </p>
                </div>
            </div>
        </div>

        <div class="list-product">
            <div class="heading">
                <p>
                    Today's On Sale Products
                </p>
                <h1>
                    Discover the taste
                    <br>
                    of the perfect coffee
                </h1>
            </div>

            <div class="product-gallary">
                <c:forEach items="${saleProductList}" var="o" >
                    <a href="${pageContext.request.contextPath}/collection/product?productId=${o.productId}" class="product-item">
                        <img src="${o.productImage}" />
                        <p>${o.productName}</p>
                        <div>
                            <p>$${o.price}</p>
                            <c:if test="${o.discount > 0}" >
                                <span class="discountPrice">Sale ${o.discount}%</span>
                            </c:if>
                        </div>
                    </a>
                </c:forEach>
            </div>
        </div>

        <div class="clients">
            <div class="clients-parent">
                <div class="clients-row">
                    <img src="${pageContext.request.contextPath}/resources/assets/coffee-client-1.png" alt="">
                    <img src="${pageContext.request.contextPath}/resources/assets/coffee-client-2.png" alt="">
                    <img src="${pageContext.request.contextPath}/resources/assets/coffee-client-3.png" alt="">
                    <img src="${pageContext.request.contextPath}/resources/assets/coffee-client-4.png" alt="">
                    <img src="${pageContext.request.contextPath}/resources/assets/coffee-client-5.png" alt="">
                    <img src="${pageContext.request.contextPath}/resources/assets/coffee-client-6.png" alt="">
                </div>
            </div>
            <!--<img src="assets/roaster-deco-2-2.png" alt="" class="roaster-decor">-->
        </div>




        <script src="${pageContext.request.contextPath}/resources/script/main.js"></script>
        <jsp:include page="components/footer.jsp"></jsp:include>
    </body>
</html>
