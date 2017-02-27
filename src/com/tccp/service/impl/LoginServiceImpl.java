package com.tccp.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tccp.persistence.UserMapper;
import com.tccp.entity.User;
import com.tccp.service.LoginService;
import com.tccp.service.UserService;



@Service
@Transactional  
//此处不再进行创建SqlSession和提交事务，都已交由spring去管理了。
public class LoginServiceImpl implements LoginService {
	
	@Resource
	private UserMapper mapper;

	@Override
	public User telAccess(String tel) {
		User user = mapper.findByTel(tel);
		return user;
	}


}
