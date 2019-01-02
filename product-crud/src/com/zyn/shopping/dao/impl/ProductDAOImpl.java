package com.zyn.shopping.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zyn.shopping.dao.IProductDAO;
import com.zyn.shopping.dao.IProductDirDAO;
import com.zyn.shopping.domain.Product;
import com.zyn.shopping.domain.ProductDir;
import com.zyn.shopping.template.IResultSetHandler;
import com.zyn.shopping.template.JdbcTemplate;

public class ProductDAOImpl implements IProductDAO {

	public void save(Product pro) {
		String sql = "insert into product (productName,dir_id,salePrice,supplier,brand,cutoff,costPrice)values(?,?,?,?,?,?,?)";
		Object[] params = { pro.getProductName(), pro.getDir().getId(), pro.getSalePrice(), pro.getSupplier(),
				pro.getBrand(), pro.getCutoff(), pro.getCostPrice() };
		JdbcTemplate.update(sql, params);
	}

	public void delete(Long id) {
		String sql = "delete from Product where id=?";
		JdbcTemplate.update(sql, id);
	}

	public void update(Product pro) {
		String sql = "update product set productName=?,dir_id=?,salePrice=?,supplier=?,brand=?,cutoff=?,costPrice=? where id=?";
		Object[] params = { pro.getProductName(), pro.getDir().getId(), pro.getSalePrice(), pro.getSupplier(),
				pro.getBrand(), pro.getCutoff(), pro.getCostPrice(), pro.getId() };
		JdbcTemplate.update(sql, params);
	}

	public Product get(Long id) {
		String sql = "select * from product where id=?";
		List<Product> product=JdbcTemplate.query(sql, new ProductResultSetHandle(),id);
		return product.size()==1?product.get(0):null;
	}

	public List<Product> list() {
		String sql = "select * from product";
		return JdbcTemplate.query(sql, new ProductResultSetHandle());
	}

	class ProductResultSetHandle implements IResultSetHandler<List<Product>> {
		private Map<Long,ProductDir> cache=new HashMap<>();
		public List<Product> handle(ResultSet rs) throws SQLException {
			IProductDirDAO dirDao=new ProductDirDAOImpl();
			List<Product> list = new ArrayList<>();
			while (rs.next()) {
				Product p = new Product();
				list.add(p);
				p.setId(rs.getLong("id"));
				p.setProductName(rs.getString("productName"));
				p.setSalePrice(rs.getBigDecimal("salePrice"));
				p.setSupplier(rs.getString("supplier"));
				p.setBrand(rs.getString("brand"));
				p.setCutoff(rs.getDouble("cutoff"));
				p.setCostPrice(rs.getBigDecimal("costPrice"));
				Long dirId=rs.getLong("dir_id");
				
				if (dirId!=null&&dirId!=0) {
					ProductDir dir=cache.get(dirId);
					if (dir==null) {
					 dir=dirDao.get(dirId);
						cache.put(dirId, dir);
					}
					p.setDir(dir);
				}
			}

			return list;
		}

	}

}
