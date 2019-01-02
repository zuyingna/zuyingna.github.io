package com.zyn.shopping.dao.impl;

import java.util.List;

import com.zyn.shopping.dao.IProductDirDAO;
import com.zyn.shopping.domain.Product;
import com.zyn.shopping.domain.ProductDir;
import com.zyn.shopping.template.IProductDirResultSetHandle;
import com.zyn.shopping.template.JdbcTemplate;

public class ProductDirDAOImpl implements IProductDirDAO  {

	@Override
	public void save(Product pro) {
		
	}

	@Override
	public void delete(Long id) {
		String sql = "delete from Productdir where id=?";
		JdbcTemplate.update(sql, id);
	}

	@Override
	public void update(Product pro) {
	}

	@Override
	public ProductDir get(Long id) {
		System.out.println("--------------------------------");
		String sql = "select * from productdir where id=?";
		List<ProductDir> list=(List<ProductDir>) JdbcTemplate.query(sql, new IProductDirResultSetHandle(),id);
		return list.size()==1?list.get(0):null;
	}

	@Override
	public List<ProductDir> list() {
		return null;
	}

}
