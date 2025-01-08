<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.pro.model.*" %>
<%@page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>The Foodie's Hub - Menu</title>
<style>
    /* Global styles */
    body {
        font-family: 'Arial', sans-serif;
        margin: 0;
        padding: 0;
        background-color: #f7f2e7; /* Light cream background */
        color: #4d4d4d; /* Neutral text color */
    }

    /* Header styles */
    h1 {
        font-size: 2.5em;
        color: #e85d04; /* Warm orange color */
        text-align: center;
        margin-top: 20px;
        margin-bottom: 20px;
    }

    /* Navigation styles */
    nav {
        display: flex;
        justify-content: space-between;
        background-color: #e63946; /* Bright red for nav background */
        padding: 10px 20px;
        align-items: center;
    }

    .nav-left {
        font-size: 1.5em;
        font-weight: bold;
        color: white;
    }

    .nav-right a, .nav-left-back {
        color: white;
        text-decoration: none;
        margin-left: 20px;
        font-weight: bold;
        padding: 10px 15px;
        border-radius: 5px;
        transition: background-color 0.3s;
    }

    .nav-right a:hover, .nav-left-back:hover {
        background-color: #ffadad; /* Lighter red for hover effect */
    }

    /* Back button styles */
    .nav-left-back {
        background-color: #007bff; /* Blue color for back button */
    }

    /* Menu list container */
    .menu-container {
        max-width: 1200px;
        margin: 0 auto;
        padding: 20px;
        display: flex;
        flex-wrap: wrap; /* Items wrap to the next line */
        gap: 20px; /* Spacing between menu items */
        justify-content: center;
    }

    /* Menu card styles */
    .menu-card {
        background-color: white;
        border: 1px solid #ddd; /* Light border for separation */
        border-radius: 10px;
        box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1); /* Subtle shadow */
        width: 300px;
        overflow: hidden; /* Prevents content overflow */
        transition: transform 0.3s, box-shadow 0.3s;
    }

    .menu-card:hover {
        transform: scale(1.05); /* Slight zoom effect */
        box-shadow: 0 6px 10px rgba(0, 0, 0, 0.15);
    }

    .menu-card img {
        width: 100%;
        height: 200px;
        object-fit: cover;
    }

    .menu-card .menu-details {
        padding: 15px;
        text-align: center;
    }

    .menu-card .menu-name {
        font-size: 1.2em;
        font-weight: bold;
        margin-bottom: 10px;
        color: #e63946; /* Accent color */
    }

    .menu-card .menu-description {
        font-size: 0.9em;
        color: #666; /* Subtle text color */
        margin-bottom: 10px;
    }

    .menu-card .menu-price {
        font-size: 1.1em;
        font-weight: bold;
        margin-bottom: 15px;
        color: #4d4d4d;
    }

    .menu-card .menu-action {
        display: inline-block;
        background-color: #e63946; /* Action button color */
        color: white;
        text-decoration: none;
        padding: 10px 20px;
        font-size: 0.9em;
        border-radius: 5px;
        transition: background-color 0.3s;
    }

    .menu-card .menu-action:hover {
        background-color: #ffadad; /* Lighter red for hover effect */
    }
    
</style>
</head>
<body>
    <!-- Navigation bar -->
    <nav>
        <div>
            <!-- Back button -->
            <a href="<%= request.getContextPath() %>/home" class="nav-left-back">Back to Home</a>
        </div>
        <div class="nav-left">The Foodie's Hub</div>
        <div class="nav-right">
            <% 
                // Check if user is logged in
                Object user = session.getAttribute("user");
                if (user == null) { 
            %>
                <a href="login.jsp">Log In</a>
                <a href="signup.jsp">Sign Up</a>
            <% 
                } else { 
            %>
                <a href="profile.jsp">Profile</a>
                <a href="orders.jsp">My Orders</a>
                <a href="logout.jsp">Log Out</a>
            <% 
                } 
            %>
        </div>
    </nav>

    <!-- Header -->
    <h1>Explore Our Menu</h1>

    <!-- Menu list -->
    <div class="menu-container">
        <% 
            List<Menu> menuList = (List<Menu>) session.getAttribute("menuList");
            for (Menu menu : menuList) { 
        %>
            <div class="menu-card">
                
                <div class="menu-details">
                    <div class="menu-name"><%= menu.getName() %></div>
                    <div class="menu-description"><%= menu.getDescription() %></div>
                    <div class="menu-price">Rs. <%= menu.getPrice() %></div>
                    <a href="order?item=<%= menu.getId() %>" class="menu-action">Order Now</a>
                </div>
            </div>
        <% 
            } 
        %>
    </div>
</body>
</html>
