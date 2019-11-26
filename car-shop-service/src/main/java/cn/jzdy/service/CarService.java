package cn.jzdy.service;

import cn.jzdy.dto.CarBrankSelectDto;

public interface CarService {
	
	Object findHotBrand();

	Object findHotCar(String carType);

	Object findSalesVolumeCar();

	Object carDetail(String id);


	Object findListByCarBrank(CarBrankSelectDto carBrankSelectDto);

}
