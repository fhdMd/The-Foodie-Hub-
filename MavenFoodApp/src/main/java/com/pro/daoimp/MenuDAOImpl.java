package com.pro.daoimp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pro.dao.MenuDAO;
import com.pro.model.Menu;
import com.pro.util.Util;

public class MenuDAOImpl implements MenuDAO {
    // Database connection
    Connection con = Util.getCon();

    @Override
    public int add(Menu m) {
        try {
            PreparedStatement pstmt = con.prepareStatement(
                "INSERT INTO `menu` (`restaurantId`, `name`, `price`, `description`, `imagepath`, `isAvailable`) VALUES (?, ?, ?, ?, ?, ?)"
            );
            pstmt.setInt(1, m.getRestarauntId());
            pstmt.setString(2, m.getName());
            pstmt.setInt(3, m.getPrice());
            pstmt.setString(4, m.getDescription());
            pstmt.setString(5, m.getImgPath());
            pstmt.setBoolean(6, m.isAvailable());
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Menu get(int id) {
        try {
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM `menu` WHERE `id` = ?");
            pstmt.setInt(1, id);
            ResultSet res = pstmt.executeQuery();
            if (res.next()) {
                return new Menu(
                    res.getInt("id"),
                    res.getInt("restaurantId"),
                    res.getString("name"),
                    res.getInt("price"),
                    res.getString("description"),
                    res.getString("imagepath"),
                    res.getBoolean("isAvailable")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Menu> getAll(int restaurantId) {
    	ResultSet res=null;
    	try {
            // Query to get all menu items for a specific restaurant
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM `menu` WHERE `restaurantId` = ?");
            pstmt.setInt(1, restaurantId);  // Set the restaurantId parameter
            res = pstmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return extractAL(res);
    }
    @Override
    public List<Menu> extractAL(ResultSet res) {
        List<Menu> menuList = new ArrayList<>();
        try {
            while (res.next()) {
                Menu menu = new Menu(
                    res.getInt("id"),
                    res.getInt("restaurantId"),
                    res.getString("name"),
                    res.getInt("price"),
                    res.getString("description"),
                    res.getString("imagepath"),
                    res.getBoolean("isAvailable")
                );
                menuList.add(menu);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
 
        return menuList;
    }

    @Override
    public int update(Menu m, int id) {
        try {
            PreparedStatement pstmt = con.prepareStatement(
                "UPDATE `menu` SET `restaurantId` = ?, `name` = ?, `price` = ?, `description` = ?, `imagepath` = ?, `isAvailable` = ? WHERE `id` = ?"
            );
            pstmt.setInt(1, m.getRestarauntId());
            pstmt.setString(2, m.getName());
            pstmt.setInt(3, m.getPrice());
            pstmt.setString(4, m.getDescription());
            pstmt.setString(5, m.getImgPath());
            pstmt.setBoolean(6, m.isAvailable());
            pstmt.setInt(7, id);
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int delete(int id) {
        try {
            PreparedStatement pstmt = con.prepareStatement("DELETE FROM `menu` WHERE `id` = ?");
            pstmt.setInt(1, id);
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
