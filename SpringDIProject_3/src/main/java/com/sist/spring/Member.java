package com.sist.spring;

import lombok.Data;
/*
 * 		xml
 * 			application-datasource.xml : DB
 * 			application-context.xml : ����� ���� Ŭ���� / MVC
 * 			application-security.xml : ����
 * 			...
 */
@Data
public class Member {
	private int mno;
	private String name;
	private String address;
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
