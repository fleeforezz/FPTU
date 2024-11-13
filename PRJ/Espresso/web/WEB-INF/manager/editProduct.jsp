<%-- 
    Document   : editProduct
    Created on : Oct 19, 2024, 10:16:55 AM
    Author     : jso
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/editProduct.css">
        <script src="https://unpkg.com/@phosphor-icons/web"></script>
        <link rel="shortcut icon" href="assets/coffee.png" type="image/x-icon">
        <title>Edit - Espresso</title>
    </head>
    <body>

        <div class="main-container">
            <jsp:include page="../../components/sidebar.jsp"></jsp:include>
                <div class="add-product-container">
                    <div class="path">
                        <ul>
                            <li>
                                <a href="dashboard">Product</a>
                            </li>
                            <li>
                                <a href="add">Edit Product</a>
                            </li>
                        </ul>
                    </div>

                    <form method="post" action="edit" enctype="multipart/form-data">
                        <div class="add-product-heading">
                            <div class="heading">
                                <i class="ph-bold ph-storefront"></i>
                                <h1>Edit Product</h1>
                            </div>
                            <button type="submit" class="submit">
                                Save Changes
                            </button>
                        </div>

                        <div class="input-field">
                            <div class="input-field-child-1">
                                <div class="input-field-inner-child-1">
                                    <h2>General information</h2>

                                    <label class="label">Name Product</label>
                                    <input type="text" class="product-name input" name="productName" value="${listProductDetail.productName}"/>

                                    <label class="label">Description</label>
                                    <textarea name="brief" class="brief input">
                                        ${listProductDetail.brief}
                                    </textarea>

                                    <label class="label">Posted Date</label>
                                    <input type="date" class="posted-date input" name="postedDate" value="${listProductDetail.postedDate}"/>

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
                                <img class="imagePreview" id="imagePreview" src="${pageContext.request.contextPath}/${listProductDetail.productImage}" alt="Image Preview">
                                <div class="upload-btn-wrapper">
                                    <button class="btn">Upload a file</button>
                                    <input type="file" name="productImage" class="file input" id="file" accept="image/*" onchange="previewImage(event)">
                                </div>
                            </div>

                        </div>

                        <div class="input-field-child-2">
                            <h2>Pricing And Unit</h2>

                            <label class="label">Unit</label>
                            <input type="text" class="unit input" name="unit" value="${listProductDetail.unit}"/>

                            <label class="label">Price</label>
                            <input type="text" class="price input" name="price" value="${listProductDetail.price}"/>

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

        <script src="${pageContext.request.contextPath}/resources/script/main.js"></script>

    </body>
</html>
