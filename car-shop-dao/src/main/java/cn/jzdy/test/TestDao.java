package cn.jzdy.test;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TestDao {
	@Select("SELECT NAME FROM `user`")
	public Object testMybatis();
}
