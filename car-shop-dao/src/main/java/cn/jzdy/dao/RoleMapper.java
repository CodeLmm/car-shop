package cn.jzdy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cn.jzdy.pojo.Role;
import io.lettuce.core.dynamic.annotation.Param;

/**
 * 权限
 * Lujingdong
 * 2019年11月17日
 */
@Mapper
public interface RoleMapper {

	List<Role> finRoleByUserId(@Param("id")String id);
 
}