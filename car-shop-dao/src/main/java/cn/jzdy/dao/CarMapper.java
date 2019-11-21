package cn.jzdy.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import cn.jzdy.dto.CarBrankSelectDto;


@Mapper
public interface CarMapper {

	List<Map<String,Object>> findHotBrand();

	List<Map<String,Object>> findHotCar(@Param("carType")String carType);

	List<Map<String,Object>> findSalesVolumeCar();

	Map<String,Object> carDetail(String id);

	Long findCountByCarBrank(@Param("carBrankSelectDto")CarBrankSelectDto carBrankSelectDto);

	List<Map<String, Object>> findCarListByCarBrank(@Param("carBrankSelectDto")CarBrankSelectDto carBrankSelectDto);
   
}