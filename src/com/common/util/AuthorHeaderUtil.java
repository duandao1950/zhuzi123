package com.common.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AuthorHeaderUtil {

	static Connection conn = null;
	
	static String sql1 = "select DISTINCT time_name from history_time";
	public static List<String> getAuthorHeaderHTML(){
		conn = Connections.getConnectionByJDBC();
		Statement stmt = null;
		Statement stmt2 = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		List<String> htmlStrList = new ArrayList<String>();
		try {
			stmt = conn.createStatement();
			stmt2 = conn.createStatement();
			// 执行查询
			rs = stmt.executeQuery(sql1);
			while (rs.next()) {
				String time_name = rs.getString("time_name").trim();
				String sql2 = "select b.author_name from history_time a,author b where a.id=b.period_id and a.time_name='"+time_name+"' order by order_number";
				
				rs2 = stmt2.executeQuery(sql2);
				
				StringBuilder html = new StringBuilder();
				html.append("<ul class=\"g_clr groups\">\n");
				html.append("  <li>\n");
				html.append("    <h4 class=\"g_fl\"><a class=\"g_green-red\" href=\"http://www.baidu.com/baidu?wd="+time_name+"\" target=\"_blank\">"+time_name+"</a></h4>\n");
				html.append("      <span class=\"g_fr\"><a class=\"g_more g_gray-red\" href=\"#\">更多&gt;&gt;</a></span>\n");
				int count = 0;
				while (rs2.next()) {
					count++;
					if(count>8){
						break;
					}
					
					String author_name = rs2.getString("author_name").trim();
					
					if("吕后".equals(author_name) || "张良".equals(author_name) || "萧何".equals(author_name)){
						continue;
					}
					
					if("韩信".equals(author_name) || "汉景帝".equals(author_name) || "汉高祖".equals(author_name)){
						continue;
					}
					
					if(author_name.indexOf("帝")>1 || author_name.indexOf("高祖")>1 || author_name.indexOf("太宗")>1){
						continue;
					}
					
					html.append("      <span><a href=\"http://www.baidu.com/baidu?wd="+author_name+"\" target=\"_blank\">"+author_name+"</a></span>\n");
				}
				html.append("  </li>\n");
				html.append("</ul>");
				htmlStrList.add(html.toString());
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			// 预防性关闭连接（避免异常发生时在try语句块关闭连接没有执行)
			try {
				if (rs2 != null)
					rs2.close();
				
				if (rs != null)
					rs.close();
				
				if (stmt != null)
					stmt.close();
				
				if (stmt2 != null)
					stmt2.close();
				
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}
		
		return htmlStrList;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list  = getAuthorHeaderHTML();
		
		for(String str : list){
			System.out.println(str);
		}
		
//		String ss = "光武帝";
//		System.out.println(ss.indexOf("帝"));
	}

}
