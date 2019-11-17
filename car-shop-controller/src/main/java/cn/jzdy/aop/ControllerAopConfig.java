package cn.jzdy.aop;



import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.jzdy.service.aop.BaseAopService;


/**
 *  controller面向切面配置
 * @author chenWei
 * @date 2019年10月14日 上午11:10:24
 *
 */
@Aspect
@Component
public class ControllerAopConfig {
	/**
	 * 指定切入的路径
	 */
	@Pointcut("execution(public * cn.jzdy.controller..*.*(..))")
	public void controllerAop() {
	}

	@Autowired
	private BaseAopService baseAopService;
	
	/**
	 * 执行方法之前切入
	 * @param joinPoint
	 * @throws Exception
	 */
	@Before("controllerAop()")
	public void doBefore(JoinPoint joinPoint) throws Exception {
		baseAopService.filterJpa(joinPoint);
	}
	
	
	
}
