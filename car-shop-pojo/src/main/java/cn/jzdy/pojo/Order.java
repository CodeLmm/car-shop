package cn.jzdy.pojo;

import io.swagger.annotations.ApiModelProperty;

public class Order {
    private String id;
    @ApiModelProperty(value="车Id",name="carId",required=true)
    private String carId;
    @ApiModelProperty(value="订单名称",name="name",required=true)
    private String name;
    @ApiModelProperty(value="用户id",name="userId",required=true)
    private String userId;
    @ApiModelProperty(value="订单号",name="orderNumber",required=true)
    private String orderNumber;
    @ApiModelProperty(value="收货人",name="consignee",required=true)
    private String consignee;
    @ApiModelProperty(value="收货人地址",name="address",required=true)
    private String address;
    @ApiModelProperty(value="收货人电话",name="phone",required=true)
    private String phone;
    @ApiModelProperty(value="数量",name="number",required=true)
    private String number;
    @ApiModelProperty(value="状态",name="0=没有发送，1=已发送",required=true)
    private Integer sendStatus;

    private String totalMoney;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId == null ? null : carId.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber == null ? null : orderNumber.trim();
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee == null ? null : consignee.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }

    public Integer getSendStatus() {
        return sendStatus;
    }

    public void setSendStatus(Integer sendStatus) {
        this.sendStatus = sendStatus;
    }

    public String getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(String totalMoney) {
        this.totalMoney = totalMoney == null ? null : totalMoney.trim();
    }
}