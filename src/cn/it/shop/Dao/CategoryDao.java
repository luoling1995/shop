package cn.it.shop.Dao;
 
import java.util.List;

import cn.it.shop.model.Category;

public interface CategoryDao extends BaseDao<Category>{
	public List<Category> queryJoinAccount(String type,int page,int size);
	//���ݹؼ��ֲ�ѯ�ܼ�¼��
	public long getCount(String type);
	//����idsɾ��������¼
	public void deleteByIds(String ids);
	
	public List<Category> queryByHot(boolean hot);
}
 