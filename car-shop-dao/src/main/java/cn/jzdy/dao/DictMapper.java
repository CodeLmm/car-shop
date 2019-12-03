package cn.jzdy.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import cn.jzdy.dto.DictSelectDto;
import cn.jzdy.request_param.DictParam;

@Mapper
public interface DictMapper {
	@Select("SELECT d.SORT,d.`VALUE`,d.ID FROM dict d WHERE d.SORT =#{dictSelectDto.sort} LIMIT #{dictSelectDto.countPageStart},#{dictSelectDto.pageTotal}")
	List<Map<String, Object>> findDictBySort(@Param("dictSelectDto") DictSelectDto dictSelectDto);

	@Select("SELECT COUNT(d.ID) FROM dict d WHERE d.SORT =#{dictSelectDto.sort}")
	long findDictCountBySort(@Param("dictSelectDto") DictSelectDto dictSelectDto);

	@Select("SELECT d.SORT FROM dict d GROUP BY d.SORT")
	List<String> findAllDictSort();

	@Delete("DELETE FROM dict WHERE ID=#{id}")
	void delectDictRecordById(@Param("id") String id);

	@Insert("INSERT INTO dict(`ID`,`KEY`,SORT,`VALUE`,IMAGE_URL) VALUES(#{dictParam.id},#{dictParam.key},#{dictParam.sort},#{dictParam.value},#{dictParam.imageUrl})")
	void addDictRecordBySort(@Param("dictParam") DictParam dictParam);

	void updateDictRecordById(@Param("dictParam") DictParam dictParam);

}