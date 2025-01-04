package com.pro.dao;

import java.sql.ResultSet;
import java.util.List;
import com.pro.model.Restaurant;

public interface RestaurantDAO {
    public int add(Restaurant restaraunt);
    public Restaurant get(int id);
    public List<Restaurant> getAll();
    public List<Restaurant> extracAL(ResultSet res);
    public int update(Restaurant restaraunt, int id);
    public int delete(int id);
}
