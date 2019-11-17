package cn.jzdy.security;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import cn.jzdy.exception.OnlineException;
import cn.jzdy.login.LoginUser;

/**
 * 权限用户
 * Lujingdong
 * 2019年11月17日
 */
@Component
public final class SecurityUser {
	/**
	 * 获取当前登录用户
	 * authod lujingdong
	 * 2019年11月17日
	 * @return
	 * @throws OffLineException
	 */
	public static LoginUser getCurrentUser() throws OnlineException {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		Object user = request.getAttribute("userTicket");
		if (user == null) {
			throw new OnlineException("用户不在线~");
		}
		return (LoginUser) user;
	}

	
}
