package com.hfut.parking.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.hfut.parking.database.DBManager;
import com.hfut.parking.domian.Orders;
import com.mysql.jdbc.Statement;

/**
 * ��λԤ�������ڶ�����Ϣ��
 */
public class OrdersDao {
	/**
	 * ��ѯparking_info���г�λʣ�������Ƿ�>=1
	 * 
	 * @return totlenumb-+
	 * @throws SQLException
	 */
	public boolean isExitstparking(int id) throws SQLException {
		boolean flag = false;
		String sql = "select * from parking_info where " + "id" + "=" + id;
		System.out.println("��ѯ�Ƿ��п��೵λ��" + sql);
		DBManager db = new DBManager();
		Statement stmt = db.getStatement();
		// rst = stmt.executeQuery(sql);
		ResultSet rst = stmt.executeQuery(sql);

		while (rst.next()) {

			int i = rst.getInt("totlenumb");
			System.out.println("��ó�λ������" + rst.getString("totlenumb"));

			if (i >= 1) {
				flag = true;
			} else {
				flag = false;
			}

		}

		rst.close();
		System.out.println(flag);
		return flag;
	}

	/**
	 * ���Ԥ����Ϣ�����ݿ�Ԥ����Ϣ��orders��
	 * 
	 * @param orders
	 */
	public void addOrders(Orders orders) {
		// Orders addorders = new Orders();

		DBManager db = new DBManager();
		int number = orders.getNumber();
		String createtime = orders.getCreatetime();
		int state = orders.getState();
		String username = orders.getUsername();
		String usertel = orders.getUsertel();
		int parkingid = orders.getParkingid();// ��λID
		String parkingname = orders.getParkingname();

		String sql = "Insert into "
				+ "orders(number,creatTime,state,user_name,user_tel,parking_id,parking_name)"
				+ " values (" + number + "," + "'" + createtime + "'," + state
				+ "," + "'" + username + "'," + "'" + usertel + "',"
				+ parkingid + ",'" + parkingname + "')";
		
		System.out.println("sql = " + sql);
		int executeResult = db.update(sql);
		System.out.println(executeResult);
		
	}
	
	public void update(int id) throws SQLException{
		 String sql = "update parking_info set totlenumb=totlenumb-1 where "+ "id" + "=" + id;
		 System.out.println("��ǰ��λ������" + sql);	
		 DBManager db = new DBManager();
			Statement stmt = db.getStatement();
			stmt.executeUpdate(sql);
		}
		
}
