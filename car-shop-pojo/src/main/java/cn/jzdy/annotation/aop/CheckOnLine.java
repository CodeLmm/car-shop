package cn.jzdy.annotation.aop;



import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 用户在线校验注解
 * Lujingdong
 * 2019年11月16日
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface CheckOnLine {
//	/**
//	 * 
//	 * @author helo
//	 * @date 2019年8月13日下午5:36:25
//	 * @return
//	 */
//	String value();
}
