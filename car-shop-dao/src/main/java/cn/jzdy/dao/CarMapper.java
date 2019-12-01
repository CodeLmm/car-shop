package cn.jzdy.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cn.jzdy.dto.CarSelectDto;
import cn.jzdy.request_param.CarParam;


@Mapper
public interface CarMapper {

	List<Map<String,Object>> findHotBrand();

	List<Map<String,Object>> findHotCar(@Param("carType")String carType);

	List<Map<String,Object>> findSalesVolumeCar();

	Map<String,Object> carDetail(String id);

	Long findCountByCarBrank(@Param("carSelectDto")CarSelectDto carSelectDto);

	List<Map<String, Object>> findCarListByCarBrank(@Param("carSelectDto")CarSelectDto carSelectDto);
	
	@Update("UPDATE c_car SET `STATUS` = 0 WHERE ID = #{id}")
	int deleteCar(@Param("id")String id);
	@Select("SELECT" + 
			"	d.`KEY`," + 
			"	d.`VALUE`," + 
			"	d.IMAGE_URL" + 
			" FROM" + 
			"	dict d" + 
			" WHERE d.SORT = 'CAR_BRAND'")
	List<Map<String,Object>> selectAllBrank();

	int addCar(@Param("carParam")CarParam carParam);

	int updateCar(@Param("carParam")CarParam carParam);

   
}