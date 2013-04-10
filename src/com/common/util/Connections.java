package com.common.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connections {
	static Connection conn = null;
	public static Connection getConnectionByJDBC() {
		try {
			// 装载驱动包类
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("装载驱动包出现异常!");
			e.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/zhuzi123", "root", "root");
		} catch (SQLException e) {
			System.out.println("链接数据库发生异常!");
			e.printStackTrace();
		}
		return conn;
	}

	public static void test() {
		String sql = "select * from history_time";
		getConnectionByJDBC();
		try {
			// 创建一个jdbc声明
			Statement stmt = conn.createStatement();
			// 执行查询
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String time_name = rs.getString("time_name");
				System.out.println(time_name);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			// 预防性关闭连接（避免异常发生时在try语句块关闭连接没有执行)
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test();
	}

}
