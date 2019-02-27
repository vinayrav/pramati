package com.practice.demo;

public class Data {
	private int bid;
	private String blang;
	private String bname;
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getBlang() {
		return blang;
	}
	public void setBlang(String blang) {
		this.blang = blang;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	@Override
	public String toString() {
		return "Data [bid=" + bid + ", blang=" + blang + ", bname=" + bname + "]";
	}
	


}
