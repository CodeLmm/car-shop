package cn.jzdy.response;



import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 响应数据封装接口
 * 
 * @author chenwei
 * @date 2019年7月3日 上午11:10:32
 */
@ApiModel(description="标准数据响应模型")
public class Result<T> implements Serializable{
	private static final long serialVersionUID = 5334354423432009056L;
	/**成功*/
	public static final String SUCCESS = "success";
	/**失败*/
	public static final String ERROR = "error";
	/**登录页面标记*/
	public static final String LOGIN_JUMP = "login";
	/**首页标记*/
	public static final String INDEX_JUMP = "index";
	/**用户页面标记*/
	public static final String USER_JUMP = "user";
	/**订单页面标记*/
	public static final String ORDER_JUMP = "order";
	/**404页面*/
	public static final String NOT_FOUND = "404";
	@ApiModelProperty(
			"响应状态(只有两个状态success/error)")
	private String status;
	@ApiModelProperty(
			"弹窗消息(没有数据则不需要弹窗)")
	private String message;
	@ApiModelProperty(
			"跳转标记(login=登录页面,index=首页,user=用户页面,order=订单页面)")
	private String jump;
	@ApiModelProperty(
			"业务数据结果<font style='color:red'>会出现多种状态(数组/键值对)</font>")
	private T result;
	@ApiModelProperty(
			"错误原因(用于查看错误原因,没有业务价值)")
	private String target;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getJump() {
		return jump;
	}

	public void setJump(String jump) {
		this.jump = jump;
	}

	public T getResult() {
		return result;
	}

	public void setResult(T result) {
		this.result = result;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
