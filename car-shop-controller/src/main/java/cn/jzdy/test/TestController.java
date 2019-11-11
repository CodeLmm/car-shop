package cn.jzdy.test;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	@Autowired
	private TestDao testDao;
	@GetMapping("testMybatis")
	public Object testMybatis() {
		//int i =1/0;
		return testDao.testMybatis();
	}
}
