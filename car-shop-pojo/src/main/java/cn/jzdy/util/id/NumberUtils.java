package cn.jzdy.util.id;



import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.util.StringUtils;



/**
 * 数字工具
 * @author chenwei
 * @date 2019年1月11日 下午4:11:05
 */
public final class NumberUtils {
	
	private static final String PREFIX = "OR"; 
	private static final String SERIAL_NUMBER = "SN"; 
	
	/**
	 * 获取订单号
	 * 
	 * @author chenwei
	 * @date 2019年1月11日 下午5:03:15
	 * @param prefix 前缀
	 * @param serialNumber 后缀
	 * @return
	 * @throws Exception
	 */
	public final synchronized static String getOrderNumber(String prefix,String serialNumber) throws Exception {
		if (!StringUtils.isEmpty(prefix)) {
			prefix = PREFIX;
		}
		if (!StringUtils.isEmpty(serialNumber)) {
			serialNumber = SERIAL_NUMBER;
		}
		Thread.sleep(1);
		//订单标记+年+月+日+流水号
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd,HHmmssSSS");
		String format = dateFormat.format(new Date());
		String[] split = format.split(",");
		return prefix + split[0] + serialNumber + split[1];
	}
	
}
