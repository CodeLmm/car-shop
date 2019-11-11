package cn.jzdy.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理器
 * Lujingdong
 * 2019年11月11日
 */
@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(value = Exception.class) //捕获异常
	@ResponseBody
	public Object defaultErrorHandler() {
		return "系统繁忙>>>>>>";
	}
}
