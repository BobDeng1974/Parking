package com.hfut.parking.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.hfut.parking.domian.Rent;

/*
 * ��װ���ݿ��жԳ�λ��Ϣ�Ĳ�������Ҫ���õ�ȫ��ͣ��λ��Ϣ��������Dao�㽫��json���ݷ��ع��ͻ��˽���
 */

public class RentDao {

	public static ArrayList<Rent> getRent() {

		Connection connection = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = null;

		try {
			/***** ��д���ݿ������Ϣ(��������ݿ�����ҳ) *****/
			String databaseName = "parkingassisant?useUnicode=true&characterEncoding=utf-8&useSSL=false";
			String host = "localhost";
			String port = "3306";
			String username = "root"; // �û�AK
			String password = "123456"; // �û�SK
			String driverName = "com.mysql.jdbc.Driver";
			String dbUrl = "jdbc:mysql://";
			String serverName = host + ":" + port + "/";
			String connName = dbUrl + serverName + databaseName;

			/****** �������Ӳ�ѡ�����ݿ���ΪdatabaseName�ķ����� ******/
			Class.forName(driverName);
			connection = DriverManager.getConnection(connName, username,
					password);
			stmt = connection.createStatement();
			/****** ������������ȫ�������ͿɶԵ�ǰ���ݿ������Ӧ�Ĳ����� *****/
			/****** �������Ϳ���ʹ��������׼mysql���������������ݿ���� *****/
			// ����һ�����ݿ��
			System.out.println("���ӳɹ�");
			sql = "select * from rent";
			ResultSet rss = stmt.executeQuery(sql);
			ArrayList<Rent> arrayList = new ArrayList<Rent>();
			if (rss != null) {
				while (rss.next()) {
					String id = rss.getString("id");
					String imgurl = rss.getString("imgurl");
					String des = rss.getString("des");
					String lat = rss.getString("lat");
					String lon = rss.getString("lon");
					String name = rss.getString("name");
					String rent = rss.getString("rent");

					Rent rentInfo = new Rent();
					rentInfo.setId(id);
					rentInfo.setDes(des);
					rentInfo.setImgurl(imgurl);
					rentInfo.setLat(lat);
					rentInfo.setLon(lon);
					rentInfo.setName(name);
					rentInfo.setRent(rent);
					arrayList.add(rentInfo);
				}
				return arrayList;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
