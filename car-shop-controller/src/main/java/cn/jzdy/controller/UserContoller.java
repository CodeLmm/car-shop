package cn.jzdy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.jzdy.annotation.aop.NoCheckOnline;
import cn.jzdy.info.Dict;
import cn.jzdy.service.UserServie;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
/**
 * 用户模块
 * Lujingdong
 * 2019年11月16日
 */
import io.swagger.annotations.ApiImplicitParams;
@Api(tags = "用户模块")
@RestController
@RequestMapping("user")
public class UserContoller {
	@Autowired
	private UserServie userService;
	/**
	 * 登陆
	 * authod lujingdong
	 * 2019年11月16日
	 * @return
	 */
	@NoCheckOnline
	@PostMapping("login")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "username", value = "用户名", paramType = "query"),
		@ApiImplicitParam(name = "password", value = "密码", paramType = "query"),
	})
	public Object login(String username,String password) {
		return userService.login(username,password);
	}
}
