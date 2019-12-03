package cn.jzdy.pojo;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

public class UserShoppingCart {  
    private String id;
    @ApiModelProperty(value="用户Id",name="userId",required=true)
    private String userId;
    @ApiModelProperty(value="数量",name="quantity",required=true)
    private String quantity;
    @ApiModelProperty(value="车子id",name="carId",required=true)
    private String carId;

    private Date createtime;

    private Date updatetime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity == null ? null : quantity.trim();
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId == null ? null : carId.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
}