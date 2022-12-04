package ru.rsreu.auction.helper;

public class URLHelper {
	private static final String PAGE_URL_FORMAT = "/pages/%s.jsp";

	private URLHelper() {};

	public static String getPath(String page) {
		return String.format(PAGE_URL_FORMAT, page);
	}
}
