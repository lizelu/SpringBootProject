package com.zeluli.inote.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zeluli.inote.mapper.UserMapper;
import com.zeluli.inote.model.User;

@Service
@MapperScan("com.zeluli.inote.mapper")
public class UserDao extends SuperDao {
	
	@Autowired
	private UserMapper userMapper;
	
	public UserDao() {
		super();
	}
	
	public Map<String, Object> queryUserInfo(String userName) {
		this.responseBody.remove("list");
		ArrayList<User> users = userMapper.queryUserInfo(userName);
		if(!users.isEmpty()) {
			this.responseBody.put("list", users.get(0));
		}
		return this.responseBody;
	}
	
	public Map<String, Object> login(String userName, String password) {
		List<User> users = userMapper.queryUserInfoWithPwd(userName, password);
		if(!users.isEmpty()) {
			this.responseBody.put("list", users.get(0));
		}

		return this.responseBody;
	}
	
	public Map<String, Object> register(String userName, String password) {
		userMapper.insert(userName, password);
		return this.login(userName, password);
	}
}
