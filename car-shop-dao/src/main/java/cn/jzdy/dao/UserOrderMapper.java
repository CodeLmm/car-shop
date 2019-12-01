package cn.jzdy.dao;

import java.awt.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import cn.jzdy.pojo.Order;

@Mapper
public interface UserOrderMapper {

	/**
	 * 
	* @author:yiwu
	* @Description:  根据用户id查询是否存在用户
	* @param userId
	* @return    
	* Integer:
	 */
	Integer selectUserByUserId(@Param("userId") String userId);
	
	/**
	 * 
	* @author:yiwu
	* @Description: 通过用户id查询订单
	* @param userId
	* @return    
	* List:
	 */
	List  selectOrderByUserId(@Param("userId") String userId);
	
	/**
	 * 
	* @author:yiwu
	* @Description:增加用户订单
	* @param order    
	* void:
	 */
	Integer addUserOrder(@Param("order") Order order);
	
	/**
	 * 
	* @author:yiwu
	* @Description:根据carId查询车子单价
	* @param carId
	* @return    
	* Integer:
	 */
	Integer selectCarPriceByCarId(@Param("carId") String carId);
}
