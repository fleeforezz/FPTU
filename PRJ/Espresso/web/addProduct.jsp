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
        <link rel="stylesheet" href="css/addProduct.css">
        <script src="https://unpkg.com/@phosphor-icons/web"></script>
        <link rel="shortcut icon" href="assets/coffee.png" type="image/x-icon">
        <title>Add Product - Espresso</title>
    </head>
    <body>

        <div class="main-container">
            <jsp:include page="components/sidebar.jsp"></jsp:include>
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
                        <h2>General information</h2>

                        <label>Product ID</label>
                        <input type="text" class="productID" name="productId" required/>
                        
                        <label>Name Product</label>
                        <input type="text" class="product-name" name="productName" required/>

                        <label>Choose an image:</label>
                        <input type="file" name="productImage" id="file" accept="image/*" required>

                        <label>Description</label>
                        <textarea name="brief" class="brief"></textarea>

                        <label>Posted Date</label>
                        <input type="date" class="posted-date" name="postedDate" required/>

                        <label>Category</label>
                        <select class="category-name" name="typeId">
                            <c:forEach items="${listProductCategory}" var="o">
                                <option value="${o.typeId}">
                                    ${o.categoryName}
                                </option>
                            </c:forEach>
                        </select>

                        <label>Unit</label>
                        <input type="number" class="unit" name="unit" required/>

                        <label>Price</label>
                        <input type="number" class="price" name="price" required/>

                        <label>Discount</label>
                        <select class="discount" name="discount">
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
                </form>

            </div>
        </div>

    </body>
</html>
