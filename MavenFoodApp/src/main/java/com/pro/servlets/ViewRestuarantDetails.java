package com.pro.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pro.daoimp.MenuDAOImpl;
import com.pro.daoimp.RestaurantDAOImpl;
import com.pro.model.Menu;
import com.pro.model.Restaurant;

@WebServlet("/ViewRestuarantDetails")
public class ViewRestuarantDetails extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession sesh=arg0.getSession();
		Restaurant res=new RestaurantDAOImpl().get(Integer.parseInt(arg0.getParameter("restaurantId")));
		List<Menu> menuList=new MenuDAOImpl().getAll(Integer.parseInt(arg0.getParameter("restaurantId")));
		sesh.setAttribute("restaurant", res);
		sesh.setAttribute("menuList", menuList);
		arg1.sendRedirect("restaurant.jsp");
	}
}
