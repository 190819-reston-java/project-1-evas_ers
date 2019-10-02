package com.revature.frontend;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

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
	
	private static final SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy, HH:mm:ss");

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		
//		System.out.println(req.getSession());
		System.out.println("Ending Session for: " + req.getSession());
		req.getSession().invalidate();
		System.out.println("Session ended at " + sdf.format(ts.getTime()));
		

		BasicLogin.aea = "null";
		BasicLogin.apw = "null";
		System.out.println(BasicLogin.aea+BasicLogin.apw);
		resp.sendRedirect("login.html");
	}

}
