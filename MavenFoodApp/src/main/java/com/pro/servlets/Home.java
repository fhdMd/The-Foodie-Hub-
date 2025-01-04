package com.pro.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pro.dao.RestaurantDAO;
import com.pro.daoimp.RestaurantDAOImpl;
import com.pro.model.Restaurant;
import com.pro.model.User;

@WebServlet("/home")
public class Home extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Check if user is logged in
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");

        // Fetch restaurant data
        RestaurantDAO restaurantDAO = new RestaurantDAOImpl();
        List<Restaurant> restaurants = restaurantDAO.getAll(); // Get all restaurants

        // Add data to request scope
        req.setAttribute("restaurants", restaurants);
        req.setAttribute("user", user); // Pass user data to JSP
        
        // Forward to home.jsp
        req.getRequestDispatcher("home.jsp").forward(req, resp);
    }
}
