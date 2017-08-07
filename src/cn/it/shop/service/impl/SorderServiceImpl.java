package cn.it.shop.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.it.shop.model.Forder;
import cn.it.shop.model.Product;
import cn.it.shop.model.Sorder;
import cn.it.shop.service.SorderService;
import net.sf.json.JSONSerializer;

@Service("sorderService")
public class SorderServiceImpl extends BaseServiceImpl<Sorder> implements SorderService {

	@Override
	public Forder addSorder(Forder forder, Product product) {
		boolean isHave = false;
		Sorder sorder = productToSorder(product);
		//判断当前购物项是否重复，如果重复则添加数量即可
		for(Sorder old:forder.getSorderList()){
			if(old.getProduct().getId().equals(sorder.getProduct().getId())){
				//重复，直接添加数量
				old.setNumber(old.getNumber() + sorder.getNumber());
				isHave = true;
				break;
			}
		}
		//说明购物项不存在，则直接添加
		if(!isHave){
			//建立购物项与购物车之间的关系
			sorder.setForder(forder);
			forder.getSorderList().add(sorder);
		}
		return forder;
	}

	@Override
	public Sorder productToSorder(Product product) {
		Sorder sorder = new Sorder();
		sorder.setName(product.getName());
		sorder.setNumber(1);
		sorder.setPrice(product.getPrice());
		sorder.setProduct(product);
		return sorder;
	}

	@Override
	public Forder updateSorder(Forder forder, Sorder sorder) {
		for(Sorder temp:forder.getSorderList()){
			if(temp.getProduct().getId().equals(sorder.getProduct().getId())){
				temp.setNumber(sorder.getNumber());
			}
		}
		return forder;
	}

	@Override
	public List<Object> querySale(int number) {
		return sorderDao.querySale(number);
	}

	

}
