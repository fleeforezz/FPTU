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
        <link rel="stylesheet" href="css/addCategory.css">
        <script src="https://unpkg.com/@phosphor-icons/web"></script>
        <link rel="shortcut icon" href="assets/coffee.png" type="image/x-icon">
        <title>Add Category - Espresso</title>
    </head>
    <body>

        <div class="main-container">
            <jsp:include page="components/sidebar.jsp"></jsp:include>
                <div class="add-product-container">
                    <div class="path">
                        <ul>
                            <li>
                                <a href="manager">Category</a>
                            </li>
                            <li>
                                <a href="addProduct">Add Category</a>
                            </li>
                        </ul>
                    </div>

                    <form method="post" action="addCategory">
                        <div class="add-product-heading">
                            <div class="heading">
                                <i class="ph-bold ph-storefront"></i>
                                <h1>Add New Category</h1>
                            </div>
                            <button type="submit" class="submit">
                                Save
                            </button>
                        </div>

                        <div class="input-field">
                            <div class="input-field-child-1">
                        </div>
                            
                        <div class="input-field-child-2">
                            <h2>Category</h2>

                            <label class="label">Category Name</label>
                            <input type="text" class="unit input" name="categoryName" required/>

                            <label class="label">Memo</label>
                            <input type="text" class="price input" name="memo" required/>
                        </div>
                    </div>
                </form>

            </div>
        </div>

        <script src="script/main.js"></script>
    </body>
</html>

