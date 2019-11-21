package cn.jzdy.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import cn.jzdy.dto.UserDto;

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
	
	
	List<Map<String,Object>> countUserList(@Param("userDto") UserDto userDto);
}
