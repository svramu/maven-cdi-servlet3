package org.example.webapp;

import java.util.Date;
import java.io.IOException;

import javax.inject.Inject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/exserv" )
public class ExampleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

  @Inject 
  MyBean myBean;
 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/plain");
		resp.getWriter().write("- BINGO - " + (new Date()) +"["+ myBean.getMessage() +"]");
	}
}
