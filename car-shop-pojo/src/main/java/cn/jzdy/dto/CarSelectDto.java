package cn.jzdy.dto;

public class CarSelectDto extends CommonSelectDto {
	private String name;
	private String carBrand;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCarBrand() {
		return carBrand;
	}
	public void setCarBrand(String carBrand) {
		this.carBrand = carBrand;
	}
	
}
