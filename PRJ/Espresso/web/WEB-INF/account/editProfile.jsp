<%-- 
    Document   : editProfile
    Created on : Nov 20, 2024, 3:50:46 PM
    Author     : jso
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/editProfile.css">
        <script src="https://unpkg.com/@phosphor-icons/web"></script>
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/assets/coffee.png" type="image/x-icon">
        <title>Edit - Espresso</title>
    </head>
    <body>
        <jsp:include page="../../components/navbar.jsp"></jsp:include>
            <div class="banner">
                <img class="coffee-banner" src="${pageContext.request.contextPath}/resources/assets/coffee-jar.jpg" />
            <ul>
                <li>
                    <a href="${pageContext.request.contextPath}/home">Home</a>
                </li>
                <li>
                    Account
                </li>
            </ul>
        </div>
        <div class="main-container">
            <div class="bottom-setting">
                <div class="bottom-setting-left">
                    <a href="general">General</a>
                    <a href="profile" class="active">Edit Profile</a>
                    <a href="password">Password</a>
                    <a href="export">Data Export</a>
                    <div class="separator"></div>
                    <a href="delete">Delete Account</a>
                </div>
                <div class="bottom-setting-right">
                    <form method="post" action="profile" enctype="multipart/form-data">
                        <div class="bottom-setting-right-child-top">
                            <c:if test="${sessionScope.acc.accountImage == null}">
                                <img class="imagePreview" src="${pageContext.request.contextPath}/resources/assets/account.png"/>
                            </c:if>
                            <c:if test="${sessionScope.acc.accountImage != null}">
                                <img class="imagePreview" id="imagePreview" src="${pageContext.request.contextPath}/${sessionScope.acc.accountImage}" alt="Image Preview">
                            </c:if>
                            <div class="upload-btn-wrapper">
                                <button class="btn">Upload image</button>
                                <input type="file" name="accountImage" class="file input" id="file" accept="image/*" required>
                            </div>
                        </div>
                        <div class="button-setting-right-child-bottom">
                            <input type="submit" class="submit-button" name="submit" value="Save Changes" />
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <script src="${pageContext.request.contextPath}/resources/script/main.js"></script>
        <jsp:include page="../../components/footer.jsp"></jsp:include>
    </body>
</html>
