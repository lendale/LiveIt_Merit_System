<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>LiveIt - Log In</title>
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700|Raleway:300,600" rel="stylesheet">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel='stylesheet prefetch' href="lib/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/style.css">
</head>

<body>

<div class="container">
    <section id="formHolder">
        <div class="row">

            <!-- Brand Box -->
            <div class="col-sm-6 brand">
                <a href="#" class="logo">LM <span>.</span></a>

                <div class="heading">
                    <h2>LiveIt Merit</h2>

                    <p>Your Right Choice</p>
                </div>

                <div class="success-msg">
                    <p>Great! You are one of our members now</p>
                    <a href="#" class="profile">Your Profile</a>
                </div>
            </div>

            <!-- Form Box -->
            <div class="col-sm-6 form">

                <!-- Login Form -->
                <div class="login form-peice">
                    <form class="login-form" action="#" method="post">
                        <div class="form-group">
                            <label for="userId">User ID</label>
                            <input type="email" name="userid" id="userid" required>
                        </div>

                        <div class="form-group">
                            <label for="loginPassword">Password</label>
                            <input type="password" name="loginPassword" id="loginPassword" required>
                        </div>

                        <div class="CTA">
                            <input type="submit" value="Login">
                        </div>
                    </form>
                </div><!-- End Login Form -->

            </div>
        </div>

    </section>

    <footer>
        <p>
            ©2017 LiveIt Merit
        </p>
    </footer>

</div>
<script src="lib/js/bootstrap/bootstrap.min.js"></script>
<script src="lib/js/jquery/jquery-3.1.1.min.js"></script>
<script src="js/login/index.js"></script>

</body>
</html>
