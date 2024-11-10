<%-- 
    Document   : managerDash
    Created on : Oct 18, 2024, 5:35:54 PM
    Author     : jso
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/managerDash.css">
        <script src="https://unpkg.com/@phosphor-icons/web"></script>
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/assets/coffee.png" type="image/x-icon">
        <title>Manager - Espresso</title>
    </head>
    <body>
        <div class="product-table">
            <jsp:include page="../../components/sidebar.jsp"></jsp:include>
                <div class="product-table-container">
                    <div class="summary-container">
                        <h1>Quick Access</h1>

                        <div class="summary-child">
                            <div class="number-of-product">
                                <i class="ph ph-package"></i>
                                <span>
                                    <p>
                                    ${listSize}
                                </p>
                                products
                            </span>
                        </div>
                        <div class="number-of-unit">
                            <i class="ph ph-unite-square"></i>
                            <span>
                                <p>
                                    ${sumOfUnit}
                                </p>
                                units
                            </span>
                        </div>
                        <div class="account-info">
                            <i class="ph ph-user"></i>
                            <span>
                                <p>
                                    ${sessionScope.acc.account}
                                </p>
                                ${sessionScope.acc.lastName}
                                ${sessionScope.acc.firstName}
                            </span>
                        </div>
                    </div>
                </div>

                <div class="product-list">
                    <h1>Product List</h1>
                    <a href="add" class="addProduct">
                        <i class="ph ph-plus"></i>
                        Add product
                    </a>
                </div>

                <table>
                    <tr class="top-table">
                        <th>Name</th>
                        <th>Brief</th>
                        <th>Date</th>
                        <th>Price</th>
                        <th>Discount</th>
                        <th>Action</th>
                    </tr>
                    <c:forEach items="${listProduct}" var="o">
                        <tr>
                            <td style="width: 25%;">
                                <div class="product-info">
                                    <img src="${pageContext.request.contextPath}/${o.productImage}" />
                                    ${o.productName}
                                </div>
                            </td>
                            <td class="brief">
                                ${o.brief}
                            </td>
                            <td>
                                ${o.postedDate}
                            </td>
                            <td>
                                ${o.price}
                            </td>
                            <td>
                                ${o.discount}
                            </td>
                            <td>
                                <div class="action-btn">
                                    <a href="editProduct?ProductId=${o.productId}" class="edit-button">
                                        <i class="ph ph-pencil-line"></i>
                                    </a>
                                    <a href="deleteProduct?ProductId=${o.productId}" class="delete-button">
                                        <i class="ph ph-trash"></i>
                                    </a>
                                </div>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>

        </div>

        <script src="script/main.js"></script>
    </body>
</html>
