package com.revature.frontend;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.repository.EvasDAO;
import com.revature.repository.EvasJDBC;

/**
 * Servlet implementation class LogoutServlet
 */
public class LogoutServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		
		System.out.println(req.getSession());
		req.getSession().invalidate();
		System.out.println("Session ended at " + ts.getTime());
		resp.sendRedirect("login.html");
	}

}
