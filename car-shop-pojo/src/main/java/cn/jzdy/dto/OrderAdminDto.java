package cn.jzdy.dto;

import io.swagger.annotations.ApiModelProperty;

public class OrderAdminDto extends CommonSelectDto {
	//订单号
	@ApiModelProperty(value="订单号",name="orderNumber",required=true)
    private String orderNumber;
	//商品id
	@ApiModelProperty(value="车Id",name="carId",required=true)
    private String carId;
	//用户id
	@ApiModelProperty(value="用户id",name="userId",required=true)
    private String userId;
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public String getCarId() {
		return carId;
	}
	public void setCarId(String carId) {
		this.carId = carId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
}
