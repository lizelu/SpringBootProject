package com.zeluli.inote;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zeluli.inote.dao.UserDao;
import com.zeluli.inote.model.User;

@RestController
public class UserRestController {
	
	@Autowired
	private UserDao userDao;
	
	@RequestMapping(value="/queryUserInfoByUserName")
	public Map<String, Object> queryUserInfo(String userName) {
		System.out.println(userName);
		return userDao.queryUserInfo(userName);
	}
	
	@RequestMapping(value="/login")
	public Map<String, Object> login(String userName, String password) {
		return userDao.login(userName, password);
	}
	
	@RequestMapping(value="/register")
	public Map<String, Object> register(String userName, String password) {
		return userDao.register(userName, password);
	}
	
	@RequestMapping(value="/queryUserInfoByUserName1")
	public Map<String, Object> queryUserInfo1(String userName) {

		
		User user = new User();
		user.setUserName("aa");
		user.setPassword("bb");
		user.setRegisterTime("cc");
		user.setUserId("");
		
		ArrayList<User> list = new ArrayList<User>();
		list.add(user);
		list.add(user);
		list.add(user);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("aa", user);
		map.put("bb", list);
		return map;
		//return userMapper.queryUserInfo(userName);
	}
	
	
}
