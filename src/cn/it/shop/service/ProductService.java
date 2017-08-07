package cn.it.shop.service;
 
import java.util.List;

import cn.it.shop.model.Product;

public interface ProductService extends BaseService<Product>{
	//��ѯ�����Ϣ����������Ա
	public List<Product> queryJoinCategory(String name,int page,int size);
	
	//���ݹؼ��ֲ�ѯ�ܼ�¼��
	public Long getCount(String name);
	
	//�����ȵ���𣬲�ѯ��ǰ����Ƽ���Ʒ��������ѯ4����
	public List<Product> queryByCid(int cid);
}
 