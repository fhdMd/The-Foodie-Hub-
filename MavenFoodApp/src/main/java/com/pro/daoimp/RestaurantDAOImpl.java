package com.pro.daoimp;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.pro.dao.RestaurantDAO;
import com.pro.model.Restaurant;
import com.pro.util.Util;

public class RestaurantDAOImpl implements RestaurantDAO {
    Connection con = Util.getCon();

    @Override
    public int add(Restaurant r) {
        try {
            PreparedStatement pstmt = con.prepareStatement(
                "INSERT INTO `restaurant` (`name`, `delivery_time`, `cuisine_type`, `address`, `rating`, `isActive`, `admin_Id`, `imgPath`) VALUES (?, ?, ?, ?, ?, ?, ?, ?)"
            );
            pstmt.setString(1, r.getName());
            pstmt.setInt(2, r.getDeliveryTime());
            pstmt.setString(3, r.getCuisineType());
            pstmt.setString(4, r.getAddress());
            pstmt.setFloat(5, r.getRating());
            pstmt.setBoolean(6, r.isActive());
            pstmt.setInt(7, r.getAdminId());
            pstmt.setString(8, r.getImgPath());
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Restaurant get(int id) {
        try {
            PreparedStatement pstmt = con.prepareStatement(
                "SELECT * FROM `restaurant` WHERE `id` = ?"
            );
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Restaurant(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getInt("delivery_time"),
                    rs.getString("cuisine_type"),
                    rs.getString("address"),
                    rs.getFloat("rating"),
                    rs.getBoolean("isActive"),
                    rs.getInt("admin_Id"),
                    rs.getString("imgPath")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Restaurant> getAll() {
        List<Restaurant> restaurantList = new ArrayList<>();
        try {
            // Create the SQL query to fetch all restaurants
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM `restaurant`");
            ResultSet rs = pstmt.executeQuery();
            
            // Iterate through the result set and add each restaurant to the list
            while (rs.next()) {
                Restaurant restaurant = new Restaurant(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getInt("delivery_time"),
                    rs.getString("cuisine_type"),
                    rs.getString("address"),
                    rs.getFloat("rating"),
                    rs.getBoolean("isActive"),
                    rs.getString("imgPath")
                );
                restaurantList.add(restaurant);  // Add the restaurant to the list
            }
        } catch (SQLException e) {
            e.printStackTrace();  // Log the error if there's an issue with the query
        }
        return restaurantList;  // Return the list of restaurants
    }


    @Override
    public List<Restaurant> extracAL(ResultSet res) {
        List<Restaurant> list = new ArrayList<>();
        try {
            while (res.next()) {
                list.add(new Restaurant(
                    res.getInt("id"),
                    res.getString("name"),
                    res.getInt("delivery_time"),
                    res.getString("cuisine_type"),
                    res.getString("address"),
                    res.getFloat("rating"),
                    res.getBoolean("isActive"),
                    res.getInt("admin_Id"),
                    res.getString("imgPath")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int update(Restaurant r, int id) {
        try {
            PreparedStatement pstmt = con.prepareStatement(
                "UPDATE `restaurant` SET `name` = ?, `delivery_time` = ?, `cuisine_type` = ?, `address` = ?, `rating` = ?, `isActive` = ?, `admin_Id` = ?, `imgPath` = ? WHERE `id` = ?"
            );
            pstmt.setString(1, r.getName());
            pstmt.setInt(2, r.getDeliveryTime());
            pstmt.setString(3, r.getCuisineType());
            pstmt.setString(4, r.getAddress());
            pstmt.setFloat(5, r.getRating());
            pstmt.setBoolean(6, r.isActive());
            pstmt.setInt(7, r.getAdminId());
            pstmt.setString(8, r.getImgPath());
            pstmt.setInt(9, id);
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int delete(int id) {
        try {
            PreparedStatement pstmt = con.prepareStatement(
                "DELETE FROM `restaurant` WHERE `id` = ?"
            );
            pstmt.setInt(1, id);
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
