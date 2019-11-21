package cn.jzdy.dto;



import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;

import cn.jzdy.common.page.PageResponse;
import cn.jzdy.common.page.PageUtils;
import io.swagger.annotations.ApiModelProperty;

public class CommonSelectDto {
	
	@JsonIgnore
	@ApiModelProperty(name = "fastdfsUrl", hidden=true)
	private String fastdfsUrl;
	@JsonIgnore
	@ApiModelProperty(name = "keys", hidden=true)
	private List<String> keys;
	/**
	 * 分页查询条件
	 */
	@ApiModelProperty(value = "起始页", name = "pageStart", example = "0", required = false)
	private Long pageStart;
	/**
	 * 分页查询条件
	 */
	@ApiModelProperty(value = "页面条数", name = "pageTotal", example = "10", required = false)
	private Long pageTotal;
	/**	
	 * 记录的起始项
	 */
	@JsonIgnore
	@ApiModelProperty(name = "countPageStart", hidden=true)
	private Long countPageStart;
	

	/**
	 * 记录总数
	 */
	@JsonIgnore
	private Long pageCount;

	/**
	 * 数据集
	 */
	@JsonIgnore
	@ApiModelProperty(name = "data", hidden=true)
	private List<Map<String, Object>> data;
	@JsonIgnore
	@ApiModelProperty(name = "pageResponse", hidden=true)
	private PageResponse pageResponse;

	public PageResponse getPageResponse() {
		return this.pageResponse;
	}

	public void setPageResponse(PageResponse pageResponse) {
		this.pageResponse = pageResponse;
	}

	public Long getPageStart() {
		return pageStart;
	}

	public void setPageStart(Long pageStart) {
		this.pageStart = pageStart;
	}

	public Long getPageTotal() {
		return pageTotal;
	}

	public void setPageTotal(Long pageTotal) {
		this.pageTotal = pageTotal;
	}

	public Long getCountPageStart() {
		return countPageStart;
	}

	public void setCountPageStart(Long countPageStart) {
		this.countPageStart = countPageStart;
	}

	public Long getPageCount() {
		return pageCount;
	}

	public void setPageCount(Long pageCount) {
		this.pageCount = pageCount;
	}


	public void setData(List<Map<String, Object>> data) {
		this.data = data;
	}
	
	
	
	public List<Map<String, Object>> getData() {
		return data;
	}

	/**
	 * 初始化分页查询条件
	 * @author helo
	 * @date 2019年8月20日下午3:49:43
	 */
	public void init() {
		this.setPageStart(PageUtils.initialPageStart(this.getPageStart()));
		this.setPageTotal(PageUtils.initialPageTotal(this.getPageTotal()));
		this.setCountPageStart(PageUtils.countPageStart(this.getPageStart(), this.getPageTotal()));
	}

	/**
	 * 返回分页数据
	 * @author helo
	 * @date 2019年8月20日下午4:04:33
	 * @param data
	 * @return
	 */
	public Object pageResponse(List<Map<String, Object>> data, Long pageCount) {
		this.setData(data);
		this.setPageCount(pageCount);
		return  new  PageResponse(this.getPageStart(), this.getPageTotal(), this.getPageCount(), this.getData());
	}
	
	
	
	public List<String> getKeys() {
		return keys;
	}

	public void setKeys(List<String> keys) {
		this.keys = keys;
	}

	public String getFastdfsUrl() {
		return fastdfsUrl;
	}

	public void setFastdfsUrl(String fastdfsUrl) {
		this.fastdfsUrl = fastdfsUrl;
	}

}
