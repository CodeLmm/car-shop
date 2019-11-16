package cn.jzdy.dao;

import cn.jzdy.pojo.Role;
import java.util.List;

public interface RoleMapper {
    int insert(Role record);

    List<Role> selectAll();
}