package cn.jzdy.service.impl;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import cn.jzdy.dao.ShopCartMapper;
import cn.jzdy.pojo.UserShoppingCart;
import cn.jzdy.response.ErrorResult;
import cn.jzdy.response.SuccessResult;
import cn.jzdy.service.ShopCarService;
import cn.jzdy.util.id.UuidUtils;

@Service
@Transactional(rollbackFor = Exception.class)
public class ShopCarServiceImpl implements ShopCarService{
	@Autowired
	private ShopCartMapper shopCarMapper;

	@Override
	public Object addShopCar(UserShoppingCart userShoppingCart) {
		Integer count = shopCarMapper.existUser(userShoppingCart.getUserId());
		if(count != 1) {
			return new ErrorResult<>("用户不存在");
		}
		//查询是否已存在购物车
		String userId = userShoppingCart.getUserId();
		String carId = userShoppingCart.getCarId();
		Map<String, Object> map = shopCarMapper.existShopCar(userId , carId);
		if(Integer.valueOf(map.get("count").toString()) ==1) {
			//更新购物车信息
			Integer number = Integer.valueOf(map.get("num").toString()) +
							Integer.valueOf(userShoppingCart.getQuantity());
			userShoppingCart.setQuantity(number.toString());
			userShoppingCart.setUpdatetime(new Date());
			userShoppingCart.setId(map.get("id").toString());
			shopCarMapper.updateShopCar(userShoppingCart);
			return new SuccessResult<>("已添加到购物车中..");
		}
		
		userShoppingCart.setCreatetime(new Date());
		userShoppingCart.setId(UuidUtils.getUuid());
		userShoppingCart.setUpdatetime(new Date());
		shopCarMapper.addShopCar(userShoppingCart);
		return new SuccessResult<>("已添加到购物车中");
	}

	@Override
	public Object showShopCar(String userId) {
		Integer count = shopCarMapper.existUser(userId);
		if(count != 1) {
			return new ErrorResult<>("用户不存在");
		}
		Map<String, Object> map = shopCarMapper.showShopCar(userId);
		return new SuccessResult<>(map);
	}

}
