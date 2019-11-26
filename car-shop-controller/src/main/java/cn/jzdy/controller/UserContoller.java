package cn.jzdy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.jzdy.annotation.aop.NoCheckOnline;
import cn.jzdy.login.LoginUser;
import cn.jzdy.request_param.UserParam;
import cn.jzdy.response.ErrorResult;
import cn.jzdy.response.SuccessResult;
import cn.jzdy.security.SecurityUser;
import cn.jzdy.service.UserServie;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
/**
 * 用户模块
 * Lujingdong
 * 2019年11月16日
 */
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
	@ApiOperation(value = "用户登陆", notes = "用户登陆")
	@NoCheckOnline
	@PostMapping("login")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "username", value = "用户名", paramType = "query"),
		@ApiImplicitParam(name = "password", value = "密码", paramType = "query"),
	})
	public Object login(String username,String password) {
		return userService.login(username,password);
	}
	/**
	 * 获取用户的信息
	 * authod lujingdong
	 * 2019年11月17日
	 * @return
	 */
	@ApiOperation(value = "获取用户的信息", notes = "获取用户的信息")
	@PostMapping("getUserMessage")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "userTicket", value = "用户凭证", paramType = "header", required = true)
	})
	public Object getUserMessage() {
		LoginUser loginUser = SecurityUser.getCurrentUser();
		return new SuccessResult<>(loginUser.getUser());
	}
	
	/**
	 *  用户注册
	* @author:yiwu
	* @Description:
	* @param userParam
	* @return    
	* Object:
	 */
	@SuppressWarnings("all")
	@NoCheckOnline
	@ApiOperation(value = "用户注册", notes = "用户注册")
	@PostMapping("register")
	public Object register(@RequestBody 
			@ApiParam(name="userParam",value="用户参数类型",required = true)
			UserParam userParam) {
		if(userParam == null) {
			return new ErrorResult("user is null");
		}
		return userService.register(userParam);
	}
	
}
