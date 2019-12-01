package cn.jzdy.service;


import cn.jzdy.dto.UserDto;
import cn.jzdy.request_param.UserParam;


public interface AdminService {
	
	/**
	 * 
	* @author:yiwu
	* @Description: 用户列表
	* @param carBrankSelectDto
	* @return    
	* Object:
	 */
	Object countUserList(UserDto userDto);
	

	
	/**
	 * 
	* @author:yiwu
	* @Description:  删除用户
	* @param userId
	* @return    
	* User:
	 */
	Object deleteUser(String userId);
	
	/**
	 * 
	* @author:yiwu
	* @Description: 添加用户
	* @param userParam
	* @return    
	* Object:
	 */
	Object addUser(UserParam userParam);
	
	/**
	 * 
	* @author:yiwu
	* @Description: 通过用户Id查询用户信息
	* @param userId
	* @return    
	* Object:
	 */
	Object selectUserByUserId(String userId);
	
	
	/**
	 * 
	* @author:yiwu
	* @Description:   修改用户
	* @param userParam
	* @return    
	* Object:
	 */
	Object updateUser(UserParam userParam ,String userId);
	

}
