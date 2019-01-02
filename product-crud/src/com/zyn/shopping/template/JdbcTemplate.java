package com.zyn.shopping.template;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.zyn.shopping.domain.Product;
import com.zyn.shopping.util.JdbcUtil;

public class JdbcTemplate {
	private JdbcTemplate(){}
	public static int update(String sql,Object... params) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conn = JdbcUtil.getConn();
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				ps.setObject(i+1,params[i]);
			}
			return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn,ps,null);

		}
		return 0;

	}
	public static <T>T query(String sql,IResultSetHandler<T> rsh,Object... params) {
		List<Product> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtil.getConn();
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				ps.setObject(i+1,params[i]);
			}
			rs = ps.executeQuery();
			return rsh.handle(rs);

		
		} catch (Exception e) {
			e.printStackTrace();

		} finally {

			JdbcUtil.close(conn, null, rs);
		}
		
		return null;
		
	}

}
