package cn.jzdy.response;



import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 成功响应
 * Lujingdong
 * 2019年11月16日
 * @param <T>
 */
@ApiModel(description = "成功响应数据模型")
public class SuccessResult<T> extends Result<T> {
	private static final long serialVersionUID = -5473999824351262859L;
	@ApiModelProperty("响应状态(success)")
	private String status = SUCCESS;

	/**
	 * 成功
	 */
	public SuccessResult() {
	}

	/**
	 * 成功+弹窗提示
	 * 
	 */
	public SuccessResult(String message) {
		setMessage(message);
	}

	/**
	 * 成功+弹窗提示+业务结果
	 * 
	 */
	public SuccessResult(String message, T result) {
		setMessage(message);
		setResult(result);
	}

	/**
	 * 成功+弹窗+页面跳转
	 * @param message
	 * @param jump
	 */
	public SuccessResult(String message, String jump) {
		setMessage(message);
		setJump(jump);
	}

	/**
	 * 成功+业务结果
	 * 
	 */
	public SuccessResult(T result) {
		setResult(result);
	}

	/**
	 * 成功+弹窗+页面跳转+业务结果
	 * @return 
	 * 
	 */
	public SuccessResult(String message, T result, String jump) {
		setMessage(message);
		setResult(result);
		setJump(jump);
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}