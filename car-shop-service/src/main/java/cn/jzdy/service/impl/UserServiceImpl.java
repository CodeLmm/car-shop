package cn.jzdy.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.jzdy.dao.PermissionMapper;
import cn.jzdy.dao.RoleMapper;
import cn.jzdy.dao.UserMapper;
import cn.jzdy.login.LoginUser;
import cn.jzdy.pojo.Permission;
import cn.jzdy.pojo.Role;
import cn.jzdy.pojo.User;
import cn.jzdy.response.ErrorResult;
import cn.jzdy.response.SuccessResult;
import cn.jzdy.service.RedisService;
import cn.jzdy.service.UserServie;
import cn.jzdy.util.MD5Util;
import cn.jzdy.util.id.UuidUtils;
@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserServie {
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private RoleMapper roleMapper;
	@Autowired
	private PermissionMapper permissionMapper;
	@Autowired
	private RedisService redisService;
	/**
	 * 用户登陆
	 * authod lujingdong
	 * 2019年11月16日
	 * @param username
	 * @param password
	 * @return
	 */
	@Override
	public Object login(String username, String password) {
		Object checkResult = checkLoginParam(username,password);
		if(checkResult!=null) {
			return checkResult;
		}
		//还没进行mp5加密
		String passwordMd5 = MD5Util.digest(password);
		User user = userMapper.findUserByUsernameAndPassword(username,passwordMd5);
		String ticket = null;
		LoginUser loginUser = null;
		if(user!=null) {
			List<Role> roleList = roleMapper.finRoleByUserId(user.getId());
			List<Permission> permissionList = permissionMapper.findPermissionByUserId(user.getId());
			loginUser = new LoginUser();
			loginUser.setUser(user);
			loginUser.setRoleList(roleList);
			loginUser.setPermissionList(permissionList);
			ticket = "car:"+UuidUtils.getUuid();
			//将值保存在redis  604800L
			redisService.set(ticket, loginUser, 604800L);
		}else {
			return new ErrorResult<>("账号或者密码有误", "账号或者密码有误");
		}
		Map<String,Object> userTicket = new HashMap<>();
		userTicket.put("userTicket", ticket);
		return new SuccessResult<>("登陆成功",ticket,"跳转到主页面");
	}

	private Object checkLoginParam(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

}
