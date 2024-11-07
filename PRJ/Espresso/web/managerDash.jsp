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
        <link rel="stylesheet" href="css/managerDash.css">
        <script src="https://unpkg.com/@phosphor-icons/web"></script>
        <link rel="shortcut icon" href="assets/coffee.png" type="image/x-icon">
        <title>Manager - Espresso</title>
    </head>
    <body>
        <jsp:include page="components/navbar.jsp"></jsp:include>
            <div class="product-table">
            <%--<jsp:include page="components/sidebar.jsp"></jsp:include>--%>
            <div class="heading">
                <div class="heading-child">
                    <h1>Product list</h1>
                    <p>Efficiently oversee and elevate coffee product with expertise.</p>
                </div>
                <a href="addProduct">
                    <i class="ph ph-plus"></i>
                    Add product
                </a>
            </div>

            <div class="product-table-container">
                <table>
                    <tr style="height: 50px; background: #dfdfc5; position: sticky; top: 0px;">
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
                                    <img src="${o.productImage}" />
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
        <jsp:include page="components/footer.jsp" ></jsp:include>
    </body>
</html>
