package cn.jzdy.dao;

import cn.jzdy.pojo.Permission;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface PermissionMapper {


	List<Permission> findPermissionByUserId(String id);
}