package com.revature.frontend;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.repository.EvasDAO;
import com.revature.repository.EvasJDBC;

/**
 * Servlet implementation class DenialServlet
 */
public class DenialServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		EvasDAO evasDao = new EvasJDBC();

		evasDao.updateRequestStatus(SelectRequest.requestOfInterest, "resolved");
		System.out.println("Denied request #" + SelectRequest.requestOfInterest);
		
		resp.sendRedirect("index.html");
	}

}
