package com.zyn.shopping.test;

import java.util.List;

import org.junit.Test;

import com.zyn.shopping.dao.IProductDAO;
import com.zyn.shopping.dao.impl.ProductDAOImpl;
import com.zyn.shopping.domain.Product;
import com.zyn.shopping.domain.ProductDir;

public class ProductDAOImplTest {
	IProductDAO dao=new ProductDAOImpl();
	@Test
	public void testSave() {
		Product p=dao.get(1l);
		p.setProductName("机械键盘");
		p.setSupplier("京东商城");
		ProductDir dir=new ProductDir();
		dir.setId(4l);
		p.setDir(dir);
		dao.save(p);
		System.out.println(p);
	}

	@Test
	public void testDelete() {
		dao.delete(22l);
	}

	@Test
	public void testUpdate() {
		Product p=dao.get(20l);
		p.setProductName("小米鼠标");
		dao.update(p);
		System.out.println(p);
	}

	@Test
	public void testGet() {
		Product p=dao.get(2L);
		System.out.println(p);
	}

	@Test
	public void testList() {
		List<Product> product=dao.list();
		for (Product pro : product) {
			System.out.println(pro);
		}
	}

}
