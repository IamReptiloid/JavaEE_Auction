package ru.rsreu.auction.enums;

public enum Pages {
	LOGIN("/pages/login.jsp"),
	ERROR("/pages/error.jsp"),
	ADMIN_PANEL("/pages/adminPanel.jsp"),
	PROFILE("/pages/profile.jsp"),
	AUCTION("/pages/auction.jsp");

	private final String page;
	Pages(String page) {
		this.page = page;
	}

	public String getPage() {
		return this.page;
	}
}
