package com.hfut.parking.domian;

/**
 * ��λ������ʵ����
 */
public class Orders {
	// private int id;// ����ID
	private int number;// Ԥ��������ͨ����Ϊ1
	private String createtime;// Ԥ����ʱ��
	private int state;// Ԥ����״̬
	private String username;// Ԥ��������
	private String usertel;// Ԥ������ϵ��ʽ
	private int parkingid;// ��λID
	private String parkingname;// Ԥ���ĳ�λ����

	public String getParkingname() {
		return parkingname;
	}

	public void setParkingname(String parkingname) {
		this.parkingname = parkingname;
	}

	@Override
	public String toString() {
		return "Orders [number=" + number + ", createtime=" + createtime
				+ ", state=" + state + ", username=" + username + ", usertel="
				+ usertel + ", parkingid=" + parkingid + ", parkingname="
				+ parkingname + "]";
	}

	/*
	 * public int getId() { return id; }
	 * 
	 * public void setId(int id) { this.id = id; }
	 */
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsertel() {
		return usertel;
	}

	public void setUsertel(String usertel) {
		this.usertel = usertel;
	}

	public int getParkingid() {
		return parkingid;
	}

	public void setParkingid(int parkingid) {
		this.parkingid = parkingid;
	}
}
