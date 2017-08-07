package cn.it.shop.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.it.shop.model.Forder;
import cn.it.shop.model.Status;
import cn.it.shop.model.User;

@Controller
@Scope("prototype")
public class ForderAction extends BaseAction<Forder> {
	
	@Override
	public Forder getModel() {
		model = (Forder) session.get("forder");
		return model;
	}
	
	//实现购物车与订单项级联入库
	public String save(){
//		//获取session中的购物项,交给model对象
//		Forder forder = (Forder) session.get("forder");
//		model.setSorderSet(forder.getSorderSet());
//		//级联入库（需要在xml中配置），在sorderserviceimpl中进行sorder.setForder(forder);
//		forderService.save(model);
		
		model.setUser((User)session.get("user"));
		model.setStatus(new Status(1));
		forderService.save(model);
		
		session.put("oldForder", session.get("forder"));
		session.put("forder", new Forder());
		return "bank";
	}
}
