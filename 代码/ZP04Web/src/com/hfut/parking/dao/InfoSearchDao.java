package com.hfut.parking.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;

import com.hfut.parking.domian.ParkingInfo;
/*
 * ��ѯ�����ݿ����Ӳ���������Ĳ�ѯ��û��������ȥ�Ӳ�ѯ��õ��Ľ���������ǵõ�json���ݺ�ȥ��Ԫ���ݵ�����(Ԫ���ݾ����������ݵ����ݣ����Կ���ͨ����ȥ������)
 * �õ�����֮����ÿ�����ݺ����һ��*��Ȼ����servlet�а����result�������ˣ����˿ͻ���֮��ȥ�������json���ݣ�json���ݽ����ܿ�������ÿ��һ��*����һ��
 * �س����棬�����Ļ���ÿ7����Ϣ�����ֳ�һ��tablerow����ȫ����ѯ������г���7�������õ�һ��recrod������ÿ������������ݣ������ѯ�������ã�Ҫ�Ľ����õļ�������
 */
public class InfoSearchDao {

	private String url = "jdbc:mysql://localhost:3306/parkingassisant?useUnicode=true&characterEncoding=utf-8&useSSL=false";
	private String user = "root";
	private String psd = "123456";
	private Connection conn;
	private java.sql.PreparedStatement ps;
	private ResultSet rss;

	public Connection getConn() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, psd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	public ArrayList<ParkingInfo> query(String[] args) {
		String sql="select * from parking_urban where name like ? or describtion like ?";
		conn = getConn();
		try {
			ps = conn.prepareStatement(sql);
			if (args != null) {// �Դ�������ռλ�����и�ֵ
				for (int i = 0; i < args.length; i++) {
					ps.setString(i + 1, args[i]);
				}

				rss = ps.executeQuery();
				System.out.println(rss);
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
						System.out.println(arrayList);
					}
					return arrayList;
				}
				
//				ResultSetMetaData rsmd = rs.getMetaData();
//				int count = rsmd.getColumnCount();// �õ������е�����
//				while (rs.next()) { // ����ǰ�ִ��sql���֮��ѡ������ļ�¼��next����ʱ�����ƶ����α꣬���ƶ����ļ�¼�������õ���������������ÿ��һ�м�һ��*�ţ�֮���ٰ�*��ת����//
//					for (int i = 0; i < count; i++) {
//						result += rs.getString(i + 1) + "*";
//					}
//				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
