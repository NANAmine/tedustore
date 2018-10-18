package test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.store.bean.GoodsCategory;
import cn.tedu.store.mapper.GoodsCategoryMapper;

public class TestGoodsCategoryMapper {

	@Test
	public void testGetGoodsCategoryByParentId() {
		//1. 获得Spring容器
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		System.out.println("=============");
		
		//2. 测试
		GoodsCategoryMapper mapper = 
			ac.getBean(GoodsCategoryMapper.class);
		List<GoodsCategory> list =mapper.getGoodsCategoryByParentId(202, null, null);
		for( GoodsCategory c : list ) {
			System.out.println(c);			
		}
		
		List<GoodsCategory> list162 =mapper.getGoodsCategoryByParentId(202, 0, 6);
		for( GoodsCategory c : list ) {
			System.out.println(c);			
		}
	}
	
	@Test
	public void testGetGoodsCategoryById() {
		//1. 获得Spring容器
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		System.out.println("=============");
		
		//2. 测试
		GoodsCategoryMapper mapper = ac.getBean(GoodsCategoryMapper.class);
		GoodsCategory goodsCategory= mapper.getGoodsCategoryById(1);
		System.out.println(goodsCategory);		
	}
	
}



