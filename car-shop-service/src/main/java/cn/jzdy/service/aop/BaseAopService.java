package cn.jzdy.service.aop;



import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import cn.jzdy.annotation.aop.NoCheckOnline;
import cn.jzdy.exception.OnlineException;
import cn.jzdy.login.LoginUser;
import cn.jzdy.service.RedisService;

/**
 * aop
 * Lujingdong
 * 2019年11月16日
 */
@Service
public class BaseAopService {
	@Autowired
	private RedisService redisService;
	/**
	 * 过滤注解,根据注解处理业务
	 * @param joinPoint
	 * @throws Exception
	 */
	public void filterJpa(JoinPoint joinPoint) throws Exception  {
		// 接收到请求，记录请求内容
		ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes();
		HttpServletRequest request = requestAttributes.getRequest();
		Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
		NoCheckOnline annotation = method.getAnnotation(NoCheckOnline.class);
		if(annotation == null) {
			String ticket = request.getHeader("userTicket");
			if(StringUtils.isEmpty(ticket)) {
				throw new OnlineException("登录失效~");
			}
			
			//使用redis客户端获取ticket的值
			Object userObj = redisService.get(ticket);
			//null
			if(userObj == null) {
				throw new OnlineException("登录失效~");
			}
			//有值
			//将用户json数据转换位用户对象
			if(!(userObj instanceof LoginUser)) {
				throw new OnlineException("登录失效~");
			}
			LoginUser user = (LoginUser)userObj;
			request.setAttribute("userTicket", user);
		}
	}

}
