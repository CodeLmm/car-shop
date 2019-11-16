package cn.jzdy.dao;

import cn.jzdy.pojo.Permission;
import java.util.List;

public interface PermissionMapper {
    int insert(Permission record);

    List<Permission> selectAll();
}