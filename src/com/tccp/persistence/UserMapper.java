package com.tccp.persistence;

import java.util.List;
import com.tccp.entity.User;

public interface UserMapper {
	//增删改查
	void add(User user);
	boolean update(User user);
	boolean delete(int user_id);
	User findById(int user_id);
	List<User> findAll();
	User findByTel(String tel);
	
}
