package cn.jzdy.util;
public class StringUtil {
	/**
	 * 	返回true  证明是空  或者 ""
	 * @param s
	 * @return
	 */
	public static boolean isEmpty(String s) {
		return s == null ||"".equals(s);
	}
	
	/**	
	 * 	判断 不等于空 
	 * 	返回false  证明是  null  或者  ""(空字符串)
	 * @param s
	 * @return
	 */
	public static boolean isNotEmpty(String s) {
		return !isEmpty(s);
	}
}
