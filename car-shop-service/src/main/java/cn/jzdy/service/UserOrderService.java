package cn.jzdy.service;

import org.apache.ibatis.annotations.Param;

import cn.jzdy.pojo.Order;

public interface UserOrderService {

	/**
	 * 
	* @author:yiwu
	* @Description: 查询用户订单
	* @return    
	* Object:
	 */
	Object selectUserOrder(@Param("userId") String userId);
	
	
	/**
	 * 
	* @author:yiwu
	* @Description: 新增用户订单
	* @param order
	* @return    
	* Object:
	 */
	Object addUserOrder(@Param("order") Order order);
}
