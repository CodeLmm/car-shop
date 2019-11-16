package cn.jzdy.dao;

import cn.jzdy.pojo.RolePermissionKey;
import java.util.List;

public interface RolePermissionKeyMapper {
    int insert(RolePermissionKey record);

    List<RolePermissionKey> selectAll();
}