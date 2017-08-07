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
	
	//ʵ�ֹ��ﳵ�붩��������
	public String save(){
//		//��ȡsession�еĹ�����,����model����
//		Forder forder = (Forder) session.get("forder");
//		model.setSorderSet(forder.getSorderSet());
//		//������⣨��Ҫ��xml�����ã�����sorderserviceimpl�н���sorder.setForder(forder);
//		forderService.save(model);
		
		model.setUser((User)session.get("user"));
		model.setStatus(new Status(1));
		forderService.save(model);
		
		session.put("oldForder", session.get("forder"));
		session.put("forder", new Forder());
		return "bank";
	}
}
