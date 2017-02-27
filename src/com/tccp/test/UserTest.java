package com.tccp.test;


import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tccp.persistence.UserMapper;
import com.tccp.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/config/spring-common.xml")
public class UserTest {

	@Autowired
	private UserMapper userMapper;
	
	@Test
	public void test22(){
		String tel="8208208822";
		User u = userMapper.findByTel(tel);
		System.out.println(u);
		
	}
	
	@Test
	public void testAdd(){
		User user = new User(4, "王五", "33");
		userMapper.add(user);
		
	}
	
	@Test
	public void testFindAll(){
		List<User> findAllList = userMapper.findAll();
		System.out.println(findAllList.size());
	}
	
	@Test
	public void testFindById(){
		User user = userMapper.findById(2);
		System.out.println(user.getUser_id());
		System.out.println(user.getUsername());
	}


	@Test
	public void testUpdate(){
		
		User user = new User(5, "钱6", "24");
		userMapper.update(user);
	}
	
	@Test
	public void testDelete(){
		userMapper.delete(4);
	}
}
