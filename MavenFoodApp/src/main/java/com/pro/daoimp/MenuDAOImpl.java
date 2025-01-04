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
    Connection con = Util.getCon();

    @Override
    public int add(Menu m) {
        try {
            PreparedStatement pstmt = con.prepareStatement(
                "INSERT INTO `menu` (`name`, `price`, `description`, `imagepath`, `isAvailable`) VALUES (?, ?, ?, ?, ?)"
            );
            pstmt.setString(1, m.getName());
            pstmt.setInt(2, m.getPrice());
            pstmt.setString(3, m.getDescription());
            pstmt.setString(4, m.getImgPath());
            pstmt.setBoolean(5, m.isAvailable());
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
    public void getAll() {
        try {
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM `menu`");
            ResultSet res = pstmt.executeQuery();
            List<Menu> menuList = extracAL(res);
            for (Menu menu : menuList) {
                System.out.println(menu);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Menu> extracAL(ResultSet res) {
        List<Menu> menuList = new ArrayList<>();
        try {
            while (res.next()) {
                Menu menu = new Menu(
                    res.getInt("id"),
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
                "UPDATE `menu` SET `name` = ?, `price` = ?, `description` = ?, `imagepath` = ?, `isAvailable` = ? WHERE `id` = ?"
            );
            pstmt.setString(1, m.getName());
            pstmt.setInt(2, m.getPrice());
            pstmt.setString(3, m.getDescription());
            pstmt.setString(4, m.getImgPath());
            pstmt.setBoolean(5, m.isAvailable());
            pstmt.setInt(6, id);
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
