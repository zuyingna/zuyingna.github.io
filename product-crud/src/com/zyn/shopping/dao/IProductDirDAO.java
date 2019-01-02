package com.zyn.shopping.dao;

import java.util.List;

import com.zyn.shopping.domain.Product;
import com.zyn.shopping.domain.ProductDir;

public interface IProductDirDAO {
	void save(Product pro);

	void delete(Long id);

	void update(Product pro);

	ProductDir get(Long id);

	List<ProductDir> list();
}
