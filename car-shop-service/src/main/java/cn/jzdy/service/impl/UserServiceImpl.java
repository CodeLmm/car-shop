package cn.jzdy.service.impl;

import java.util.List;

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
import cn.jzdy.service.UserServie;
@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserServie {
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private RoleMapper roleMapper;
	@Autowired
	private PermissionMapper permissionMapper;
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
		User user = userMapper.findUserByUsernameAndPassword(username,password);
		if(user!=null) {
			List<Role> roleList = roleMapper.finRoleByUserId(user.getId());
			List<Permission> permissionList = permissionMapper.findPermissionByUserId(user.getId());
			LoginUser loginUser = new LoginUser();
			loginUser.setUser(user);
			loginUser.setRoleList(roleList);
			loginUser.setPermissionList(permissionList);
			//
		}
		return user;
	}

	private Object checkLoginParam(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

}
