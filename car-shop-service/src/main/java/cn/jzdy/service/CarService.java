package cn.jzdy.service;

import cn.jzdy.dto.CarSelectDto;

public interface CarService {
	
	Object findHotBrand();

	Object findHotCar(String carType);

	Object findSalesVolumeCar();

	Object carDetail(String id);

	Object findListByCarBrank(CarSelectDto carSelectDto);

}
