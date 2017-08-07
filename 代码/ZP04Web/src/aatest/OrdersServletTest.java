package aatest;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.junit.Test;

public class OrdersServletTest {

	@Test
	public void test() {

		String id = "1";
		String number = "21";
		String createtime = "2016��11��24��23:08";
		String username = "С��";
		String usertel = "15255147713";
		String parkingname = "ͼ���ͣ��λ";

		String path = "http://192.168.56.1:8080/ZP04Web/servlet/OrdersServlet?id="
				+ id
				+ "&number="
				+ number
				+ "&createtime="
				+ createtime
				+ "&username="
				+ username
				+ "&usertel="
				+ usertel
				+ "&parkingname=" + parkingname;

		try {
			URL url = new URL(path);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setConnectTimeout(5000);
			conn.setReadTimeout(5000);
			System.out.println("����ɹ�");
			System.out.println(conn.getResponseCode());
			if (conn.getResponseCode() == 200) {
				InputStream is = conn.getInputStream();
				String text = Utils.getTextFromStream(is);
				System.out.println(text);
				/*
				 * Message msg = handler.obtainMessage(); msg.obj = text;
				 * handler.sendMessage(msg);
				 */
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
