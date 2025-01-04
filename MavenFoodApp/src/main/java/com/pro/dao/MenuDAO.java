package com.pro.dao;

import java.sql.ResultSet;
import java.util.List;

import com.pro.model.Menu;

public interface MenuDAO {
	public int add(Menu m);
	public Menu get(int id);
	public void getAll();
	public List<Menu> extracAL(ResultSet res);
	public int update(Menu m,int id);
	public int delete(int id);
}
