package com.pro.dao;

import java.sql.ResultSet;
import java.util.List;
import com.pro.model.User;

public interface UserDAO {
    public int add(User user);
    public User get(int id);
    public void getAll();
    public List<User> extracAL(ResultSet res);
    public int update(User user, int id);
    public int delete(int id);
	public User search(String email);
}
