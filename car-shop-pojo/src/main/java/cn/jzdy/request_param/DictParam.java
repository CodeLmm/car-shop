package cn.jzdy.request_param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "字典参数实体")
public class DictParam {
	@ApiModelProperty(name = "id", value = "添加字典记录时不用填入")
	private String id;
	@ApiModelProperty(name = "key", value = "用于查询的标志", hidden = true)
    private String key;
	@ApiModelProperty(name = "sort", value = "字典类别")
    private String sort;
	@ApiModelProperty(name = "value", value = "字典记录的值")
    private String value;
	@ApiModelProperty(name = "imageUrl", value = "图片地址，需要时就要传入", hidden = true)
    private String imageUrl;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
}
