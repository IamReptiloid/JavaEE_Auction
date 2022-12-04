package ru.rsreu.auction.constant;

public enum Routes {
	LOGIN("login"),
	LOGOUT("logout"),
	ERROR("error");

	private String page;
	Routes(String page) {
		this.page = page;
	}
	public String getName(){return page;}
}
