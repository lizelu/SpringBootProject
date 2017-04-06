package com.zeluli.inote.mapper;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.zeluli.inote.model.User;

@Mapper
public interface UserMapper {
	
	//根据用户名查询用户是否存在
	@Select("select * from user where username = #{username}")
	@Results(value={
			@Result(id=true, column="id", property="userId"),
			@Result(column="username", property="userName"),
			@Result(column="register_date", property="registerTime")
			})
	ArrayList<User>  queryUserInfo(@Param("username") String userName);
	
	//根据用户名和密码查询用户是否存在
	@Select("select * from user where username = #{username} and  password = #{password}")
	@Results(value={
			@Result(id=true, column="id", property="userId"),
			@Result(column="username", property="userName"),
			@Result(column="register_date", property="registerTime")
			})
	ArrayList<User>  queryUserInfoWithPwd(@Param("username") String userName, @Param("password") String password);
	
	//插入用户，用户注册
	@Insert("insert into user (username, password) values (#{username}, #{password})")
	void insert(@Param("username") String userName, @Param("password") String password);
}
