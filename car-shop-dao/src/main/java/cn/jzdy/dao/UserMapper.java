package cn.jzdy.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import cn.jzdy.pojo.User;
import cn.jzdy.request_param.UserParam;

@Mapper
public interface UserMapper {

	User findUserByUsernameAndPassword(@Param("username")String username,@Param("password")String password);
  
	//判断是否已注册
	int isUser(@Param("phone") String phone);
	
	//注册
	void insertUserRegister(@Param("user") User user);
	
	
	/**
	 * 更新用户  个人中心
	* @author:yiwu
	* @Description:
	* @param userId    
	* void:
	 */
	void updateUser(@Param("userParam") UserParam userParam);
	
}