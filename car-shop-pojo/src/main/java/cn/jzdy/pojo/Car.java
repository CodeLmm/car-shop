package cn.jzdy.pojo;

public class Car {
    private String id;

    private String discounts;

    private String dealerQuotation;

    private String guidePrice;

    private String dispalcement;

    private String oilWear;

    private String imgUrl;

    private String lever;

    private String secondHandPice;

    private String inventory;

    private String carBrand;

    private String carType;

    private String cartId;

    private Integer hot;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getDiscounts() {
        return discounts;
    }

    public void setDiscounts(String discounts) {
        this.discounts = discounts == null ? null : discounts.trim();
    }

    public String getDealerQuotation() {
        return dealerQuotation;
    }

    public void setDealerQuotation(String dealerQuotation) {
        this.dealerQuotation = dealerQuotation == null ? null : dealerQuotation.trim();
    }

    public String getGuidePrice() {
        return guidePrice;
    }

    public void setGuidePrice(String guidePrice) {
        this.guidePrice = guidePrice == null ? null : guidePrice.trim();
    }

    public String getDispalcement() {
        return dispalcement;
    }

    public void setDispalcement(String dispalcement) {
        this.dispalcement = dispalcement == null ? null : dispalcement.trim();
    }

    public String getOilWear() {
        return oilWear;
    }

    public void setOilWear(String oilWear) {
        this.oilWear = oilWear == null ? null : oilWear.trim();
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }

    public String getLever() {
        return lever;
    }

    public void setLever(String lever) {
        this.lever = lever == null ? null : lever.trim();
    }

    public String getSecondHandPice() {
        return secondHandPice;
    }

    public void setSecondHandPice(String secondHandPice) {
        this.secondHandPice = secondHandPice == null ? null : secondHandPice.trim();
    }

    public String getInventory() {
        return inventory;
    }

    public void setInventory(String inventory) {
        this.inventory = inventory == null ? null : inventory.trim();
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand == null ? null : carBrand.trim();
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType == null ? null : carType.trim();
    }

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId == null ? null : cartId.trim();
    }

    public Integer getHot() {
        return hot;
    }

    public void setHot(Integer hot) {
        this.hot = hot;
    }
}