package ru.rsreu.auction.handler;

import com.google.gson.Gson;
import ru.rsreu.auction.constant.ContentType;
import ru.rsreu.auction.enums.Pages;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

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

	protected void json(Object object) throws IOException {
		json(object, HttpServletResponse.SC_OK);
	}

	protected void json(Object object, int status) throws IOException {
		PrintWriter out = response.getWriter();
		String objectAsString = new Gson().toJson(object);

		response.setContentType(ContentType.JSON);
		response.setStatus(status);
		response.setCharacterEncoding("UTF-8");

		out.print(objectAsString);
		out.flush();
	}
}
