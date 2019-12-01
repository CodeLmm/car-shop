package cn.jzdy.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import cn.jzdy.dto.UserDto;
<<<<<<< HEAD
import cn.jzdy.pojo.User;
import cn.jzdy.request_param.UserParam;
=======
>>>>>>> branch 'master' of https://github.com/CodeLmm/car-shop.git

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
	
	
	
	Integer updateUser(@Param ("userParam") UserParam userParam ,@Param("userId") String userId);

}
