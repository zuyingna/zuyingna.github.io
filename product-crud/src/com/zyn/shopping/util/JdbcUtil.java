package com.zyn.shopping.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.mysql.jdbc.Statement;

public class JdbcUtil {
	private JdbcUtil() {
	}

	private static Properties p = new Properties();
	private static DataSource dataSource = null;
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			p.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties"));
			dataSource=DruidDataSourceFactory.createDataSource(p);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 连接资源
	public static Connection getConn() {
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// 释放资源
	public static  void close(Connection conn, PreparedStatement ps, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {

				try {
					if (conn != null) {
						conn.close();
					}
				} catch (Exception e) {
					e.printStackTrace();

				}
			}

		}

	}

}
