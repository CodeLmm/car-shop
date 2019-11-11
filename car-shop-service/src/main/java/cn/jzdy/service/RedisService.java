package cn.jzdy.service;



/**
 * redis服务
 * Lujingdong
 * 2019年11月11日
 */
public interface RedisService {
	/**
	 * 添加
	 * 
	 * @author chenwei
	 * @date 2019年7月2日 上午10:40:56
	 * @param key
	 * @param value
	 * @return
	 */
	boolean set(final String key, Object value);
	/**
	 * 添加 有生命周期
	 * 
	 * @author chenwei
	 * @date 2019年7月2日 上午10:41:47
	 * @param key
	 * @param value
	 * @param expireTime
	 * @return
	 */
	boolean set(final String key, Object value, Long expireTime);
	/**
	 * 获取
	 * 
	 * @author chenwei
	 * @date 2019年7月2日 上午11:25:24
	 * @param key
	 * @return
	 */
	Object get(String key);
	/**
	 * 删除
	 * 
	 * @author chenwei
	 * @date 2019年7月2日 上午11:37:08
	 * @param key
	 */
	void delete(final String key);
}
