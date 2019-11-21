package cn.jzdy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.jzdy.annotation.aop.NoCheckOnline;
import cn.jzdy.service.CarService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@Api(tags = "商品模块")
@RestController
@RequestMapping("car")
public class CarController {
	@Autowired
	private CarService carService;
	/**
	 *	首页查询热门品牌
	 * authod lujingdong
	 * 2019年11月19日
	 * @return
	 */
	@NoCheckOnline
	@ApiOperation(value = "首页查询热门品牌", notes = "首页查询热门品牌")
	@PostMapping("findHotBrand")
	public Object findHotBrand() {
		return carService.findHotBrand();
	}
	
	/**
	 *	首页面/对应选车地带，根据车的类型查出前六辆热门车
	 * authod lujingdong
	 * 2019年11月19日
	 * @return
	 */
	@NoCheckOnline
	@ApiOperation(value = "选车地带，根据车的类型查出前六辆热门车", notes = "选车地带，根据车的类型查出前六辆热门车")
	@ApiImplicitParam(name = "carType", value = "车的类型", paramType = "query")
	@PostMapping("findHotCar")
	public Object findHotCar(String carType) {
		return carService.findHotCar(carType);
	}
	
	
	/**
	 * 首页面/根据订单的销量进行排行（查出前五条记录）
	 * authod lujingdong
	 * 2019年11月21日
	 * @param carType
	 * @return
	 */
	@NoCheckOnline
	@ApiOperation(value = "首页面/根据订单的销量进行排行（查出前五条记录）", notes = "首页面/根据订单的销量进行排行（查出前五条记录）")
	@PostMapping("findSalesVolumeCar")
	public Object findSalesVolumeCar() {
		return carService.findSalesVolumeCar();
	}
	
}
