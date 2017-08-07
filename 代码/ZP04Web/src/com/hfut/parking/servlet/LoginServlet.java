package com.hfut.parking.servlet;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hfut.parking.service.UserService;

/**
 * User��servlet��
 * 
 */
public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");// �������(Post)
		response.setContentType("text/html;charset=utf-8");// ��Ӧ����

		// ����UserService��
		UserService userservice = new UserService();
		// ���ܴ��ݹ������û������������
		String username = request.getParameter("name");
		String password = request.getParameter("pass");
		// ����Service��ҵ��㷽��(�жϵ�¼�Ƿ�ɹ�)
		OutputStream os = response.getOutputStream();
		try {
			String loginRes = userservice.isLogin(username, password);
			os.write(loginRes.getBytes("utf-8"));
			System.out.println(loginRes);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		os.flush();
		os.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

	public void init() throws ServletException {
		// Put your code here
	}

}
