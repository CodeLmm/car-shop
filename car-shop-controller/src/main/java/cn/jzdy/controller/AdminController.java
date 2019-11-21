package cn.jzdy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import cn.jzdy.annotation.aop.NoCheckOnline;
import cn.jzdy.dto.UserDto;
import cn.jzdy.response.ErrorResult;
import cn.jzdy.service.AdminService;
import io.swagger.annotations.Api;
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

}
