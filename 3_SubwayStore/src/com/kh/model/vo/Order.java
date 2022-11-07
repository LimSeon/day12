package com.kh.model.vo;

import java.sql.Date;

public class Order {
	// 필드부
	private String userName; //USER_NAME	VARCHAR2(20 BYTE)
	private String phone; //PHONE	VARCHAR2(13 BYTE)
	private String address; //ADDRESS	VARCHAR2(100 BYTE)
	private String message; //MESSAGE	VARCHAR2(200 BYTE)
	private String sandwich; //SANDWICH	VARCHAR2(50 BYTE)
	private String vegetable; //VEGETABLE	VARCHAR2(100 BYTE)
	private String sauce; //SAUCE	VARCHAR2(200 BYTE)
	private String cookie; //COOKIE	VARCHAR2(50 BYTE)
	private String payment; //PAYMENT	VARCHAR2(12 BYTE)
	private int price; // PRICE	NUMBER
	private Date orderDate; //ORDER_DATE	DATE
	// 생성자부
	public Order() {}

	public Order(String userName, String phone, String address, String message, String sandwich, String vegetable,
			String sauce, String cookie, String payment, int price, Date orderDate) {
		super();
		this.userName = userName;
		this.phone = phone;
		this.address = address;
		this.message = message;
		this.sandwich = sandwich;
		this.vegetable = vegetable;
		this.sauce = sauce;
		this.cookie = cookie;
		this.payment = payment;
		this.price = price;
		this.orderDate = orderDate;
	}
	// 메소드부
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getSandwich() {
		return sandwich;
	}

	public void setSandwich(String sandwich) {
		this.sandwich = sandwich;
	}

	public String getVegetable() {
		return vegetable;
	}

	public void setVegetable(String vegetable) {
		this.vegetable = vegetable;
	}

	public String getSauce() {
		return sauce;
	}

	public void setSauce(String sauce) {
		this.sauce = sauce;
	}

	public String getCookie() {
		return cookie;
	}

	public void setCookie(String cookie) {
		this.cookie = cookie;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	@Override
	public String toString() {
		return "Order [userName=" + userName + ", phone=" + phone + ", address=" + address + ", message=" + message
				+ ", sandwich=" + sandwich + ", vegetable=" + vegetable + ", sauce=" + sauce + ", cookie=" + cookie
				+ ", payment=" + payment + ", price=" + price + ", orderDate=" + orderDate + "]";
	}
}
