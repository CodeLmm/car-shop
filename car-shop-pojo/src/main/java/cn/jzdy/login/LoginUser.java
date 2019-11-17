package cn.jzdy.login;



import java.util.List;

import cn.jzdy.pojo.User;


/**
 * 登陆用户
 * Lujingdong
 * 2019年11月16日
 */
public class LoginUser{
	//private static final long serialVersionUID = -2233744623042413511L;
	private User user;
	private List<?> roleList;
	private List<?> permissionList;
	
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<?> getRoleList() {
		return roleList;
	}
	public void setRoleList(List<?> roleList) {
		this.roleList = roleList;
	}
	public List<?> getPermissionList() {
		return permissionList;
	}
	public void setPermissionList(List<?> permissionList) {
		this.permissionList = permissionList;
	}
	
	
}
