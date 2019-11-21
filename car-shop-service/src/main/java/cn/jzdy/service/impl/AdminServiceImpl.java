package cn.jzdy.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import cn.jzdy.dao.AdminMapper;
import cn.jzdy.dto.UserDto;
import cn.jzdy.response.SuccessResult;
import cn.jzdy.service.AdminService;


@Service
@Transactional(rollbackFor = Exception.class)
public class AdminServiceImpl implements AdminService{
	@Autowired
	private AdminMapper adminMapper;
	
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

}
