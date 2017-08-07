package cn.it.shop.Dao;
 
import java.util.List;

import cn.it.shop.model.Category;

public interface CategoryDao extends BaseDao<Category>{
	public List<Category> queryJoinAccount(String type,int page,int size);
	//根据关键字查询总记录数
	public long getCount(String type);
	//根据ids删除多条记录
	public void deleteByIds(String ids);
	
	public List<Category> queryByHot(boolean hot);
}
 