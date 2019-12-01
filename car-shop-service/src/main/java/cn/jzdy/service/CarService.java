package cn.jzdy.service;

import org.springframework.web.multipart.MultipartFile;

import cn.jzdy.dto.CarSelectDto;
import cn.jzdy.request_param.CarParam;

public interface CarService {
	
	Object findHotBrand();

	Object findHotCar(String carType);

	Object findSalesVolumeCar();

	Object carDetail(String id);

	Object findListByCarBrank(CarSelectDto carSelectDto);

	Object deleteCar(String id);

	Object selectAllBrank();

	Object addCar(CarParam carParam, MultipartFile file);

	Object updateCar(CarParam carParam, MultipartFile file);

}
