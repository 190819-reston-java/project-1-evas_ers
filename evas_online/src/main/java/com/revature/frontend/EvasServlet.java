package com.revature.frontend;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EvasServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter pw = resp.getWriter();
		pw.println("hi there");
		resp.setContentType("text/html");
		
		String user=req.getParameter("enterUserName");
		String password=req.getParameter("enterPassword");
		
		if (user.equals("hi")) {
			pw.println("NICE!");
		} else {
			pw.println("NOT NICE!!!!");
		}
		
	}

}
