package com.hfut.parking.service;

import java.sql.SQLException;

import com.hfut.parking.dao.UserDao;
import com.hfut.parking.domian.User;

/**
 * User��ҵ���߼��� ����UserDao *
 */
public class UserService {
	private UserDao userdao = new UserDao();

	// �ж��Ƿ��¼�ɹ������ظ�LoginServlet
	public String isLogin(String username, String password) throws SQLException {
		String result = "��¼�Ƿ�ɹ�";

		String sql = "select name,password from " + "users";
		System.out.println("url = " + sql);
		// DBManager db = new DBManager();
		// ResultSet rst = db.query(sql);

		/*
		 * try { while (rst.next()) { // ѡ��Name�������� String userpass =
		 * rst.getString("password"); // ������
		 * System.out.println(rst.getString("name") + "\t" + userpass); } }
		 * catch (SQLException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */
		// rst.close();
		// conn.close();

		if (userdao.findByUsername(username).getUsername() != null) {
			if (userdao.findByUsername(username).getUsername().equals(username)
					&& userdao.findByUsername(username).getPassword()
							.equals(password)) {
				result = "��¼�ɹ���";
			} else {
				result = "��¼ʧ�ܣ�";
			}

		} else {
			result = "��¼ʧ�ܣ�";
		}
		System.out.println(result);
		return result;

	}

	// �ж��Ƿ�ע��ɹ������ظ�RegisterServlet
	public String isRegister(String username, String password)
			throws SQLException {
		String result = "ע���Ƿ�ɹ�";
		// String sql = "select name,password from " + "users";
		// System.out.println("url = " + sql);
		if (userdao.findByUsername(username).getUsername() != null
				|| username.trim().length() == 0
				|| password.trim().length() == 0) {
			result = "�û����Ѵ��ڻ��û��������벻��Ϊ�գ�ע��ʧ�ܣ�";
		} else {
			result = "ע��ɹ���";
			User user = new User();
			user.setUsername(username);
			user.setPassword(password);
			userdao.addUser(user);
		}
		System.out.println(result);
		return result;

	}
}
