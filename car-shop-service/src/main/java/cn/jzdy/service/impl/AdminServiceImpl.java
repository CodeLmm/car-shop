package cn.jzdy.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import cn.jzdy.dao.AdminMapper;
import cn.jzdy.dao.UserMapper;
import cn.jzdy.dto.UserDto;
import cn.jzdy.message.ResultMsg;
import cn.jzdy.pojo.User;
import cn.jzdy.request_param.UserParam;
import cn.jzdy.response.ErrorResult;
import cn.jzdy.response.SuccessResult;
import cn.jzdy.service.AdminService;
import cn.jzdy.util.MD5Util;
import cn.jzdy.util.id.UuidUtils;


@Service
@Transactional(rollbackFor = Exception.class)
public class AdminServiceImpl implements AdminService{
	@Autowired
	private AdminMapper adminMapper;
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public Object countUserList(UserDto userDto) {
		//初始化页的参数
		userDto.init();
		//查询总数
		Long count = adminMapper.countUser(userDto);
		//查询用户列表
		List<Map<String,Object>> userList = adminMapper.countUserList(userDto);
		return new SuccessResult<>(userDto.pageResponse(userList, count));


	}

	/**
	 * 
	 * @author:yiwu
	 * @Description: 用户删除
	 * @param userId
	 * @return
	 */
	@Override
	public Object deleteUser(String userId) {
		if (StringUtils.isEmpty(userId)) {
			return new ErrorResult<>("userId is null");
		}
		User user = adminMapper.selectUserByUserId(userId);
		if (StringUtils.isEmpty(user)) {
			return new ErrorResult<>("该用户不存在");
		}
		String status = user.getStatus();
		if (status.equals("1")) {
			// user.setStatus("2");
			// 更新数据
			adminMapper.updateStauts(userId);
			return new SuccessResult<>("删除成功");
		}
		//已是删除状态的用户  又点击删除  报系统繁忙
		return new ErrorResult<>(ResultMsg.SYSTEM_ERROR);
	}

	/**
	 * 
	 * @author:yiwu
	 * @Description: 添加用户
	 * @param userParam
	 * @return
	 */
	@Override
	public Object addUser(UserParam userParam) {
		// 数据校验
		Object checkResult = checkregisterParam(userParam);
		if (checkResult != null) {
			return checkResult;
		}
		String phone = userParam.getPhone();
		int count = userMapper.isUser(phone);
		if (count > 0) {
			return new ErrorResult<>("已存在此用户");
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

		return new SuccessResult<>(ResultMsg.ADD_SUCCESS);
	}

	/**
	 * 检查注册参数
	 * 
	 * @author:yiwu
	 * @Description:
	 * @param userParam 用户参数
	 * @return Object:
	 */
	private Object checkregisterParam(UserParam user) {
		if (StringUtils.isEmpty(user.getUsername())) {
			return new ErrorResult<>("username is null", "请填写您的用户名");
		}
		if (StringUtils.isEmpty(user.getPassword())) {
			return new ErrorResult<>("password is null", "请填写您的密码");
		}
		if (StringUtils.isEmpty(user.getPhone())) {
			return new ErrorResult<>("phone is null", "请填写您的手机号码");
		}
		if (StringUtils.isEmpty(user.getMail())) {
			return new ErrorResult<>("email is null", "请填写您的邮箱");
		}
		if (StringUtils.isEmpty(user.getName())) {
			return new ErrorResult<>("name is null", "请填写您的姓名");
		}
		if (StringUtils.isEmpty(user.getSex())) {
			return new ErrorResult<>("sex is null", "请填写您的性别");
		}
		if (StringUtils.isEmpty(user.getAge())) {
			return new ErrorResult<>("age is null", "请填写您的年龄");
		}
		if (StringUtils.isEmpty(user.getAddress())) {
			return new ErrorResult<>("address is null", "请填写您的地址");
		}
		return null;
	}

	@Override
	public Object selectUserByUserId(String userId) {
		User user = adminMapper.selectUserByUserId(userId);
		if (user == null) {
			return new ErrorResult<>("该用户不存在");
		}
		return new SuccessResult<>(user);

	}

	@Override
	public Object updateUser(UserParam userParam,String userId) {
		//数据校验
		Object checkResult = checkregisterParam(userParam);
		if (checkResult != null) {
			return checkResult;
		}
		String passwordMD = MD5Util.digest(userParam.getPassword());
		userParam.setPassword(passwordMD);
		User user = adminMapper.selectUserByUserId(userId);
		if (user == null) {
			return new ErrorResult<>("该用户不存在");
		}
		Integer count = adminMapper.updateUser(userParam,userId);
		return new SuccessResult<>(ResultMsg.UPDATE_SUCCESS);
	}


	
	
	
	

}











