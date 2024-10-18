<%-- 
    Document   : signup
    Created on : Oct 18, 2024, 11:18:42 AM
    Author     : jso
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/signup.css">
        <script src="https://unpkg.com/@phosphor-icons/web"></script>
        <link rel="shortcut icon" href="assets/coffee.png" type="image/x-icon">
        <title>Signup - Espresso</title>
    </head>
    <body>
        <jsp:include page="components/navbar.jsp"></jsp:include>
            <div class="login-form">
                <h1>Sign Up</h1>
                <p>Fill your information to create a new account</p>
                <form method="post" action="login">
                    <label>Username</label>
                    <input class="username" type="text" name="account" placeholder="Enter username" required="required"/>

                    <label>Password</label>
                    <input class="password" type="password" name="pass" placeholder="Enter password" required="required"/>

                    <div class="realName">
                        <div>
                            <label>Last Name</label>
                            <input class="lastName" type="text" name="lastName" placeholder="Enter last name" />
                        </div>

                        <div>
                            <label>First Name</label>
                            <input class="firstName" type="text" name="firstName" placeholder="Enter first name" />
                        </div>
                    </div>

                    <label>Birthday</label>
                    <input class="birthday" type="date" name="birthday"/>

                    <label>Select your gender and set account activation</label>
                    <div class="radio-container">
                        <div class="gender">
                            <div>
                                <input type="radio" id="male" />
                                <label for="male">male</label>
                            </div>
                            <div>
                                <input type="radio" id="female" />
                                <label for="female">female</label>
                            </div>
                        </div>
                        <div class="isUse">
                            <input type="radio" id="isUse"/>
                            <label for="isUse">Activate account ?</label>
                        </div>
                    </div>

                    <label>Phone Number</label>
                    <input class="phoneNumber" type="number"  name="phone" placeholder="xxxxxxxxx"/>

                    <p>
                        Already have an account ?<a href="login">Login</a>
                    </p>
                    <button class="submit-btn" type="submit">Sign Up</button>
                </form>
            </div>

        <jsp:include page="components/footer.jsp"></jsp:include>
    </body>
</html>
