package cn.jzdy.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.jzdy.dao.OrderAdminMapper;
import cn.jzdy.dto.OrderAdminDto;
import cn.jzdy.message.ResultMsg;
import cn.jzdy.response.SuccessResult;
import cn.jzdy.service.OrderAdminService;
@Service
@Transactional(rollbackFor = Exception.class)
public class OrderAdminServiceImpl implements OrderAdminService {
	@Autowired
	private OrderAdminMapper orderAdminMapper;
	@Override
	public Object findOrderList(OrderAdminDto orderAdminDto) {
		orderAdminDto.init();
		long count =  orderAdminMapper.findOrderListCount(orderAdminDto);
		List<Map<String,Object>> data = orderAdminMapper.findOrderList(orderAdminDto);
		return new SuccessResult<>(orderAdminDto.pageResponse(data, count));
	}
	@Override
	public Object updateOrderAdmin(String id,String sendStatus) {
		orderAdminMapper.updateOrderAdmin(id,sendStatus);
		return new SuccessResult<>(ResultMsg.UPDATE_SUCCESS);
	}
	@Override
	public Object deleteOrderAdmin(String id) {
		orderAdminMapper.deleteOrder(id);
		return new SuccessResult<>(ResultMsg.DELETE_SUCCESS);
	}
	@Override
	public Object findOrderDetailById(String id) {
		return new SuccessResult<>(orderAdminMapper.findOrderDetailById(id));
	}
}
