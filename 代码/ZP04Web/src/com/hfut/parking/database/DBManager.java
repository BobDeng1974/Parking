package com.hfut.parking.database;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

/**
 * ���ݿ����Ӳ�����
 */
public class DBManager {

	public final static String COLUMN_USERNAME = "name";
	public final static String COLUMN_PASSWORD = "password";
	private java.sql.PreparedStatement ps;
	private ResultSet rs;

	// �������ݿ�
	public Statement getStatement() {
		Connection connection = null;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");//������������ȡ����
			String url = "jdbc:mysql://localhost:3306/parkingassisant?useUnicode=true&characterEncoding=utf-8&useSSL=false";
			String databaseusername = "root";
			String databasepassword = "123456";
			connection = (Connection) DriverManager.getConnection(url,
					databaseusername, databasepassword);
			stmt = (Statement) connection.createStatement();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return stmt;
	}

	// ���ݿ��ж�Ӧusers���е����ݴ浽������
	public ArrayList<HashMap<String, Object>> getDatabaseContents() {
		ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		HashMap<String, Object> map = null;
		String sql = "select * from " + "users";
		Statement stmt = getStatement();
		ResultSet rst = null;
		try {
			rst = stmt.executeQuery(sql);
			if (rst != null) {
				while (rst.next()) { 
					map = new HashMap<String, Object>();
					map.put(COLUMN_USERNAME, rst.getString(COLUMN_USERNAME));
					map.put(COLUMN_PASSWORD, rst.getString(COLUMN_PASSWORD));
					list.add(map);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	// ���ݿ��ѯ
	public ResultSet query(String sql) {
		ResultSet rst = null;
		Statement stmt = getStatement();
		System.out.println("stmt = " + stmt);
		try {
			rst = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rst;
	}

	// ����
	public int update(String sql) {
		Statement stmt = getStatement();
		int result = 0;
		try {
			result = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
