package com.pro.dao;

import java.sql.ResultSet;
import java.util.List;
import com.pro.model.OrderItem;

public interface OrderItemDAO {
    public int add(OrderItem orderItem);
    public OrderItem get(int orderItemId);
    public void getAll();
    public List<OrderItem> extracAL(ResultSet res);
    public int update(OrderItem orderItem, int orderItemId);
    public int delete(int orderItemId);
}
