package com.zyn.shopping.template;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zyn.shopping.dao.IProductDirDAO;
import com.zyn.shopping.dao.impl.ProductDirDAOImpl;
import com.zyn.shopping.domain.Product;
import com.zyn.shopping.domain.ProductDir;

public class IProductDirResultSetHandle implements IResultSetHandler<List<ProductDir>>{

	@Override
	public List<ProductDir> handle(ResultSet rs) throws SQLException {
		IProductDirDAO dirDao=new ProductDirDAOImpl();
		List<ProductDir> list = new ArrayList<>();
		while (rs.next()) {
			ProductDir dir= new ProductDir();
			list.add(dir);
			dir.setId(rs.getLong("id"));
			dir.setDirName(rs.getString("dirName"));
			Long dirId=rs.getLong("parent_id");
			ProductDir pd=dirDao.get(dirId);
			
		}

		return list;
	}

	}


