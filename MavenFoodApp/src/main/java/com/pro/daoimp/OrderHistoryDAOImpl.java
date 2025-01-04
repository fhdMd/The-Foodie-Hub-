package com.pro.daoimp;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.pro.dao.OrderHistoryDAO;
import com.pro.model.OrderHistory;
import com.pro.util.Util;

public class OrderHistoryDAOImpl implements OrderHistoryDAO {
    Connection con = Util.getCon();

    @Override
    public int add(OrderHistory oh) {
        try {
            PreparedStatement pstmt = con.prepareStatement(
                "INSERT INTO `order_history` (`orderId`, `userId`, `orderDate`, `totalAmount`, `status`) VALUES (?, ?, ?, ?, ?)"
            );
            pstmt.setInt(1, oh.getOrderId());
            pstmt.setInt(2, oh.getUserId());
            pstmt.setString(3, oh.getOrderDate());
            pstmt.setFloat(4, oh.getTotalAmount());
            pstmt.setString(5, oh.getStatus());
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public OrderHistory get(int id) {
        try {
            PreparedStatement pstmt = con.prepareStatement(
                "SELECT * FROM `order_history` WHERE `id` = ?"
            );
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new OrderHistory(
                    rs.getInt("id"),
                    rs.getInt("orderId"),
                    rs.getInt("userId"),
                    rs.getString("orderDate"),
                    rs.getFloat("totalAmount"),
                    rs.getString("status")
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
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM `order_history`");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println(
                    new OrderHistory(
                        rs.getInt("id"),
                        rs.getInt("orderId"),
                        rs.getInt("userId"),
                        rs.getString("orderDate"),
                        rs.getFloat("totalAmount"),
                        rs.getString("status")
                    )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<OrderHistory> extracAL(ResultSet res) {
        List<OrderHistory> list = new ArrayList<>();
        try {
            while (res.next()) {
                list.add(new OrderHistory(
                    res.getInt("id"),
                    res.getInt("orderId"),
                    res.getInt("userId"),
                    res.getString("orderDate"),
                    res.getFloat("totalAmount"),
                    res.getString("status")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int update(OrderHistory oh, int id) {
        try {
            PreparedStatement pstmt = con.prepareStatement(
                "UPDATE `order_history` SET `orderId` = ?, `userId` = ?, `orderDate` = ?, `totalAmount` = ?, `status` = ? WHERE `id` = ?"
            );
            pstmt.setInt(1, oh.getOrderId());
            pstmt.setInt(2, oh.getUserId());
            pstmt.setString(3, oh.getOrderDate());
            pstmt.setFloat(4, oh.getTotalAmount());
            pstmt.setString(5, oh.getStatus());
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
            PreparedStatement pstmt = con.prepareStatement(
                "DELETE FROM `order_history` WHERE `id` = ?"
            );
            pstmt.setInt(1, id);
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
