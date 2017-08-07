package com.hfut.parking.service;

import java.sql.SQLException;

import com.hfut.parking.dao.OrdersDao;
import com.hfut.parking.domian.Orders;

public class OrdersService {
	// ������OrderDao,�����װ�˶����ݿ���в����ķ���
	OrdersDao orderdao = new OrdersDao();
	// Ԥ����ʵ������
	Orders orders = new Orders();

	// �ж��Ƿ�Ԥ���ɹ�
	public String isOrder(int id, int number, String createtime,
			String username, String usertel, String parkingname)
			throws SQLException {
		String orderRes = "Ԥ���Ƿ�ɹ���";
		if (orderdao.isExitstparking(id) && username.trim().length() != 0
				&& usertel.trim().length() != 0) {
			orderRes = "Ԥ���ɹ���";
			orders.setParkingid(id);// ���ó�λID
			orders.setNumber(number);// ��λʣ����Ŀ
			orders.setParkingname(parkingname);// ��λ����
			orders.setCreatetime(createtime);// ����Ԥ��ʱ��
			orders.setState(1);// Ԥ��״̬Ϊ�ɹ�
			orders.setUsername(username);// Ԥ��������
			orders.setUsertel(usertel);// Ԥ������ϵ��ʽ

			System.out
					.println(orders.getParkingid() + "," + orders.getNumber()
							+ "," + orders.getCreatetime() + ","
							+ orders.getUsername() + "," + orders.getUsertel()
							+ "," + orders.getParkingname());
			orderdao.addOrders(orders);
			orderdao.update(id);
		} else {
			orderRes = "Ԥ��ʧ�ܣ�Ԥ��ʧ�ܣ�Ԥ��ʧ�ܣ�";
		}

		return orderRes;
	}
}
