package cn.it.shop.service;

import java.util.Map;

import cn.it.shop.model.BackData;
import cn.it.shop.model.SendData;

public interface PayService {

	// 把加密后的信息存储到requestMap中
	/* (non-Javadoc)
	 * @see cn.itcast.shop.service.impl.PayService#saveDataToRequest(java.util.Map, cn.itcast.shop.pojo.SendData)
	 */
	//	@Override
	Map<String, Object> saveDataToRequest(Map<String, Object> request, SendData sendData);
	
	boolean checkBackData(BackData backData);

}