package com.tccp.service;

import java.util.List;

import com.tccp.entity.User;


public interface UserService {
	void add(User user);
	boolean update(User user);
	boolean delete(int id);
	User findById(int id);
	List<User> findAll();
}
