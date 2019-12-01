package cn.jzdy.request_param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "汽车参数实体")
public class CarParam {
	@ApiModelProperty(name = "id", value = "添加商品时不用填入")
    private String id;
	@ApiModelProperty(name = "discounts", value = "降价优惠/单位万元")
    private String discounts;
	@ApiModelProperty(name = "dealerQuotation", value = "经销商报价/单位元")
    private String dealerQuotation;
	@ApiModelProperty(name = "guidePrice", value = "厂商指导价/单位万元")
    private String guidePrice;
	@ApiModelProperty(name = "dispalcement", value = "排量/单位L")
    private String dispalcement;
	@ApiModelProperty(name = "oilWear", value = "油耗/单位L")
    private String oilWear;
	@ApiModelProperty(name = "imgUrl", value = "图片地址",hidden = true)
    private String imgUrl;
	@ApiModelProperty(name = "lever", value = "级别/比如微型车")
    private String lever;
	@ApiModelProperty(name = "secondHandPice", value = "二手价/单位万元")
    private String secondHandPice;
	@ApiModelProperty(name = "inventory", value = "库存量")
    private String inventory;
	@ApiModelProperty(name = "carBrandKey", value = "品牌/对应字典表的CAR_BRAND")
    private String carBrandKey;
	@ApiModelProperty(name = "hot", value = "1是热门/0不是热门")
    private Integer hot;
	@ApiModelProperty(name = "name", value = "商品名称")
	private String name;
	@ApiModelProperty(name = "status", value = "1=可用/0=不可用")
	private Integer status;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getDiscounts() {
		return discounts;
	}

	public void setDiscounts(String discounts) {
		this.discounts = discounts;
	}

	public String getDealerQuotation() {
		return dealerQuotation;
	}

	public void setDealerQuotation(String dealerQuotation) {
		this.dealerQuotation = dealerQuotation;
	}

	public String getGuidePrice() {
		return guidePrice;
	}

	public void setGuidePrice(String guidePrice) {
		this.guidePrice = guidePrice;
	}

	public String getDispalcement() {
		return dispalcement;
	}

	public void setDispalcement(String dispalcement) {
		this.dispalcement = dispalcement;
	}

	public String getOilWear() {
		return oilWear;
	}

	public void setOilWear(String oilWear) {
		this.oilWear = oilWear;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getLever() {
		return lever;
	}

	public void setLever(String lever) {
		this.lever = lever;
	}

	public String getSecondHandPice() {
		return secondHandPice;
	}

	public void setSecondHandPice(String secondHandPice) {
		this.secondHandPice = secondHandPice;
	}

	public String getInventory() {
		return inventory;
	}

	public void setInventory(String inventory) {
		this.inventory = inventory;
	}

	public String getCarBrandKey() {
		return carBrandKey;
	}

	public void setCarBrandKey(String carBrandKey) {
		this.carBrandKey = carBrandKey;
	}

	public Integer getHot() {
		return hot;
	}

	public void setHot(Integer hot) {
		this.hot = hot;
	}
	    
	    
}
