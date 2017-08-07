package com.hfut.parking.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.hfut.parking.domian.ParkingInfo;

/*
 * ��װ���ݿ��жԳ�λ��Ϣ�Ĳ�������Ҫ���õ�ȫ��ͣ��λ��Ϣ��������Dao�㽫��json���ݷ��ع��ͻ��˽���
 */

public class ParkingInfoDao {

	public static ArrayList<ParkingInfo> getParkingInfo() {

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
			sql = "select * from parking_urban";
			ResultSet rss = stmt.executeQuery(sql);
			ArrayList<ParkingInfo> arrayList = new ArrayList<ParkingInfo>();
			if (rss != null) {
				while (rss.next()) {
					int id = rss.getInt("id");
					String imgurl = rss.getString("imgurl");
					String des = rss.getString("describtion");
					String lat = rss.getString("lat");
					String lon = rss.getString("lon");
					String name = rss.getString("name");
					int totlenumb = rss.getInt("totlenumb");
					String charge = rss.getString("charge");

					ParkingInfo parkinginfo = new ParkingInfo();
					parkinginfo.setId(id);
					parkinginfo.setDescribtion(des);
					parkinginfo.setImgurl(imgurl);
					parkinginfo.setLat(lat);
					parkinginfo.setLon(lon);
					parkinginfo.setName(name);
					parkinginfo.setTotlenumb(totlenumb);
					parkinginfo.setCharge(charge);
					arrayList.add(parkinginfo);
					//System.out.println(arrayList);
				}
				return arrayList;

			}

			// response.getOutputStream().write((execute+"").getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

}
