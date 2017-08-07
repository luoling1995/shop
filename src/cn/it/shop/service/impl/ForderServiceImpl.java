package cn.it.shop.service.impl;

import org.springframework.stereotype.Service;

import cn.it.shop.model.Forder;
import cn.it.shop.model.Sorder;
import cn.it.shop.service.ForderService;

@Service("forderService")
public class ForderServiceImpl extends BaseServiceImpl<Forder> implements ForderService {

	public ForderServiceImpl() {
		super(Forder.class);
	}
	
	@Override
	public double cluTotal(Forder forder) {
		double total = 0.0;
		for(Sorder temp : forder.getSorderList()){
			total += (temp.getPrice() * temp.getNumber());
		}
		return total;
	}

	@Override
	public void updateStatusById(int id, int sid) {
		forderDao.updateStatusById(id, sid);
	}

}
