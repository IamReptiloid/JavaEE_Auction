package ru.rsreu.auction.service;

public class ServiceFactory {
	private ServiceFactory() {
	}

	public static SessionService getSessionService() {
		return new SessionService();
	}
}
