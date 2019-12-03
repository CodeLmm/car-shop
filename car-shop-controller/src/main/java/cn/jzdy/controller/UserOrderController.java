package cn.jzdy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.jzdy.pojo.Order;
import cn.jzdy.response.ErrorResult;
import cn.jzdy.service.UserOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "用户订单模块")
@RestController
@RequestMapping("userOrder")
public class UserOrderController {
	
	@Autowired
	private UserOrderService userOrderService;
	
	@ApiOperation(value = "查询用户订单", notes = "查询用户列订单")
	@PostMapping("selectUserOrder")
	@ApiImplicitParams({
		  @ApiImplicitParam(name = "userTicket", value = "用户凭证", paramType = "header", required = true)
		 })
	public Object selectUserOrder(String userId) {
		if(StringUtils.isEmpty(userId)) {
			return new ErrorResult<>("userId is null");
		}
		return userOrderService.selectUserOrder(userId);
	}
	
	@ApiOperation(value = "增加用户订单", notes = "增加用户列订单")
	@PostMapping("addUserOrder")
	@ApiImplicitParams({
		  @ApiImplicitParam(name = "userTicket", value = "用户凭证", paramType = "header", required = true)
		 })
	public Object addUserOrder(@RequestBody 
		@ApiParam(name = "userDto", value = "页面传来的参数实体", required = true)
		Order order) {
			if (StringUtils.isEmpty(order)) {
				return new ErrorResult<>("order is null");
			}
		return userOrderService.addUserOrder(order);
	}

}
