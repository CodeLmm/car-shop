package cn.jzdy.service;

import cn.jzdy.dto.OrderAdminDto;

public interface OrderAdminService {

	Object findOrderList(OrderAdminDto orderAdminDto);

	Object updateOrderAdmin(String id, String sendStatus);

	Object deleteOrderAdmin(String id);

	Object findOrderDetailById(String id);

}
