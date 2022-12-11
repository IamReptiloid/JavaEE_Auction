package ru.rsreu.auction.handler;

import ru.rsreu.auction.helper.URLHelper;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class Rout {
	private ServletContext context;
	private HttpServletRequest request;
	private HttpServletResponse response;

	public void init(ServletContext context, HttpServletRequest request, HttpServletResponse response) {
		this.context = context;
		this.request = request;
		this.response = response;
	}

	public void forward(String page) throws ServletException, IOException {
		String path = URLHelper.getPath(page);
		RequestDispatcher requestDispatcher = this.context.getRequestDispatcher(path);
		requestDispatcher.forward(request, response);
	}

	public void redirect(String url) throws IOException {
		String path = URLHelper.getPath(url);
		response.sendRedirect(path);
	}

	public HttpServletRequest getRequest() {
		return this.request;
	}
}
