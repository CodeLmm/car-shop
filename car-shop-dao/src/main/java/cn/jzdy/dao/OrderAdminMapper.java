package cn.jzdy.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import cn.jzdy.dto.OrderAdminDto;

@Mapper
public interface OrderAdminMapper {
	
	long findOrderListCount(@Param("orderAdminDto")OrderAdminDto orderAdminDto);

	List<Map<String, Object>> findOrderList(@Param("orderAdminDto")OrderAdminDto orderAdminDto);
	@Delete("DELETE FROM o_order WHERE \"ID\" =#{id}")
	void deleteOrder(@Param("id")String id);
	@Update("UPDATE o_order SET SEND_STATUS = #{sendStatus} WHERE ID =#{id}")
	void updateOrderAdmin(@Param("id")String id,@Param("sendStatus") String sendStatus);
	
	Map<String,Object> findOrderDetailById(@Param("id")String id);
	
}
