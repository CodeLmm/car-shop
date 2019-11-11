package cn.jzdy.service.impl;



import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import cn.jzdy.service.RedisService;
/**
 * redis服务
 * Lujingdong
 * 2019年11月11日
 */
@Service
public class RedisServiceImpl implements RedisService{
	@Resource
    private RedisTemplate<String, Object> redisTemplate;
	
	/**
	 * 添加
	 * 
	 * @author chenwei
	 * @date 2019年7月2日 上午10:22:11
	 * @param key
	 * @param value
	 * @return
	 */
	@SuppressWarnings("all")
	@Override
    public boolean set(final String key, Object value) {
        boolean result = false;
    	ValueOperations<String, Object> operations = redisTemplate.opsForValue();
    	operations.set(key, value);
    	return true;
    }
	/**
	 * 添加带生命周期
	 */
	@Override
    public boolean set(final String key, Object value, Long expireTime) {
        boolean result = false;
        ValueOperations<String, Object> operations = redisTemplate.opsForValue();
        operations.set(key, value, expireTime, TimeUnit.SECONDS);
        result = true;
        return result;
    }
	/**
	 * 获取
	 */
	@Override
	public Object get(final String key) {
		ValueOperations<String, Object> operations = redisTemplate.opsForValue();
		return operations.get(key);
	}
	/**
	 * 删除
	 */
	@Override
	@SuppressWarnings("all")
    public void delete(final String key) {
		redisTemplate.delete(key);
    }
}
