package ru.rsreu.auction.constant;

public enum Routes {
	LOGIN("login"),
	LOGOUT("logout"),
	ERROR("error"),
	PROFILE("profile");
	private String page;
	Routes(String page) {
		this.page = page;
	}
	public String getName(){return page;}
}
