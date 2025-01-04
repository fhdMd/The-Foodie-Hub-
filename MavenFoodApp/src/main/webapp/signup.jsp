<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign Up - The Foodie's Hub</title>
<style>
    /* Global styles */
    body {
        font-family: 'Arial', sans-serif;
        margin: 0;
        padding: 0;
        background-color: #f7f2e7;
        color: #4d4d4d;
        height: 100vh;
        display: flex;
        flex-direction: column;
    }

    /* Navigation styles */
    nav {
        display: flex;
        justify-content: flex-end;
        background-color: #e63946;
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
        background-color: #ffadad;
    }

    /* Form styles */
    .form-container {
        flex: 1;
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center;
    }

    .form-container h1 {
        color: #e85d04;
        margin-bottom: 20px;
    }

    form {
        background-color: white;
        padding: 30px;
        border-radius: 10px;
        box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
        width: 100%;
        max-width: 400px;
    }

    form label {
        display: block;
        margin-bottom: 10px;
        font-weight: bold;
    }

    form input {
        width: 100%;
        padding: 10px;
        margin-bottom: 20px;
        border: 1px solid #ccc;
        border-radius: 5px;
    }

    form button {
        background-color: #e63946;
        color: white;
        padding: 10px 20px;
        border: none;
        border-radius: 5px;
        font-size: 1em;
        cursor: pointer;
        width: 100%;
    }

    form button:hover {
        background-color: #ffadad;
    }
</style>
</head>
<body>
    <nav>
        <a href="index.jsp">Home</a>
        <a href="login.jsp">Log In</a>
    </nav>

    <div class="form-container">
        <h1>Sign Up</h1>
        <form action="signup" method="post">
            <label for="name">Name</label>
            <input type="text" id="name" name="name" required>

            <label for="email">Email</label>
            <input type="email" id="email" name="email" required>

            <label for="phonenumber">Phone Number</label>
            <input type="number" id="phonenumber" name="phonenumber" required>

            <label for="address">Address</label>
            <input type="text" id="address" name="address" required>

            <label for="password">Password</label>
            <input type="password" id="password" name="password" required>

            <label for="confirmpassword">Confirm Password</label>
            <input type="password" id="confirmpassword" name="confirmpassword" required>

            <button type="submit">Sign Up</button>
        </form>
    </div>
</body>
</html>
