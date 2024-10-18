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
                <div class="product-table-container">
                    <table>
                        <tr style="height: 50px; background: #f1f1f1;">
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
                            <td class="">
                                <a href="editDetail?ProductId=${o.productId}" class="edit-button">
                                    <i class="ph ph-pencil-line"></i>
                                </a>
                                <a href="deleteProduct?ProductId=${o.productId}" class="delete-button">
                                    <i class="ph ph-trash"></i>
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>

        </div>

    </body>
</html>
