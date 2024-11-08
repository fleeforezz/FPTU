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
        <link rel="stylesheet" href="css/adminDash.css">
        <script src="https://unpkg.com/@phosphor-icons/web"></script>
        <link rel="shortcut icon" href="assets/coffee.png" type="image/x-icon">
        <title>Admin - Espresso</title>
    </head>
    <body>
        <div class="product-table">
            <jsp:include page="components/sidebar.jsp"></jsp:include>
                <div class="product-table-container">
                    <div class="summary-container">
                        <h1>Quick Access</h1>

                        <div class="summary-child">
                            <div class="number-of-account">
                                <i class="ph-bold ph-user-circle"></i>
                                <span>
                                    <p>
                                    ${listAccountSize}
                                </p>
                                Accounts
                            </span>
                        </div>
                        <div class="number-of-product">
                            <i class="ph ph-unite-square"></i>
                            <span>
                                <p>
                                    ${listProductSize}
                                </p>
                                Products
                            </span>
                        </div>
                        <div class="number-of-category">
                            <i class="ph ph-unite-square"></i>
                            <span>
                                <p>
                                    ${listCategorySize}
                                </p>
                                Categories
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
                    <h1>Account List</h1>
                    <a href="addProduct" class="addProduct">
                        <i class="ph ph-plus"></i>
                        Add Account
                    </a>
                </div>

                <table>
                    <tr class="top-table">
                        <th>Account</th>
                        <th>Password</th>
                        <th>LastName</th>
                        <th>FirstName</th>
                        <th>Birthday</th>
                        <th>Gender</th>
                        <th>Phone</th>
                        <th>Status</th>
                        <th>Account Role</th>
                        <th>Action</th>
                    </tr>
                    <c:forEach items="${listAccount}" var="o">
                        <tr>
                            <td style="width: 10%;">
                                <div class="Account">
                                    ${o.account}
                                </div>
                            </td>
                            <td style="width: 10%;">
                                ${o.pass}
                            </td>
                            <td style="width: 10%;">
                                ${o.lastName}
                            </td>
                            <td style="width: 10%;">
                                ${o.firstName}
                            </td>
                            <td style="width: 10%;">
                                ${o.birthday}
                            </td>
                            <td style="width: 10%;">
                                ${o.gender}
                            </td>
                            <td style="width: 10%;">
                                ${o.phone}
                            </td>
                            <td style="width: 10%;">
                                ${o.isUse}
                            </td>
                            <td style="width: 10%;">
                                ${o.roleInSystem}
                            </td>
                            <td>
                                <div class="action-btn">
                                    <a href="editProduct?ProductId=${o.account}" class="edit-button">
                                        <i class="ph ph-pencil-line"></i>
                                    </a>
                                    <a href="setActive?activeAccount=${o.account}" class="active-button">
                                        <i class="ph-duotone ph-check-square"></i>
                                        <!--<span>active</span>-->
                                    </a>
                                    <a href="setUnActive?unActivateAccount=${o.account}" class="unActive-button">
                                        <i class="ph-duotone ph-backspace"></i>
                                    </a>                                    
                                </div>
                            </td>
                        </tr>
                    </c:forEach>
                </table>

                <div class="product-list">
                    <h1>Category List</h1>
                    <a href="addProduct" class="addProduct">
                        <i class="ph ph-plus"></i>
                        Add Category
                    </a>
                </div>

                <table>
                    <tr class="top-table">
                        <th>Type ID</th>
                        <th>Category Name</th>
                        <th>Memo</th>
                        <th>Action</th>
                    </tr>
                    <c:forEach items="${listCategory}" var="o">
                        <tr>
                            <td style="width: 25%;">
                                ${o.typeId}
                            </td>
                            <td class="brief">
                                ${o.categoryName}
                            </td>
                            <td>
                                ${o.memo}
                            </td>
                            <td>
                                <div class="action-btn">
                                    <a href="editCategory?TypeId=${o.typeId}" class="edit-button">
                                        <i class="ph ph-pencil-line"></i>
                                    </a>
                                    <a href="deleteCategory?TypeId=${o.typeId}" class="delete-button">
                                        <i class="ph ph-trash"></i>
                                    </a>
                                </div>
                            </td>
                        </tr>
                    </c:forEach>
                </table>

                <div class="product-list">
                    <h1>Product List</h1>
                    <a href="addProduct" class="addProduct">
                        <i class="ph ph-plus"></i>
                        Add Product
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
    </body>
</html>

