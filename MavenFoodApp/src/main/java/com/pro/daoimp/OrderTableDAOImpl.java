package com.pro.daoimp;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.pro.dao.OrderTableDAO;
import com.pro.model.OrderTable;
import com.pro.util.Util;

public class OrderTableDAOImpl implements OrderTableDAO {
    Connection con = Util.getCon();

    @Override
    public int add(OrderTable ot) {
        try {
            PreparedStatement pstmt = con.prepareStatement(
                "INSERT INTO `order_table` (`userId`, `restarauntId`, `orderTime`, `totalAmount`, `status`) VALUES (?, ?, ?, ?, ?)"
            );
            pstmt.setInt(1, ot.getUserId());
            pstmt.setInt(2, ot.getRestarauntId());
            pstmt.setInt(3, ot.getOrderTime());
            pstmt.setFloat(4, ot.getTotalAmount());
            pstmt.setString(5, ot.getStatus());
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public OrderTable get(int id) {
        try {
            PreparedStatement pstmt = con.prepareStatement(
                "SELECT * FROM `order_table` WHERE `id` = ?"
            );
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new OrderTable(
                    rs.getInt("id"),
                    rs.getInt("userId"),
                    rs.getInt("restarauntId"),
                    rs.getInt("orderTime"),
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
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM `order_table`");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println(
                    new OrderTable(
                        rs.getInt("id"),
                        rs.getInt("userId"),
                        rs.getInt("restarauntId"),
                        rs.getInt("orderTime"),
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
    public List<OrderTable> extracAL(ResultSet res) {
        List<OrderTable> list = new ArrayList<>();
        try {
            while (res.next()) {
                list.add(new OrderTable(
                    res.getInt("id"),
                    res.getInt("userId"),
                    res.getInt("restarauntId"),
                    res.getInt("orderTime"),
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
    public int update(OrderTable ot, int id) {
        try {
            PreparedStatement pstmt = con.prepareStatement(
                "UPDATE `order_table` SET `userId` = ?, `restarauntId` = ?, `orderTime` = ?, `totalAmount` = ?, `status` = ? WHERE `id` = ?"
            );
            pstmt.setInt(1, ot.getUserId());
            pstmt.setInt(2, ot.getRestarauntId());
            pstmt.setInt(3, ot.getOrderTime());
            pstmt.setFloat(4, ot.getTotalAmount());
            pstmt.setString(5, ot.getStatus());
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
                "DELETE FROM `order_table` WHERE `id` = ?"
            );
            pstmt.setInt(1, id);
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
