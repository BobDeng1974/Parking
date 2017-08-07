package com.hfut.parking.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.hfut.parking.dao.InfoSearchDao;
import com.hfut.parking.domian.ParkingInfo;

public class InfoSearchServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ArrayList<ParkingInfo> result = null;
		response.setContentType("text/html;charset=UTF-8");// ����ҳ����ʽ����
		String parkingStr = request.getParameter("parking");
		String parking = "";
		InfoSearchDao dbUtil = new InfoSearchDao();
		if (parkingStr != null) {
			parking = new String(parkingStr.getBytes("ISO-8859-1"), "UTF-8");
			result = dbUtil.query(new String[] { "%" + parking + "%",
					"%" + parking + "%" });
		}

		System.out.println("parking=" + parking);
		try {
			// ��result�е����ݷ�װ��һ��jsonArray����
			JSONArray jsonArray = new JSONArray();
			for (ParkingInfo parkinginfo : result) {
				JSONObject newsJson = new JSONObject();

				newsJson.put("id", parkinginfo.getId());
				newsJson.put("imgurl", parkinginfo.getImgurl());
				newsJson.put("describtion", parkinginfo.getDescribtion());
				newsJson.put("lat", parkinginfo.getLat());
				newsJson.put("lon", parkinginfo.getLon());
				newsJson.put("name", parkinginfo.getName());
				newsJson.put("totlenumb", parkinginfo.getTotlenumb());
				newsJson.put("charge", parkinginfo.getCharge());
				jsonArray.put(newsJson);
			}
			// System.out.println(jsonArray);

			// ��jsonArray������Ϊһ��json�����������ظ��ͻ���
			JSONObject allNewsJson = new JSONObject();
			allNewsJson.put("data", jsonArray);
			response.getOutputStream().write(
					allNewsJson.toString().getBytes("gbk"));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}