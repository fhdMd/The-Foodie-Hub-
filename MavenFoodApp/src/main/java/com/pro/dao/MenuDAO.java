package com.pro.dao;

import java.sql.ResultSet;
import java.util.List;

import com.pro.model.Menu;

public interface MenuDAO {
	public int add(Menu m);
	public Menu get(int id);
	public List<Menu> getAll(int restaurantId);
	public List<Menu> extractAL(ResultSet res);
	public int update(Menu m,int id);
	public int delete(int id);
}
