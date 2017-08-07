package com.hfut.parking.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import com.hfut.parking.dao.RentDao;
import com.hfut.parking.domian.Rent;

public class RentServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			// �����ݿ��ȡ��λ����
			ArrayList<Rent> list = RentDao.getRent();

			// ��list�е����ݷ�װ��һ��jsonArray����
			JSONArray jsonArray = new JSONArray();
			for (Rent rentinfo : list) {
				JSONObject newsJson = new JSONObject();
				newsJson.put("id", rentinfo.getId());
				newsJson.put("imgurl", rentinfo.getImgurl());
				newsJson.put("des", rentinfo.getDes());
				newsJson.put("lat", rentinfo.getLat());
				newsJson.put("lon", rentinfo.getLon());
				newsJson.put("name", rentinfo.getName());
				newsJson.put("rent", rentinfo.getRent());
				jsonArray.put(newsJson);
				// System.out.println(jsonArray);
			}

			// ��jsonArray������Ϊһ��json�����������ظ��ͻ���
			JSONObject allNewsJson = new JSONObject();
			allNewsJson.put("data", jsonArray);
			// System.out.println(allNewsJson);
			response.getOutputStream().write(
					allNewsJson.toString().getBytes("gbk"));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
