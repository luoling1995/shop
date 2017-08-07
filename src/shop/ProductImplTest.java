package shop;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.it.shop.model.Account;
import cn.it.shop.model.Product;
import cn.it.shop.service.AccountService;
import cn.it.shop.service.ProductService;
import cn.it.shop.service.SorderService;
import net.sf.json.JSONSerializer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext-*.xml")
public class ProductImplTest {
	@Resource
	private ProductService productService;
	@Resource
	private SorderService sorderService;
	
	@Test
	public void testSave() {
		System.out.println(productService.getCount(""));
	}

	@Test
	public void test(){
		System.out.println(productService.queryJoinCategory("", 1, 5).get(0).getName());
	}
	
	@Test
	public void queryByCid(){
		for(Product p:productService.queryByCid(8)){
			System.out.println(p);
		}
	}
	
	@Test
	public void querySale(){
		System.out.println(JSONSerializer.toJSON(sorderService.querySale(5)));
//		for(Object temp : sorderService.querySale(5)){
//			System.out.println(temp);
//		}
	}
}
