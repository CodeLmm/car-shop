package cn.jzdy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.jzdy.annotation.aop.NoCheckOnline;
import cn.jzdy.dto.CarBrankSelectDto;
import cn.jzdy.dto.CarSelectDto;
import cn.jzdy.service.CarService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

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
	
	/**
	 * 车辆详情
	 * authod lujingdong
	 * 2019年11月21日
	 * @param carType
	 * @return
	 */
	@NoCheckOnline
	@ApiOperation(value = "商品详情", notes = "商品详情")
	@ApiImplicitParam(name = "id", value = "商品id", paramType = "id")
	@PostMapping("carDetail")
	public Object carDetail(String id) {
		return carService.carDetail(id);
	}
	
	/**
	 * 分页，根据车的品牌进行分页查询
	 * authod lujingdong
	 * 2019年11月21日
	 * @param carType
	 * @return
	 */
	@ApiImplicitParams({
		@ApiImplicitParam(name = "userTicket", value = "用户凭证", paramType = "header", required = true)
	})
	@ApiOperation(value = "分页，根据车的品牌进行分页查询", notes = "分页，根据车的品牌进行分页查询")
	@PostMapping("findListByCarBrank")
	public Object findListarBrank(
			@RequestBody
			@ApiParam(name="CarSelectDto",value="页面传来的参数实体",required = true)
			CarSelectDto carSelectDto) {
		return carService.findListByCarBrank(carSelectDto);
	}
	
	
	
}
