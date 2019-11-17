package cn.jzdy.response;



import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 错误结果
 * Lujingdong
 * 2019年11月16日
 * @param <T>
 */
@ApiModel(description = "错误响应数据模型")
public class ErrorResult<T> extends Result<T> {
	private static final long serialVersionUID = -3650134247254307280L;
	@ApiModelProperty("响应状态(error)")
	private String status = ERROR;

	/**
	 * 错误原因
	 * @param target
	 */
	public ErrorResult(String target) {
		setTarget(target);
	}

	/**
	 * 错误原因+弹窗提示
	 * @param target
	 * @param message
	 */
	public ErrorResult(String message, String target) {
		setTarget(target);
		setMessage(message);
	}

	/**
	 * 错误原因+弹窗提示+跳转标记
	 * @param target
	 * @param message
	 * @param jump
	 */
	public ErrorResult(String message, String target, String jump) {
		setTarget(target);
		setMessage(message);
		setJump(jump);
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
