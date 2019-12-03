package cn.jzdy.dao;

import java.util.List;
import java.util.Map;
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
	List<Map<String, Object>>  selectOrderByUserId(@Param("userId") String userId);
	
	/**
	 * 
	* @author:yiwu
	* @Description:增加用户订单
	* @param order    
	* void:
	 */
	void addUserOrder(@Param("order") Order order);
	
	/**
	 * 
	* @author:yiwu
	* @Description:根据carId查询车子单价
	* @param carId
	* @return    
	* Integer:
	 */
	Map<String , Object> selectCarPriceByCarId(@Param("carId") String carId);
	
	/**
	 * 
	* @author:yiwu
	* @Description: 根据用户id和carId查询 是否已存在此订单
	* @param userId
	* @param carId
	* @return    
	* Map<String,Object>:
	 */
	Map<String, Object> existOrder(@Param("userId") String userId,@Param("carId") String carId);
	/**
	 * 
	* @author:yiwu
	* @Description: 新增同用户  同类型商品的订单  只改数量
	* @param id
	* @param num
	* @return    
	* Integer:
	 */
	Integer updateOrder (@Param("id") String id,@Param("number") Integer number);
}
