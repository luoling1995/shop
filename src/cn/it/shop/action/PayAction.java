package cn.it.shop.action;

import java.util.Map;

import org.apache.struts2.interceptor.ParameterAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.it.shop.model.BackData;
import cn.it.shop.model.Forder;
import cn.it.shop.model.SendData;
import cn.it.shop.model.User;

@Controller
@Scope("prototype")
public class PayAction extends BaseAction<Object> implements ParameterAware{
	private Map<String,String[]> parameters;
	
	@Override
	public Object getModel() {
		if(parameters.get("pd_FrpId") != null){
			model = new SendData();
		}else{
			model = new BackData();
		}
		return model;
	}
	
	public String goBank(){
		//1.补全参数p2,p3,pa,需要从session中获取
		SendData sendData = (SendData) model;
		Forder forder = (Forder) session.get("oldForder");
		User user = (User) session.get("user");
		sendData.setP2_Order(forder.getId().toString());
		sendData.setP3_Amt(String.valueOf(forder.getTotal()));
		sendData.setPa_MP(user.getEmail() + "," + user.getPhone());
		//2.对参数进行追加
		//3.加密获取签名
		//4.存储到request中
		payService.saveDataToRequest(request, sendData);
		//5.跳转到支付页面
		return "pay";
	}
	
	public void backBank(){
		BackData backData = (BackData) model;
		boolean ok = payService.checkBackData(backData);
		if(ok){
			forderService.updateStatusById(Integer.parseInt(backData.getR6_Order()), 2);
			String address = backData.getR8_MP().split(",")[0];
			emailUtil.sendEmail(address, backData.getR6_Order());
			String phoneNumber = backData.getR8_MP().split(",")[1];
			messageUtil.sendMessage(phoneNumber, backData.getR6_Order());
			System.out.println("---success----");
		}else{
			System.out.println("-----fail-----");
		}
	}

	@Override
	public void setParameters(Map<String, String[]> parameters) {
		// TODO Auto-generated method stub
		this.parameters = parameters;
	}

}
