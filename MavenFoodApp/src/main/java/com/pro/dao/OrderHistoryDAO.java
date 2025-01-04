package com.pro.dao;

import java.sql.ResultSet;
import java.util.List;
import com.pro.model.OrderHistory;

public interface OrderHistoryDAO {
    public int add(OrderHistory orderHistory);
    public OrderHistory get(int id);
    public void getAll();
    public List<OrderHistory> extracAL(ResultSet res);
    public int update(OrderHistory orderHistory, int id);
    public int delete(int id);
}
