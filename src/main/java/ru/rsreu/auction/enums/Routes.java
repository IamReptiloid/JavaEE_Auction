package ru.rsreu.auction.enums;

public enum Routes {
	LOGIN("login"),
	LOGOUT("logout"),
	ERROR("error"),
	ADMIN_PANEL("admin_panel"),
	PROFILE("profile"),
    AUCTION("auction");

	private String rout;
	Routes(String page) {
		this.rout = page;
	}
	public String getName(){
		return rout;
	}
	public Pages getPage() {
		return Pages.valueOf(rout.toUpperCase());
	}


}
