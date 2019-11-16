package cn.jzdy.dao;

import cn.jzdy.pojo.User;
import java.util.List;

public interface UserMapper {
    int insert(User record);

    List<User> selectAll();
}