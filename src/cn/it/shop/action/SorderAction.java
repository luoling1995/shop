package cn.it.shop.action;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import cn.it.shop.model.Forder;
import cn.it.shop.model.Product;
import cn.it.shop.model.Sorder;

@Controller
@Scope("prototype")
public class SorderAction extends BaseAction<Sorder> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String updateSorder(){
		Forder forder = (Forder) session.get("forder");
		forder = sorderService.updateSorder(forder, model);
		forder.setTotal(forderService.cluTotal(forder));
		session.put("forder", forder);
		inputStream = new ByteArrayInputStream(String.valueOf(forder.getTotal()).getBytes());
		return "stream";
	}

	public String addSorder(){
		//1.����product.id��ȡ��Ӧ����Ʒ����
		Product product = productService.get(model.getProduct().getId());
		//2.�жϵ�ǰsession�Ƿ��й��ﳵ�����û���򴴽�
		if(session.get("forder") == null){
			//�������ﳵ���洢��session��
			session.put("forder", new Forder(new ArrayList<Sorder>()));
		}
		Forder forder = (Forder)session.get("forder");
		//3.����Ʒ��Ϣת��Ϊsorder��������ӵ����ﳵ�У��жϹ������Ƿ��ظ���
		forder = sorderService.addSorder(forder, product);
		//4.���㹺����ܼ۸�
		forder.setTotal(forderService.cluTotal(forder));
		//5.���µĹ��ﳵ��ӵ�session��
		session.put("forder", forder);
		return "showCar";
	}
	
	public String querySale(){
		List<Object> list = sorderService.querySale(model.getNumber());
		ActionContext.getContext().getValueStack().push(list);
		return "jsonList";
	}
}
