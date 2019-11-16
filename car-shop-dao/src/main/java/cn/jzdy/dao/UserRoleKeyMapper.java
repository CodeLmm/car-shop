package cn.jzdy.dao;

import cn.jzdy.pojo.UserRoleKey;
import java.util.List;

public interface UserRoleKeyMapper {
    int insert(UserRoleKey record);

    List<UserRoleKey> selectAll();
}