<%-- 
    Document   : editUser
    Created on : Oct 19, 2024, 3:53:51 PM
    Author     : jso
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/editUser.css">
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
                        <a href="editUser" class="active">General</a>
                        <a href="editPassword">Password</a>
                        <a href="export">Data Export</a>
                        <div class="separator"></div>
                        <a href="destroy_confirm">Delete Account</a>
                    </div>
                    <div class="bottom-setting-right">
                        <form method="post" action="editUser">
                        <%
                            if (request.getAttribute("updateFailed") != null) {
                                String updateFailed = (String) request.getAttribute("updateFailed");
                        %>
                        <div class="error-banner">
                            <i class="ph-bold ph-warning-circle"></i>
                            <div class="error-message">
                                <span>Update failed</span>
                                <br>
                                <%=updateFailed%>
                            </div>
                        </div>
                        <%
                            }
                        %>

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
                            <label>Username</label>
                            <input type="text" class="username" placeholder="Rename your account" name="account" value="${getAccountInfo.account}" readonly="true"/>

                            <label>Last Name</label>
                            <input type="text" class="lastName" placeholder="Change last name" name="lastName" value="${getAccountInfo.lastName}"/>

                            <label>First Name</label>
                            <input type="text" class="firstName" placeholder="Change first name" name="firstName" value="${getAccountInfo.firstName}"/>

                            <label>Birthday</label>
                            <input type="date" class="birthday" name="birthday" value="${getAccountInfo.birthday}" />

                            <label>Gender</label>
                            <div class="radio-container">
                                <div class="gender">
                                    <div>
                                        <label for="male">
                                            <input type="radio" id="male" name="gender" value="1"/>
                                            Male
                                        </label>
                                        <label for="female">
                                            <input type="radio" id="female" name="gender" value="0" />
                                            Female
                                        </label>
                                        <c:if test="${sessionScope.acc.gender == true}" >
                                            <p>Choosed gender</p>
                                            <p>Female</p>
                                        </c:if>
                                        <c:if test="${sessionScope.acc.gender == false}" >
                                            <p>Selected gender</p>
                                            <p>Female</p>
                                        </c:if>

                                    </div>
                                </div>
                            </div>

                            <label>Phone Number</label>
                            <input type="number" class="phoneNumber" placeholder="Change phone number" name="phone" value="${getAccountInfo.phone}"/>

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
