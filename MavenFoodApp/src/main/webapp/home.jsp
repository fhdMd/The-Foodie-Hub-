<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.pro.model.User" %>
<%@ page import="com.pro.model.Restaurant" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home</title>
    <style>
        /* Global styles */
        body {
            font-family: 'Arial', sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f7f2e7; /* Light beige background */
            color: #4d4d4d; /* Dark gray text */
        }

        /* Navbar styles */
        nav {
            display: flex;
            justify-content: space-between;
            align-items: center;
            background-color: #e63946; /* Rich red */
            padding: 10px 20px;
            color: white;
        }

        .navbar .left span {
            font-weight: bold;
            margin-right: 15px;
        }

        /* Right side options */
        nav .right {
            display: flex;
            gap: 15px; /* Space between buttons */
        }

        nav .right a {
            color: white;
            text-decoration: none;
            font-weight: bold;
            padding: 10px 20px;
            border-radius: 20px;
            background-color: #ff6f61; /* Slightly lighter red */
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.2);
            transition: transform 0.3s, box-shadow 0.3s, background-color 0.3s;
        }

        nav .right a:hover {
            background-color: #ffadad; /* Light pink hover */
            transform: translateY(-2px); /* Lift on hover */
            box-shadow: 0 6px 10px rgba(0, 0, 0, 0.3); /* Enhanced shadow */
        }

        /* Restaurant list styles */
        .restaurant-list {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));
            gap: 20px;
            padding: 20px;
        }

        .restaurant-card {
            background-color: white;
            border: 1px solid #ccc;
            border-radius: 10px;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1); /* Subtle shadow */
            padding: 15px;
            text-align: center;
            transition: transform 0.3s, box-shadow 0.3s;
            text-decoration: none; /* Remove default link styles */
            color: inherit; /* Inherit text color */
        }

        .restaurant-card:hover {
            transform: translateY(-5px); /* Slight lift effect */
            box-shadow: 0 8px 15px rgba(0, 0, 0, 0.2); /* Enhanced shadow on hover */
        }

        .restaurant-card img {
            width: 100%;
            height: auto;
            border-radius: 10px;
            margin-bottom: 10px;
        }

        .restaurant-card h3 {
            color: #e63946; /* Match navbar color */
            margin-bottom: 10px;
        }

        .restaurant-card p {
            color: #4d4d4d;
            font-size: 0.9em;
            margin: 5px 0;
        }

        /* Responsive design */
        @media (max-width: 768px) {
            nav {
                flex-direction: column;
                text-align: center;
            }

            .navbar .right {
                margin-top: 10px;
                flex-wrap: wrap;
                gap: 10px;
            }
        }
    </style>
</head>
<body>

<!-- Navbar -->
<nav>
    <div class="left">
        <% if (session.getAttribute("user") != null) { 
            User user = (User) session.getAttribute("user"); %>
            <span>Welcome, <%= user.getName() %></span>
        <% } %>
    </div>
    <div class="right">
        <% if (session.getAttribute("user") == null) { %>
            <a href="login.jsp">Login</a>
            <a href="signup.jsp">Sign Up</a>
        <% } else { %>
            <a href="orders.jsp">Orders</a>
            <a href="orderHistory.jsp">Order History</a>
            <a href="profile.jsp">Profile</a>
            <a href="logout">Logout</a>
        <% } %>
    </div>
</nav>

<!-- Restaurant List -->
<div class="restaurant-list">
    <% 
    List<Restaurant> restaurants = (List<Restaurant>) request.getAttribute("restaurants");
    if (restaurants != null) {
        for (Restaurant restaurant : restaurants) { 
    %>
        <form action="restaurant.jsp" method="POST">
            <input type="hidden" name="restaurantId" value="<%= restaurant.getId() %>">
            <div class="restaurant-card">
                <img src="<%= restaurant.getImgPath() %>" alt="Restaurant Image">
                <h3><%= restaurant.getName() %></h3>
                <p>Type: <%= restaurant.getCuisineType() %></p>
                <p>Rating: <%= restaurant.getRating() %></p>
                <p>Delivery Time: <%= restaurant.getDeliveryTime() %> minutes</p>
                <p>Address: <%= restaurant.getAddress() %></p>
                <!-- You can also add a submit button to make it a clickable POST -->
                <button type="submit" style="background-color: transparent; border: none; color: inherit; text-decoration: underline; cursor: pointer;">View Details</button>
            </div>
        </form>
    <% 
        }
    } 
    %>
</div>


</body>
</html>
