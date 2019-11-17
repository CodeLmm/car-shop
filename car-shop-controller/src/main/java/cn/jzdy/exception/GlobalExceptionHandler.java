package cn.jzdy.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	private final static Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	@ExceptionHandler(value = Exception.class) //捕获异常
	@ResponseBody
	public Object defaultErrorHandler(Exception e) {
		log.error("写出bug的人，都应该脱去枪毙掉",e);
		if(e instanceof OnlineException) {
			return e.getMessage();
		}
		return "系统繁忙>>>>>>";
	}
}
