<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login - The Foodie's Hub</title>
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

    form input[type="email"],
    form input[type="password"] {
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
        <a href="signup.jsp">Sign Up</a>
    </nav>

    <div class="form-container">
        <h1>Log In</h1>
        <form action="login" method="post">
            <label for="email">Email</label>
            <input type="email" id="email" name="email" required>

            <label for="password">Password</label>
            <input type="password" id="password" name="password" required>

            <button type="submit">Log In</button>
        </form>
    </div>
</body>
</html>
