package com.pro.daoimp;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.pro.dao.OrderItemDAO;
import com.pro.model.OrderItem;
import com.pro.util.Util;

public class OrderItemDAOImpl implements OrderItemDAO {
    Connection con = Util.getCon();

    @Override
    public int add(OrderItem oi) {
        try {
            PreparedStatement pstmt = con.prepareStatement(
                "INSERT INTO `order_item` (`orderId`, `menuId`, `quantity`, `subtotal`) VALUES (?, ?, ?, ?)"
            );
            pstmt.setInt(1, oi.getOrderId());
            pstmt.setInt(2, oi.getMenuId());
            pstmt.setInt(3, oi.getQuantity());
            pstmt.setFloat(4, oi.getSubtotal());
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public OrderItem get(int orderItemId) {
        try {
            PreparedStatement pstmt = con.prepareStatement(
                "SELECT * FROM `order_item` WHERE `orderItemId` = ?"
            );
            pstmt.setInt(1, orderItemId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new OrderItem(
                    rs.getInt("orderItemId"),
                    rs.getInt("orderId"),
                    rs.getInt("menuId"),
                    rs.getInt("quantity"),
                    rs.getFloat("subtotal")
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
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM `order_item`");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println(
                    new OrderItem(
                        rs.getInt("orderItemId"),
                        rs.getInt("orderId"),
                        rs.getInt("menuId"),
                        rs.getInt("quantity"),
                        rs.getFloat("subtotal")
                    )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<OrderItem> extracAL(ResultSet res) {
        List<OrderItem> list = new ArrayList<>();
        try {
            while (res.next()) {
                list.add(new OrderItem(
                    res.getInt("orderItemId"),
                    res.getInt("orderId"),
                    res.getInt("menuId"),
                    res.getInt("quantity"),
                    res.getFloat("subtotal")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int update(OrderItem oi, int orderItemId) {
        try {
            PreparedStatement pstmt = con.prepareStatement(
                "UPDATE `order_item` SET `orderId` = ?, `menuId` = ?, `quantity` = ?, `subtotal` = ? WHERE `orderItemId` = ?"
            );
            pstmt.setInt(1, oi.getOrderId());
            pstmt.setInt(2, oi.getMenuId());
            pstmt.setInt(3, oi.getQuantity());
            pstmt.setFloat(4, oi.getSubtotal());
            pstmt.setInt(5, orderItemId);
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int delete(int orderItemId) {
        try {
            PreparedStatement pstmt = con.prepareStatement(
                "DELETE FROM `order_item` WHERE `orderItemId` = ?"
            );
            pstmt.setInt(1, orderItemId);
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
