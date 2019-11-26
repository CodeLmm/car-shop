package cn.jzdy.message;



/**
 * 
 * @author helo
 * @date 2019年8月23日上午10:26:54
 */
public interface ResultMsg {
	/**系统繁忙,请稍后重试 */
	public final static String SYSTEM_ERROR = "系统繁忙,请稍后重试!";
	/** 添加成功*/
	public static final String ADD_SUCCESS = "添加成功";
	/** 修改成功*/
	public static final String UPDATE_SUCCESS = "修改成功";
	/** 删除成功*/
	public static final String DELETE_SUCCESS = "删除成功";
	/** 查询成功*/
	public static final String QUERY_SUCCESS = "查询成功";
	/** 添加失败*/
	public static final String ADD_ERROR = "添加失败";
	/** 修改失败*/
	public static final String UPDATE_ERROR = "修改失败";
	/** 删除失败*/
	public static final String DELETE_ERROR = "删除失败";
	/** 查询失败*/
	public static final String QUERY_ERROR = "查询失败";
	/** 导入成功*/
	public static final String IMPORT_SUCCESS = "导入成功";
	/** 导入失败*/
	public static final String IMPORT_ERROR = "导入失败";
	
}
