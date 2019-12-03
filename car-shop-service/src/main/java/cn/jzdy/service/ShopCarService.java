package cn.jzdy.service;

import cn.jzdy.pojo.UserShoppingCart;

public interface ShopCarService {
	/**
	 * 
	* @author:yiwu
	* @Description:	增加购物车
	* @param userShoppingCart
	* @return    
	* Object:
	 */
	Object addShopCar(UserShoppingCart userShoppingCart);
	
	/**
	 * 
	* @author:yiwu
	* @Description:展示购物车
	* @param userId
	* @return    
	* Object:
	 */
	Object showShopCar(String userId);

}
