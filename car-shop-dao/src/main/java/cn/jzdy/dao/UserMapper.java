package cn.jzdy.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import cn.jzdy.pojo.User;

@Mapper
public interface UserMapper {

	User findUserByUsernameAndPassword(@Param("username")String username,@Param("password")String password);
  
	//判断是否已注册
	int isUser(@Param("phone") String phone);
	
	//注册
	void insertUserRegister(@Param("user") User user);
	
}