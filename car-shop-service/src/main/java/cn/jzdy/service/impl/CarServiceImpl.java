package cn.jzdy.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import cn.jzdy.dao.CarMapper;
import cn.jzdy.dto.CarSelectDto;
import cn.jzdy.message.ResultMsg;
import cn.jzdy.request_param.CarParam;
import cn.jzdy.response.ErrorResult;
import cn.jzdy.response.SuccessResult;
import cn.jzdy.service.CarService;
import cn.jzdy.util.FileUploadUtils;
import cn.jzdy.util.id.UuidUtils;
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
	public Object findListByCarBrank(CarSelectDto carSelectDto) {
		//初始化页的参数
		carSelectDto.init();
		//查询总数
		Long count = carMapper.findCountByCarBrank(carSelectDto);
		//查询数据
		List<Map<String,Object>> catList = carMapper.findCarListByCarBrank(carSelectDto);
		return new SuccessResult<>(carSelectDto.pageResponse(catList, count));
	}
	
	/**
	 * 商品（车辆）的删除
	 * authod lujingdong
	 * 2019年11月23日
	 * @param id
	 * @return
	 */
	@Override
	public Object deleteCar(String id) {
		int count = carMapper.deleteCar(id);
		return count>0?new SuccessResult<>(ResultMsg.DELETE_SUCCESS):new ErrorResult<>(ResultMsg.DELETE_ERROR);
	}
	/**
	 * 查寻所有车的品牌
	 * authod lujingdong
	 * 2019年11月23日
	 * @return
	 */
	@Override
	public Object selectAllBrank() {
		return carMapper.selectAllBrank();
	}

	@Override
	public Object addCar(CarParam carParam,MultipartFile file) {
		String imageStr = FileUploadUtils.upload(file);
		if(imageStr==null) {
			return new ErrorResult<>("文件上传失败");
		}
		carParam.setImgUrl(imageStr);
		carParam.setId(UuidUtils.getUuid());
		return carMapper.addCar(carParam)>0?new SuccessResult<>(ResultMsg.ADD_SUCCESS):new SuccessResult<>(ResultMsg.ADD_ERROR);
	}

	@Override
	public Object updateCar(CarParam carParam, MultipartFile file) {
		String imageStr = FileUploadUtils.upload(file);
		carParam.setImgUrl(imageStr);
		return carMapper.updateCar(carParam)>0?new SuccessResult<>(ResultMsg.UPDATE_SUCCESS):new SuccessResult<>(ResultMsg.UPDATE_ERROR);
	}
	
}
