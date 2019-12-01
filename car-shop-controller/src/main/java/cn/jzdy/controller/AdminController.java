package cn.jzdy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.jzdy.annotation.aop.NoCheckOnline;
import cn.jzdy.dto.UserDto;
import cn.jzdy.request_param.UserParam;
import cn.jzdy.response.ErrorResult;
import cn.jzdy.service.AdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;


@Api(tags = "管理模块")
@RestController
@RequestMapping("admin")
public class AdminController {
	@Autowired
	private AdminService adminService;
	
	
	@NoCheckOnline
	@ApiOperation(value = "查询用户列表", notes = "查询用户列表")
	@PostMapping("countUserList")
	public Object countUserList(
			@RequestBody
			@ApiParam(name="userDto",value="页面传来的参数实体",required = true)UserDto userDto) {
			if (StringUtils.isEmpty(userDto)) {
				return new ErrorResult<>("userDto is null");
			}
		  Object countUserList = adminService.countUserList(userDto);
		  return countUserList;
	}
	
	public Object deleteUser(String userId) {
		if(StringUtils.isEmpty(userId)) {
			return new ErrorResult<>("userId is null");
		}
		return "";
	}
	
	@ApiOperation(value = "增加用户", notes = "增加用户")
	@PostMapping("addUser")
	@ApiImplicitParams({
		  @ApiImplicitParam(name = "userTicket", value = "用户凭证", paramType = "header", required = true)
		 })
	public Object addUser(
			@RequestBody
			@ApiParam(name="userDto",value="页面传来的参数实体",required = true)
				UserParam userParam) {
		
			if(StringUtils.isEmpty(userParam)) {
				return new ErrorResult<>("userParam is null");
			}
			return adminService.addUser(userParam);

	}
	
	@ApiOperation(value = "通过Id查询用户", notes = "通过Id查询用户")
	@PostMapping("selectUserByUserId")
	@ApiImplicitParams({
		  @ApiImplicitParam(name = "userTicket", value = "用户凭证", paramType = "header", required = true)
		 })
	public Object selectUserByUserId(
			@RequestBody
			@ApiParam(name="userId",value="用户Id",required = true)
				String userId)  {
		if(StringUtils.isEmpty(userId)) {
			return new ErrorResult<>("userId is null");
		}
		return adminService.selectUserByUserId(userId);
	}
	
	@ApiOperation(value = "修改用户", notes = "修改用户")
	@PostMapping("updateUser")
	@ApiImplicitParams({
		  @ApiImplicitParam(name = "userTicket", value = "用户凭证", paramType = "header", required = true)
		 })
	public Object updateUser( @RequestBody UserParam userParam , String userId) {
		if(StringUtils.isEmpty(userParam)) {
			new ErrorResult<>("userParam is null");
		}
		if(StringUtils.isEmpty(userId)) {
			new ErrorResult<>("userId is null");
		}
		return adminService.updateUser(userParam,userId);
	}
	

}
