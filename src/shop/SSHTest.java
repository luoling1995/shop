package shop;

import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import cn.it.shop.model.Category;
import cn.it.shop.service.CategoryService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext-*.xml")
public class SSHTest {
	
	@Resource
	private CategoryService categoryService;
	
	@Test
	public void save(){
		categoryService.save(new Category("ÄÐÊ¿ÐÝÏÐ",true));
	}
	
	@Test
	public void update(){
		categoryService.update(new Category(2,"Å®Ê¿ÐÝÏÐ1",false));
	}
	
	@Test
	public void query(){
		for(Category temp:categoryService.queryJoinAccount("%",2,1)){
			System.out.println(temp);
			System.out.println(temp.getAccount());
		}
	}
	
	@Test
	public void getCount(){
		System.out.println(categoryService.getCount(""));
	}
	
	@Test
	public void deleteByIds(){
		categoryService.deleteByIds("23,22");
	}
}
