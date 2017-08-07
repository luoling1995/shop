package cn.it.shop.Dao;
 
import java.util.List;

import cn.it.shop.model.Product;

public interface ProductDao extends BaseDao<Product>{
	//��ѯ�����Ϣ����������Ա
	public List<Product> queryJoinCategory(String name,int page,int size);
	
	//���ݹؼ��ֲ�ѯ�ܼ�¼��
	public Long getCount(String name);
	
	//�����ȵ���𣬲�ѯ��ǰ����Ƽ���Ʒ��������ѯ4����
	public List<Product> queryByCid(int cid);
}
 