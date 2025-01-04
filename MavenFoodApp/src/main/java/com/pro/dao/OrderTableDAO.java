package com.pro.dao;

import java.sql.ResultSet;
import java.util.List;
import com.pro.model.OrderTable;

public interface OrderTableDAO {
    public int add(OrderTable orderTable);
    public OrderTable get(int id);
    public void getAll();
    public List<OrderTable> extracAL(ResultSet res);
    public int update(OrderTable orderTable, int id);
    public int delete(int id);
}
