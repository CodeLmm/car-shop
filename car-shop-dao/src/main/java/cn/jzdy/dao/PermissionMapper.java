package cn.jzdy.dao;

import cn.jzdy.pojo.Permission;
import java.util.List;

public interface PermissionMapper {


	List<Permission> findPermissionByUserId(String id);
}