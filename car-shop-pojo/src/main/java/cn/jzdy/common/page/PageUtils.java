package cn.jzdy.common.page;


/**
 * 分页工具
 * @author chenwei
 * @date 2018年4月24日 下午9:39:24
 */
public final class PageUtils {
	/**
	 * 初始化起始页数
	 * 
	 * @author chenwei
	 * @date 2018年4月24日 下午9:41:26
	 * @param pageStart
	 * @return
	 */
	public static long initialPageStart(Long pageStart) {
		if(pageStart==null||pageStart<=0) {
			pageStart=1L;
		}
		return pageStart;
	}
	/**
	 * 初始化每页显示数量
	 * 
	 * @author chenwei
	 * @date 2018年4月24日 下午9:41:52
	 * @param pageTotal
	 * @return
	 */
	public static long initialPageTotal(Long pageTotal) {
		if(pageTotal==null||pageTotal<=0) {
			pageTotal=10L;
		}
		return pageTotal;
	}
	/**
	 * 初始化每页显示数量,自动计算上限或下限
	 * 
	 * @author chenwei
	 * @date 2018年4月24日 下午9:41:52
	 * @param pageTotal
	 * @return
	 */
	public static long packagePageTotal(Long pageTotal,long valueMin,long valueMax) {
		if(valueMin < 0 || valueMin > valueMax) {
			valueMin = 5L;
		}
		if(valueMax < 0 || valueMax < valueMin) {
			valueMax = 10L;
		}
		if(pageTotal==null||pageTotal<valueMin) {
			pageTotal=5L;
		}
		if(pageTotal==null||pageTotal>valueMax) {
			pageTotal=10L;
		}
		return pageTotal;
	}
	/**
	 * 计算起始页在sql分页中的起始值
	 * 
	 * @author chenwei
	 * @date 2018年4月24日 下午9:42:46
	 * @param pageStart
	 * @param pageTotal
	 * @return
	 */
	public static long countPageStart(long pageStart,long pageTotal) {
		return ((pageStart-1)*pageTotal);
	}
	
}
