<%-- 
    Document   : editPassword
    Created on : Oct 19, 2024, 10:44:29 PM
    Author     : jso
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/editPassword.css">
        <script src="https://unpkg.com/@phosphor-icons/web"></script>
        <link rel="shortcut icon" href="assets/coffee.png" type="image/x-icon">
        <title>Edit - Espresso</title>
    </head>
    <body>
        <jsp:include page="components/navbar.jsp"></jsp:include>
            <div class="banner">
                <img class="coffee-banner" src="assets/coffee-jar.jpg" />
                <ul>
                    <li>
                        <a href="home">Home</a>
                    </li>
                    <li>
                        Account
                    </li>
                </ul>
            </div>
            <div class="main-container">
                <div class="bottom-setting">
                    <div class="bottom-setting-left">
                        <a href="editUser">General</a>
                        <a href="editPassword" class="active">Password</a>
                        <a href="export">Data Export</a>
                        <div class="separator"></div>
                        <a href="destroy_confirm">Delete Account</a>
                    </div>
                    <div class="bottom-setting-right">
                        <form method="post" action="editPassword">
                            <!--New password same with old password error-->
                        <%
                            if (request.getAttribute("newPassSameOldPass") != null) {
                                String newPassSameOldPass = (String) request.getAttribute("newPassSameOldPass");
                        %>
                        <div class="error-banner">
                            <i class="ph-bold ph-warning-circle"></i>
                            <div class="error-message">
                                <span>Login failed</span>
                                <br>
                                <%=newPassSameOldPass%>
                            </div>
                        </div>
                        <%
                            }
                        %>
                        <!--The old password doesn't match with the old one-->
                        <%
                            if (request.getAttribute("sameOldPassError") != null) {
                                String sameOldPassError = (String) request.getAttribute("sameOldPassError");
                        %>
                        <div class="error-banner">
                            <i class="ph-bold ph-warning-circle"></i>
                            <div class="error-message">
                                <span>Login failed</span>
                                <br>
                                <%=sameOldPassError%>
                            </div>
                        </div>
                        <%
                            }
                        %>
                        <!--Update success-->
                        <%
                            if (request.getAttribute("updateSuccess") != null) {
                                String updateSuccess = (String) request.getAttribute("updateSuccess");
                        %>
                        <div class="success-banner">
                            <i class="ph-bold ph-warning-circle"></i>
                            <div class="success-message">
                                <span>Updated !</span>
                                <br>
                                <%=updateSuccess%>
                            </div>
                        </div>
                        <%
                            }
                        %>
                        <div class="bottom-setting-right-child-top">
                            <label>Old Password</label>
                            <input type="password" class="old-password" placeholder="Enter your old password" name="old-password"/>
                            <label>New Password</label>
                            <input type="password" class="new-password" placeholder="Enter your new password" name="new-password"/>
                            <p>You have to re-login to see the changed</p>
                        </div>
                        <div class="button-setting-right-child-bottom">
                            <input type="submit" class="submit-button" name="submit" value="Save Changes" />
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <script src="script/main.js"></script>
        <jsp:include page="components/footer.jsp"></jsp:include>
    </body>
</html>
