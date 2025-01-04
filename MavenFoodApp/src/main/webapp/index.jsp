<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>The Foodie's Hub</title>
<style>
    /* Global styles */
    body {
        font-family: 'Arial', sans-serif;
        margin: 0;
        padding: 0;
        background-color: #f7f2e7; /* Light cream background */
        color: #4d4d4d; /* Neutral text color */
        height: 100vh; /* Full viewport height */
        display: flex;
        flex-direction: column;
    }

    /* Header styles */
    h1 {
        font-size: 2.5em;
        color: #e85d04; /* Warm orange color */
        margin-bottom: 20px;
    }

    /* Navigation styles */
    nav {
        display: flex;
        justify-content: flex-end;
        background-color: #e63946; /* Bright red for nav background */
        padding: 10px 20px;
    }

    nav a {
        color: white;
        text-decoration: none;
        margin-left: 20px;
        font-weight: bold;
        padding: 10px 15px;
        border-radius: 5px;
        transition: background-color 0.3s;
    }

    nav a:hover {
        background-color: #ffadad; /* Lighter red for hover effect */
    }

    /* Main content styles */
    .main-content {
        flex: 1; /* Takes available space */
        display: flex;
        flex-direction: column;
        align-items: center; /* Horizontal alignment */
        justify-content: center; /* Vertical alignment */
        text-align: center;
    }

    .main-content a {
        display: inline-block;
        background-color: #e63946; /* Same as nav background */
        color: white;
        text-decoration: none;
        padding: 15px 25px;
        font-size: 1.2em;
        border-radius: 5px;
        margin-top: 20px;
        transition: background-color 0.3s;
    }

    .main-content a:hover {
        background-color: #ffadad; /* Lighter red for hover effect */
    }
</style>
</head>
<body>
    <!-- Navigation bar -->
    <nav>
        <a href="login.jsp">Log In</a>
        <a href="signup.jsp">Sign Up</a>
    </nav>

    <!-- Main content -->
    <div class="main-content">
        <h1>Welcome To Foodie's Hub</h1>
        <a href="home">Start Ordering</a>
    </div>
</body>
</html>
