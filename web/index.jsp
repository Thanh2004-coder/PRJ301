<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login Page</title>
    <style>
        body {
            font-family: Arial, sans-serif; /* Font style */
            background-color: #f4f4f4; /* Light background color */
            margin: 0; /* Remove default margin */
            padding: 20px; /* Padding around body */
        }

        .container {
            max-width: 400px; /* Max width for the form container */
            margin: 0 auto; /* Center the container */
            padding: 20px; /* Padding inside the container */
            background-color: white; /* White background for the form */
            border-radius: 8px; /* Rounded corners */
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1); /* Box shadow */
        }

        h2 {
            text-align: center; /* Center align the heading */
            color: #333; /* Darker text color */
        }

        label {
            display: block; /* Block display for labels */
            margin-bottom: 5px; /* Space below labels */
            color: #555; /* Slightly lighter text color */
        }

        input[type="text"],
        input[type="password"] {
            width: 100%; /* Full width inputs */
            padding: 10px; /* Padding inside inputs */
            margin-bottom: 15px; /* Space below inputs */
            border: 1px solid #ccc; /* Border styling */
            border-radius: 4px; /* Rounded corners on inputs */
        }

        input[type="checkbox"] {
            margin-right: 5px; /* Space to the right of checkbox */
        }

        input[type="submit"] {
            background-color: #007BFF; /* Blue button background */
            color: white; /* White text color */
            border: none; /* No border */
            padding: 10px; /* Padding inside button */
            border-radius: 4px; /* Rounded corners */
            cursor: pointer; /* Pointer cursor on hover */
            width: 100%; /* Full width button */
        }

        input[type="submit"]:hover {
            background-color: #0056b3; /* Darker blue on hover */
        }

        p {
            text-align: center; /* Center align paragraph */
        }

        a {
            color: #007BFF; /* Link color */
            text-decoration: none; /* Remove underline from links */
        }

        a:hover {
            text-decoration: underline; /* Underline on hover */
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Login</h2>
        <form action="login" method="post">
            <label for="username">Username: </label>
            <input type="text" id="username" name="username" value="${cookie.USERNAME_COOKIE.value}">
            <br>
            <label for="password">Password: </label>
            <input type="password" id="password" name="password">
            <br>
            <label for="rememberMe">Remember me</label>
            <input type="checkbox" name="rememberMe" id="rememberMe" value="on">
            <br>
            <input type="submit" value="Login">
        </form>
        <p>You haven't an account? <a href="register">Register now</a></p>
    </div>
</body>
</html>
