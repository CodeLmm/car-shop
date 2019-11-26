package cn.jzdy.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import cn.jzdy.dto.UserDto;
import cn.jzdy.pojo.User;

@Mapper
public interface AdminMapper {
	
	/**
	 * 
	* @author:yiwu
	* @Description:查询用户总数
	* @return    
	* List<User>:
	 */
	long countUser(@Param("userDto")UserDto userDto );
	
	/**
	 * 
	* @author:yiwu
	* @Description: 查询用户列表
	* @param userDto
	* @return    
	* List<Map<String,Object>>:
	 */
	List<Map<String,Object>> countUserList(@Param("userDto") UserDto userDto);
	
	
	/**
	 * 
	* @author:yiwu
	* @Description: 根据id查询用户
	* @param userId
	* @return    
	* User:
	 */
	User selectUserByUserId(@Param("userId") String userId);
	
	/**
	 * 
	* @author:yiwu
	* @Description: 更新用户状态
	* @param userId
	* @return    
	* int:
	 */
	Integer updateStauts(@Param("userId") String userId);
}
