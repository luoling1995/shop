package shop;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.it.shop.model.Category;
import cn.it.shop.service.CategoryService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext-*.xml")
public class CategoryImplTest {
	@Resource
	private CategoryService categoryService;
	
	@Test
	public void testUpdate() {
		categoryService.update(new Category(1, "¶ùÍ¯×°", true));
	}

}
