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
        <link rel="stylesheet" href="css/editProduct.css">
        <script src="https://unpkg.com/@phosphor-icons/web"></script>
        <link rel="shortcut icon" href="assets/coffee.png" type="image/x-icon">
        <title>Edit - Espresso</title>
    </head>
    <body>
        <jsp:include page="components/navbar.jsp"></jsp:include>

            <div class="edit-form">
                <h1>Edit Product</h1>
                <p>Change product information</p>
                <form class="form" method="post" action="editProduct">
                    <div>
                        <label>Product Name</label>
                        <input class="productName" type="text" name="productName" placeholder="${getProductInfo.productName}"/>
                    </div>

                    <div>
                        <label>Product Image</label>
                        <input class="password" type="password" name="productImage" placeholder="${getProductInfo.productImage}"/>
                    </div>

                    <div>
                        <label>Brief</label>
                        <textarea class="brief" name="brief">${getProductInfo.brief}</textarea>
                    </div>

                    <div>
                        <label>Posted Date</label>
                        <input class="postedDate" type="date" name="postedDate"/>
                    </div>

                    <div>
                        <label>Category</label>
                        <select>
                            <option>yay</option>
                        </select>
                    </div>

                    <div>
                        <label>Unit</label>
                        <input class="unit" type="text" name="unit" placeholder="${getProductInfo.unit}" />
                    </div>

                    <div>
                        <label>Price</label>
                        <input class="price" type="number" name="price" placeholder="${getProductInfo.price}"/>
                    </div>

                    <div>
                        <label>Discount</label>
                        <input class="discount" type="number" name="discount" placeholder="${getProductInfo.discount}" />
                    </div>

                    <button class="submit-btn" type="submit">Save Changes</button>
                </form>
            </div>

        <jsp:include page="components/footer.jsp"></jsp:include>
    </body>
</html>
