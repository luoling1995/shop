package cn.it.shop.service;
 
import java.util.List;

import cn.it.shop.model.Category;

public interface CategoryService extends BaseService<Category>{
	public List<Category> queryJoinAccount(String type,int page,int size);
	//���ݹؼ��ֲ�ѯ�ܼ�¼��
	public long getCount(String type);
	//����idsɾ��������¼
	public void deleteByIds(String ids);
	
	public List<Category> queryByHot(boolean hot);
}
 