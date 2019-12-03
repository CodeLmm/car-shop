package cn.jzdy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.jzdy.dto.OrderAdminDto;
import cn.jzdy.service.OrderAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("admin/order")
@Api(tags = "管理端订单模块")
public class OrderAdminController {
	@Autowired
	private OrderAdminService orderAdminService; 
	/**
	 * "订单分页查询，需要带条件
	 * authod lujingdong
	 * 2019年11月26日
	 * @param carSelectDto
	 * @return
	 */
	@ApiImplicitParams({
		@ApiImplicitParam(name = "userTicket", value = "用户凭证", paramType = "header", required = true)
	})
	@ApiOperation(value = "订单分页查询，需要带条件", notes = "订单分页查询，需要带条件")
	@PostMapping("findOrderList")
	public Object findOrderList(
			@RequestBody
			@ApiParam(name="CarSelectDto",value="页面传来的参数实体",required = true)
			OrderAdminDto orderAdminDto) {
		return orderAdminService.findOrderList(orderAdminDto);
	}
	
	/**
	 * 修改订单信息
	 * authod lujingdong
	 * 2019年12月1日
	 * @param orderAdminDto
	 * @return
	 */
	@ApiImplicitParams({
		@ApiImplicitParam(name = "userTicket", value = "用户凭证", paramType = "query", required = true),
		@ApiImplicitParam(name = "sendStatus", value = "发送状态 1=已发送 2=未发送 ", paramType = "query", required = true),
		@ApiImplicitParam(name = "id", value = "订单", paramType = "header", required = true)
	})
	@ApiOperation(value = "修改订单信息", notes = "修改订单信息")
	@PostMapping("updateOrderAdmin")
	public Object updateOrderAdmin(
			String id,String sendStatus) {
		return orderAdminService.updateOrderAdmin(id,sendStatus);
	}
	
	/**
	 * 删除订单
	 * authod lujingdong
	 * 2019年12月1日
	 * @param orderAdminDto
	 * @return
	 */
	@ApiImplicitParams({
		@ApiImplicitParam(name = "userTicket", value = "用户凭证", paramType = "query", required = true),
		@ApiImplicitParam(name = "id", value = "订单", paramType = "header", required = true)
	})
	@ApiOperation(value = "删除订单", notes = "删除订单")
	@PostMapping("deleteOrderAdmin")
	public Object deleteOrderAdmin(
			String id) {
		return orderAdminService.deleteOrderAdmin(id);
	}
	
	/**
	 * 订单详情
	 * authod lujingdong
	 * 2019年12月1日
	 * @param orderAdminDto
	 * @return
	 */
	@ApiImplicitParams({
		@ApiImplicitParam(name = "userTicket", value = "用户凭证", paramType = "header", required = true),
		@ApiImplicitParam(name = "id", value = "订单id", paramType = "query", required = true)
	})
	@ApiOperation(value = "订单详情(管理端、用户端)", notes = "订单详情")
	@PostMapping("findOrderDetailById")
	public Object findOrderDetailById(
			String id) {
		return orderAdminService.findOrderDetailById(id);
	}
	
}
