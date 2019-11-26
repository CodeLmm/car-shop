package cn.jzdy.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.jzdy.dao.CarMapper;
import cn.jzdy.dto.CarBrankSelectDto;
import cn.jzdy.response.SuccessResult;
import cn.jzdy.service.CarService;
@Service
@Transactional(rollbackFor = Exception.class)
public class CarServiceImpl implements CarService {
	@Autowired
	private CarMapper carMapper;
	/**
	 *	首页查询热门品牌
	 * authod lujingdong
	 * 2019年11月19日
	 * @return
	 */
	@Override
	public Object findHotBrand() {
		return new SuccessResult<>(carMapper.findHotBrand());
	}
	
	/**
	 *	首页面/对应选车地带，根据车的类型查出前六辆热门车
	 * authod lujingdong
	 * 2019年11月19日
	 * @return
	 */
	@Override
	public Object findHotCar(String carType) {	
		return new SuccessResult<>(carMapper.findHotCar(carType));
	}
	
	/**
	 * 首页面/根据订单的销量进行排行（查出前五条记录）
	 * authod lujingdong
	 * 2019年11月21日
	 * @param carType
	 * @return
	 */
	@Override
	public Object findSalesVolumeCar() {
		return new SuccessResult<>(carMapper.findSalesVolumeCar());
	}

	
	/**
	 * 商品详情
	 * authod lujingdong
	 * 2019年11月21日
	 * @param carType
	 * @return
	 */
	@Override
	public Object carDetail(String id) {
		return new SuccessResult<>(carMapper.carDetail(id));
	}

	
	/**
	 * 分页，根据车的品牌进行分页查询
	 * authod lujingdong
	 * 2019年11月21日
	 * @param carType
	 * @return
	 */
	@Override
	public Object findListByCarBrank(CarBrankSelectDto carBrankSelectDto) {
		//初始化页的参数
		carBrankSelectDto.init();
		//查询总数
		Long count = carMapper.findCountByCarBrank(carBrankSelectDto);
		//查询数据
		List<Map<String,Object>> catList = carMapper.findCarListByCarBrank(carBrankSelectDto);
		return new SuccessResult<>(carBrankSelectDto.pageResponse(catList, count));
	}
	
}
