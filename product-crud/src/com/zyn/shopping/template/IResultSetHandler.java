package com.zyn.shopping.template;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface IResultSetHandler<T> {

	 T  handle(ResultSet rs) throws SQLException;
			
}
