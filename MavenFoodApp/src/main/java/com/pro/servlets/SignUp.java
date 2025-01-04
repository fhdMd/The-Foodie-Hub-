package com.pro.servlets;

import com.pro.dao.UserDAO;
import com.pro.daoimp.UserDAOImpl;
import com.pro.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/signup")
public class SignUp extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private UserDAO userDAO = new UserDAOImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Get user data from the signup form
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("confirmpassword");
        String phoneNumStr = req.getParameter("phonenumber");  // Updated to 'phonenumber'
        String address = req.getParameter("address");

        // Default or dynamic values for created_date and last_login
        String createdDate = "2025-01-01";
        String lastLoginDate = "2025-01-01";

        // Check if the password and confirm password match
        if (!password.equals(confirmPassword)) {
            req.setAttribute("error", "Passwords do not match!");
            req.getRequestDispatcher("signup.jsp").forward(req, resp);
            return;
        }

        // Validate and parse the phone number
        long phoneNum = 0;
        if (phoneNumStr != null && !phoneNumStr.trim().isEmpty()) {
            try {
                phoneNum = Long.parseLong(phoneNumStr);
            } catch (NumberFormatException e) {
                req.setAttribute("error", "Invalid phone number format!");
                req.getRequestDispatcher("signup.jsp").forward(req, resp);
                return;
            }
        } else {
            req.setAttribute("error", "Phone number is required!");
            req.getRequestDispatcher("signup.jsp").forward(req, resp);
            return;
        }

        // Create the user object
        User newUser = new User(name, email, password, phoneNum, address, createdDate, lastLoginDate);

        // Try inserting the user into the database
        int result = userDAO.add(newUser);

        if (result > 0) {
            // User added successfully, set the user object in the session
            HttpSession session = req.getSession();
            session.setAttribute("user", newUser);

            // Redirect to the home servlet with action=home
            resp.sendRedirect("home");
        } else {
            req.setAttribute("error", "An error occurred while signing up. Please try again.");
            req.getRequestDispatcher("signup.jsp").forward(req, resp);
        }
    }
}
