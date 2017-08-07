package com.hfut.parking.servlet;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hfut.parking.service.OrdersService;

public class OrdersServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");// �������(Post)
		response.setContentType("text/html��charset=utf-8");// ��Ӧ����

		// ����UserService��
		OrdersService orderservice = new OrdersService();
		// ���ճ�λid
		int id = Integer.parseInt(request.getParameter("id"));
		// ����number
		int number = Integer.parseInt(request.getParameter("number"));
		// ����createtime
		String createtime = request.getParameter("createtime");
		createtime = new String(createtime.getBytes("ISO-8859-1"), "GBK");
		// ���ܴ��ݹ������û���
		String username = request.getParameter("username");
		username = new String(username.getBytes("ISO-8859-1"), "GBK");
		// �����û���ϵ��ʽ
		String usertel = request.getParameter("usertel");
		// usertel = new String(usertel.getBytes("ISO-8859-1"), "GBK");
		// ���ճ�λ����
		String parkingname = request.getParameter("parkingname");
		parkingname = new String(parkingname.getBytes("ISO-8859-1"), "GBK");
		// ���ճ�λ��Ψһ��ʶID
		// int id = Integer.parseInt(request.getParameter("id"));
		System.out.println(id + "," + number + "," + createtime + ","
				+ username + "," + usertel + "," + parkingname);
		// ����Service��ҵ��㷽��(�жϵ�¼�Ƿ�ɹ�)
		OutputStream os = response.getOutputStream();
		String orderRes = null;
		try {
			orderRes = orderservice.isOrder(id, number, createtime, username,
					usertel, parkingname);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		os.write(orderRes.getBytes("utf-8"));
		os.flush();
		os.close();
		System.out.println(orderRes);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
