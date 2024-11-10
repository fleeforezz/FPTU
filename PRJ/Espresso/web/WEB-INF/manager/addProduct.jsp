<%-- 
    Document   : addProduct
    Created on : Nov 8, 2024, 9:28:07 AM
    Author     : jso
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/addProduct.css">
        <script src="https://unpkg.com/@phosphor-icons/web"></script>
        <link rel="shortcut icon" href="assets/coffee.png" type="image/x-icon">
        <title>Add Product - Espresso</title>
    </head>
    <body>

        <div class="main-container">
            <jsp:include page="../../components/sidebar.jsp"></jsp:include>
                <div class="add-product-container">
                    <div class="path">
                        <ul>
                            <li>
                                <a href="manager">Product</a>
                            </li>
                            <li>
                                <a href="addProduct">Add Product</a>
                            </li>
                        </ul>
                    </div>

                    <form method="post" action="addProduct" enctype="multipart/form-data">
                        <div class="add-product-heading">
                            <div class="heading">
                                <i class="ph-bold ph-storefront"></i>
                                <h1>Add New Product</h1>
                            </div>
                            <button type="submit" class="submit">
                                Save
                            </button>
                        </div>

                        <div class="input-field">
                            <div class="input-field-child-1">
                                <div class="input-field-inner-child-1">
                                    <h2>General information</h2>

                                    <label class="label">Product ID</label>
                                    <input type="text" class="productID input" name="productId" required/>

                                    <label class="label">Name Product</label>
                                    <input type="text" class="product-name input" name="productName" required/>

                                    <label class="label">Description</label>
                                    <textarea name="brief" class="brief input"></textarea>

                                    <label class="label">Posted Date</label>
                                    <input type="date" class="posted-date input" name="postedDate" required/>

                                    <label class="label">Category</label>
                                    <select class="category-name input" name="typeId">
                                    <c:forEach items="${listProductCategory}" var="o">
                                        <option value="${o.typeId}">
                                            ${o.categoryName}
                                        </option>
                                    </c:forEach>
                                </select>
                            </div>

                            <div class="input-field-inner-child-2">
                                <h2>Upload Image</h2>
                                <img class="imagePreview" id="imagePreview" src="assets/collection-empty.svg" alt="Image Preview">
                                <div class="upload-btn-wrapper">
                                    <button class="btn">Upload a file</button>
                                    <input type="file" name="productImage" class="file input" id="file" accept="image/*" required onchange="previewImage(event)">
                                </div>
                            </div>

                        </div>
                            
                        <div class="input-field-child-2">
                            <h2>Pricing And Unit</h2>

                            <label class="label">Unit</label>
                            <input type="text" class="unit input" name="unit" required/>

                            <label class="label">Price</label>
                            <input type="text" class="price input" name="price" required/>

                            <label class="label">Discount</label>
                            <select class="discount input" name="discount">
                                <option value="0">0%</option>
                                <option value="10">10%</option>
                                <option value="20">20%</option>
                                <option value="30">30%</option>
                                <option value="40">40%</option>
                                <option value="50">50%</option>
                                <option value="60">60%</option>
                                <option value="70">70%</option>
                                <option value="80">80%</option>
                                <option value="90">90%</option>
                                <option value="100">100%</option>       
                            </select>
                        </div>
                    </div>
                </form>

            </div>
        </div>

        <script src="script/main.js"></script>
    </body>
</html>
