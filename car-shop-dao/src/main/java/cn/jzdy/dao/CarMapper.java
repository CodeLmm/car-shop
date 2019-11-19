package cn.jzdy.dao;

import cn.jzdy.pojo.Car;
import java.util.List;

public interface CarMapper {
    int deleteByPrimaryKey(String id);

    int insert(Car record);

    Car selectByPrimaryKey(String id);

    List<Car> selectAll();

    int updateByPrimaryKey(Car record);
}