package com.pro.daoimp;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.pro.dao.UserDAO;
import com.pro.model.User;
import com.pro.util.Util;

public class UserDAOImpl implements UserDAO {
    Connection con = Util.getCon();
    
    @Override
    public User search(String email) {
        User user = null;  // Initialize user to null
        try {
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM `user` WHERE `email`=?");
            pstmt.setString(1, email);
            ResultSet res = pstmt.executeQuery();
            
            // Extract user object if result exists
            List<User> list = extracAL(res);
            if (!list.isEmpty()) {
                user = list.get(0);  // If there's at least one result, assign the first (and only) user
            }
        } catch (SQLException e) {
            System.out.println("Error executing search query for `user` table in `UserDAOImpl` class for email: " + email);
            e.printStackTrace();
        }
        return user;  // Will return null if no user was found, or the User object if found
    }

    @Override
    public int add(User u) {
        try {
            PreparedStatement pstmt = con.prepareStatement(
                "INSERT INTO `user` (`name`, `email`, `password`, `phonenumber`, `address`, `created_date`, `last_login`) VALUES (?, ?, ?, ?, ?, ?, ?)"
            );
            pstmt.setString(1, u.getName());
            pstmt.setString(2, u.getEmail());
            pstmt.setString(3, u.getPassword());
            pstmt.setLong(4, u.getPhonenum());  // Changed from phonenum to phonenumber
            pstmt.setString(5, u.getAddress());
            pstmt.setString(6, u.getCreatedDate());
            pstmt.setString(7, u.getLastLoginDate());
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error adding user to `user` table in `UserDAOImpl` class with email: " + u.getEmail());
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public User get(int id) {
        try {
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM `user` WHERE `id` = ?");
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new User(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("password"),
                    rs.getLong("phonenumber"),  // Changed from phonenum to phonenumber
                    rs.getString("address"),
                    rs.getString("created_date"),
                    rs.getString("last_login")
                );
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving user from `user` table in `UserDAOImpl` class with ID: " + id);
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void getAll() {
        try {
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM `user`");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println(
                    new User(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getLong("phonenumber"),  // Changed from phonenum to phonenumber
                        rs.getString("address"),
                        rs.getString("created_date"),
                        rs.getString("last_login")
                    )
                );
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving all records from `user` table in `UserDAOImpl` class.");
            e.printStackTrace();
        }
    }

    @Override
    public List<User> extracAL(ResultSet res) {
        List<User> list = new ArrayList<>();
        try {
            while (res.next()) {
                list.add(new User(
                    res.getInt("id"),
                    res.getString("name"),
                    res.getString("email"),
                    res.getString("password"),
                    res.getLong("phonenumber"),  // Changed from phonenum to phonenumber
                    res.getString("address"),
                    res.getString("created_date"),
                    res.getString("last_login")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Error extracting user data from ResultSet in `UserDAOImpl` class.");
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int update(User u, int id) {
        try {
            PreparedStatement pstmt = con.prepareStatement(
                "UPDATE `user` SET `name` = ?, `email` = ?, `password` = ?, `phonenumber` = ?, `address` = ?, `created_date` = ?, `last_login` = ? WHERE `id` = ?"
            );
            pstmt.setString(1, u.getName());
            pstmt.setString(2, u.getEmail());
            pstmt.setString(3, u.getPassword());
            pstmt.setLong(4, u.getPhonenum());  // Changed from phonenum to phonenumber
            pstmt.setString(5, u.getAddress());
            pstmt.setString(6, u.getCreatedDate());
            pstmt.setString(7, u.getLastLoginDate());
            pstmt.setInt(8, id);
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error updating user record in `user` table in `UserDAOImpl` class with ID: " + id);
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int delete(int id) {
        try {
            PreparedStatement pstmt = con.prepareStatement("DELETE FROM `user` WHERE `id` = ?");
            pstmt.setInt(1, id);
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error deleting user from `user` table in `UserDAOImpl` class with ID: " + id);
            e.printStackTrace();
        }
        return 0;
    }
}
