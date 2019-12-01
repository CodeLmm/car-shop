package cn.jzdy.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import cn.jzdy.dao.PermissionMapper;
import cn.jzdy.dao.RoleMapper;
import cn.jzdy.dao.UserMapper;
import cn.jzdy.login.LoginUser;
import cn.jzdy.pojo.Permission;
import cn.jzdy.pojo.Role;
import cn.jzdy.pojo.User;
import cn.jzdy.request_param.UserParam;
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
		//通过用户名  密码查找用户
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

	/**
	 * 	用户注册
	* @author:yiwu
	* @Description:
	* @param userParam  用户参数
	* @return
	 */
	@Override
	public Object register(UserParam userParam) {
		//数据校验
		Object checkResult =  checkregisterParam(userParam);
		if(checkResult != null) {
			return checkResult;
		}
		
		String phone = userParam.getPhone();
		int count = userMapper.isUser(phone);
		if(count > 0) {
			return new ErrorResult<>("用户已注册过的", "您已注册过，请登陆", "denglu");
		}
		
		User user = new User();
		user.setCreateTime(new Date());
		user.setId(UuidUtils.getUuid());
		user.setUsername(userParam.getUsername());
		String passwordMd5 = MD5Util.digest(userParam.getPassword());
		user.setPassword(passwordMd5);
		user.setMail(userParam.getMail());
		user.setPhone(phone);
		user.setStatus("1");
		user.setName(userParam.getName());
		user.setSex(userParam.getSex());
		user.setAge(userParam.getAge());
		user.setAddress(userParam.getAddress());
		user.setUpdateTime(new Date());
		
		userMapper.insertUserRegister(user);
		
		
		return new SuccessResult<>();
	}
	
	/**
	 * 	检查注册参数
	* @author:yiwu
	* @Description:
	* @param userParam  用户参数
	* @return    
	* Object:
	 */
	private Object checkregisterParam(UserParam user) {
		if (StringUtils.isEmpty (user.getUsername())) {
			return new ErrorResult<>("username is null", "请填写您的用户名");
		}
		if (StringUtils.isEmpty (user.getPassword())) {
			return new ErrorResult<>("password is null", "请填写您的密码");
		}
		if (StringUtils.isEmpty (user.getPhone())) {
			return new ErrorResult<>("phone is null", "请填写您的手机号码");
		}
		if (StringUtils.isEmpty (user.getMail())) {
			return new ErrorResult<>("email is null", "请填写您的邮箱");
		}
		if (StringUtils.isEmpty (user.getName())) {
			return new ErrorResult<>("name is null", "请填写您的姓名");
		}
		if (StringUtils.isEmpty (user.getSex())) {
			return new ErrorResult<>("sex is null", "请填写您的性别");
		}
		if (StringUtils.isEmpty (user.getAge())) {
			return new ErrorResult<>("age is null", "请填写您的年龄");
		}
		if (StringUtils.isEmpty (user.getAddress())) {
			return new ErrorResult<>("address is null", "请填写您的地址");
		}
		return null;
	}
	
}
