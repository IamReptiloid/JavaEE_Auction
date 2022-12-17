package ru.rsreu.auction.handler;

import ru.rsreu.auction.enums.Pages;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class Rout {
	protected  ServletContext context;
	protected  HttpServletRequest request;
	protected  HttpServletResponse response;

	public void init(ServletContext context, HttpServletRequest request, HttpServletResponse response) {
		this.context = context;
		this.request = request;
		this.response = response;
	}

	public void forward(Pages page) throws ServletException, IOException {
		RequestDispatcher requestDispatcher = this.context.getRequestDispatcher(page.getPage());
		requestDispatcher.forward(request, response);
	}
}
