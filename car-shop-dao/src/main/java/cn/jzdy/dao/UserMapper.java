package cn.jzdy.dao;

import org.apache.ibatis.annotations.Mapper;

import cn.jzdy.pojo.User;
import io.lettuce.core.dynamic.annotation.Param;

@Mapper
public interface UserMapper {

	User findUserByUsernameAndPassword(@Param("username")String username,@Param("password")String password);
  
}