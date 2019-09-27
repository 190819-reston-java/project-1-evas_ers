package com.revature.frontend;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.repository.EvasDAO;
import com.revature.repository.EvasJDBC;

public class BasicLogin extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter pw = resp.getWriter();
		resp.setContentType("text/html");
		EvasDAO evasDao = new EvasJDBC();

		String username = req.getParameter("enterUsername");
		String password = req.getParameter("enterPassword");

		if (username.equals("hi")) {
			pw.println("NICE!");
		} else {
			pw.println("WHOOPS");
		}
		System.out.println(evasDao.getEmailandPass("fursa@evas.com", "FU9630"));

//		System.out.println(evasDao.getEmailandPass(username, password));

		
//		if(evasDao.getEmailandPass(username, password)==null) {
//			pw.println("Invalid username or password");
//		}else {
//			pw.println("Welcome");
//		}

	}

}
