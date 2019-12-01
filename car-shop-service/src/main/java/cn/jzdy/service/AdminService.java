package cn.jzdy.service;


import cn.jzdy.dto.UserDto;


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
	
}
