package cn.jzdy.service.impl;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import cn.jzdy.dao.UserOrderMapper;
import cn.jzdy.pojo.Order;
import cn.jzdy.response.ErrorResult;
import cn.jzdy.response.SuccessResult;
import cn.jzdy.service.UserOrderService;
import cn.jzdy.util.id.UuidUtils;


@Service
@Transactional(rollbackFor = Exception.class)
public class UserOrderServiceImpl implements UserOrderService{

	@Autowired
	private UserOrderMapper userOrderMapper;
	
	@Override
	public Object selectUserOrder(String userId) {
		//判断是否存在此用户
		Integer count = userOrderMapper.selectUserByUserId(userId);
		if(count == 0) {
			return new ErrorResult<>("不存在此用户");
		}
		List<Map<String, Object>>  data = userOrderMapper.selectOrderByUserId(userId);
		return new SuccessResult<>(data);
	}
	/**
	 * 
	* @author:yiwu
	* @Description: 增加用户订单
	* @param order
	* @return
	 */
	@Override
	public Object addUserOrder(Order order) {
		String userId = order.getUserId();
	    Integer count = userOrderMapper.selectUserByUserId(userId);
	    if(count != 1) {
	    	return new ErrorResult<>("不存在此用户");
	    } 
	    //根据用户id和carId判断  是否已存在此订单
	    Map<String, Object> data = userOrderMapper.existOrder(order.getUserId(),order.getCarId());
	    if(Integer.valueOf(data.get("result").toString()) == 1) {
	    	//获取订单数量
	    	Integer num = Integer.valueOf(data.get("number").toString());
	    	num = num + Integer.valueOf(order.getNumber());
	    	String id = data.get("id").toString();
	    	//根据id 和 num 修改
	    	userOrderMapper.updateOrder(id,num);
	    	return new SuccessResult<>("新增用户订单成功。。");
	    	
	    }
	    //根据carId查询车子单价
	    Map<String, Object> map= userOrderMapper.selectCarPriceByCarId(order.getCarId());
	    if(StringUtils.isEmpty(map)) {
	    	return new ErrorResult<>("不存在此车子的id");
	    }
	    double min = Double.parseDouble(map.get("min").toString());
	    double max = Double.parseDouble(map.get("max").toString());
	    Double total = (min+max)/2;
	    order.setTotalMoney(String.valueOf(total));
	    order.setSendStatus(0);
	    order.setId(UuidUtils.getUuid());
	    userOrderMapper.addUserOrder(order);
		return new SuccessResult<>("新增用户订单成功。。嘻嘻嘻");
	}
	
}
