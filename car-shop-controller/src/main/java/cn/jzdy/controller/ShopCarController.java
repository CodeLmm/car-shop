package cn.jzdy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.jzdy.pojo.UserShoppingCart;
import cn.jzdy.response.ErrorResult;
import cn.jzdy.service.ShopCarService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(tags = "用户购物车模块")
@RestController
@RequestMapping("admin")
public class ShopCarController {
	
	@Autowired
	private ShopCarService shopCarService;
	
	@PostMapping("addShopCar")
	@ApiOperation(value = "增加购物车", notes = "增加购物车")
	@ApiImplicitParams({
		  @ApiImplicitParam(name = "userTicket", value = "用户凭证", paramType = "header", required = true)
		 })
	public Object addShopCar(
			@RequestBody UserShoppingCart userShoppingCart) {
		if(StringUtils.isEmpty(userShoppingCart)) {
			return new ErrorResult<>("userShoppingCar is null");
		}
		return shopCarService.addShopCar( userShoppingCart);
	}
	
	@PostMapping("showShopCar")
	@ApiOperation(value = "展示购物车", notes = "展示购物车")
	@ApiImplicitParams({
		  @ApiImplicitParam(name = "userTicket", value = "用户凭证", paramType = "header", required = true)
		 })
	public Object showShopCar(String userId) {
		if(StringUtils.isEmpty(userId)) {
			return new ErrorResult<>("userId is null");
		}
		return shopCarService.showShopCar(userId);
	}

}
