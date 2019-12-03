package cn.jzdy.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import cn.jzdy.pojo.UserShoppingCart;

@Mapper
public interface ShopCartMapper {
	/**
	 * 
	* @author:yiwu
	* @Description:	判断是否存在此用户
	* @param userId
	* @return    
	* Integer:
	 */
	Integer existUser(@Param("userId") String userId);
	
	/**
	 * 
	* @author:yiwu
	* @Description:判断是否已经存在购物车
	* @return    
	* Integer:
	 */
	Map<String, Object> existShopCar(@Param("userId") String userId,@Param("carId") String carId);
	
	/**
	 * 
	* @author:yiwu
	* @Description: 更新购物车
	* @param userShoppingCart
	* @return    
	* Integer:
	 */
	Integer updateShopCar(@Param("userShoppingCart") UserShoppingCart userShoppingCart);
	
	/**
	 * 
	* @author:yiwu
	* @Description:增加购物车
	* @param userShoppingCart
	* @return    
	* Integer:
	 */
	Integer addShopCar(@Param("userShoppingCart") UserShoppingCart userShoppingCart);
	
	/**
	 * 
	* @author:yiwu
	* @Description: 展示购物车
	* @param userId
	* @return    
	* Map<String,Object>:
	 */
	Map<String, Object> showShopCar(@Param("userId") String userId);
   
}