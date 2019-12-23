package cn.jzdy.service;

import cn.jzdy.request_param.UserParam;

public interface UserServie {
	/**
	 * 用户登陆
	 * authod lujingdong
	 * 2019年11月16日
	 * @param username
	 * @param password
	 * @return
	 */
	Object login(String username, String password);
	
	/**
	 * 	用户注册
	* @author:yiwu
	* @Description:
	* @param userParam   用户参数
	* @return    
	* Object:
	 */
	 Object register(UserParam user);
	 
	 /**
	  * 个人中心
	 * @author:yiwu
	 * @Description:
	 * @param userid
	 * @return    
	 * Object:
	  */
	Object personalCenter(UserParam userParam);

}
