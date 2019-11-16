package cn.jzdy.test;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.jzdy.annotation.aop.CheckOnLine;
import cn.jzdy.service.RedisService;

@RestController
public class TestController {
	@Autowired
	private TestDao testDao;
	@GetMapping("testMybatis")
	public Object testMybatis() {
		//int i =1/0;
		return testDao.testMybatis();
	}
	@Autowired
	private RedisService redisService;
	@GetMapping("testRedis")
	public Object redis(String name) {
		redisService.set("username", name);
		return redisService.get("username"); 
	}
	@CheckOnLine
	@PostMapping("login")
	public Object checkOnlineTest() {
		return null;
	}
	
}
