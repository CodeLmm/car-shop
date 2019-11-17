package cn.jzdy.util.id;


import java.util.UUID;

/**
 * uuid工具类
 * @author chenwei
 * @date 2019年7月3日 下午3:17:26
 */
public class UuidUtils {
	/**
	 * 获取uuid
	 * 
	 * @author chenwei
	 * @date 2019年7月3日 下午3:18:47
	 * @return
	 */
	public static String getUuid() {
		return UUID.randomUUID().toString().replaceAll("-","");
	}
}
