package com.pro.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pro.dao.UserDAO;
import com.pro.daoimp.UserDAOImpl;
import com.pro.model.User;

@WebServlet("/login")
public class Login extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        // Create an instance of UserDAO to interact with the database
        UserDAO userDAO = new UserDAOImpl();

        // Search for the user by email
        User user = userDAO.search(email);

        // If user exists and password matches
        if (user != null && user.getPassword().equals(password)) {
            // Set user object in session
            HttpSession session = req.getSession();
            session.setAttribute("user", user);

            // Redirect to the home servlet with action=home
            resp.sendRedirect("home");
        } else {
            // Redirect to login page or show error message
            req.setAttribute("error", "Invalid email or password.");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }
}
