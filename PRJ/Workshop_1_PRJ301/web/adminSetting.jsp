<%-- 
    Document   : adminSetting
    Created on : Oct 20, 2024, 9:45:12 PM
    Author     : jso
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/adminSetting.css">
        <script src="https://unpkg.com/@phosphor-icons/web"></script>
        <link rel="shortcut icon" href="assets/coffee.png" type="image/x-icon">
        <title>Admin - Espresso</title>
    </head>
    <body>
        <jsp:include page="components/navbar.jsp"></jsp:include>

            <div class="account-table">
                <div class="account-table-container">
                    <h1>Account List</h1>
                    <table>
                        <tr style="height: 50px; background: #dfdfc5; position: sticky; top: 0px;">
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
            </div>

            <div class="account-table-container">
                <h1>Category List</h1>
                <table>
                    <tr style="height: 50px; background: #dfdfc5; position: sticky; top: 0px;">
                        <th>TypeID</th>
                        <th>Category Name</th>
                        <th>Memo</th>
                        <th>Action</th>
                    </tr>
                    <c:forEach items="${listCategory}" var="i">
                        <tr>
                            <td style="width: 15%;">
                                ${i.typeId}
                            </td>
                            <td style="width: 15%;">
                                ${i.categoryName}
                            </td>
                            <td style="width: 15%;">
                                ${i.memo}
                            </td>
                            <td style="width: 10%;">
                                <div class="action-btn">
                                    <a href="editCategory?TypeId=${i.typeId}" class="edit-button">
                                        <i class="ph ph-pencil-line"></i>
                                    </a>
                                    <a href="deleteCategory?TypeId=${i.typeId}" class="unActive-button">
                                        <i class="ph-duotone ph-backspace"></i>
                                    </a>                                    
                                </div>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>

            <div class="add-category">
                <h1>Add Category</h1>
                <div class="add-category-container">
                    <form method="post" action="admin">
                        <label>Category Name</label>
                        <input type="text" class="categoryName" placeholder="Enter Category Name" name="categoryName" required />
                        <input type="submit" class="submit-button" name="submit" value="Add" />
                    </form>
                </div>
            </div>
        </div>

        <jsp:include page="components/footer.jsp"></jsp:include>
    </body>
</html>
