package cn.jzdy.service;

public interface CarService {
	
	Object findHotBrand();

	Object findHotCar(String carType);

	Object findSalesVolumeCar();

	Object carDetail(String id);

}
