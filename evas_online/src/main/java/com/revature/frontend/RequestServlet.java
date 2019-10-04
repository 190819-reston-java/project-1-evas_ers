package com.revature.frontend;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.model.Request;
import com.revature.repository.EvasDAO;
import com.revature.repository.EvasJDBC;

/**
 * Servlet implementation class SettingsServlet
 */
public class RequestServlet extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		EvasDAO evasDao = new EvasJDBC();
//		new Request
//		Request editRequest = evasDao.getRequestById(BasicLogin.loggedAccount);
		Request editRequest = new Request();
		
		//checking if the fields have changed
		if(req.getParameter("enterRequestCatagory").length()>0) {
		editRequest.setRequestcatagory(req.getParameter("enterRequestCatagory"));
		}
		
		if(req.getParameter("enterEventDate").length()>0) {
		editRequest.setEventdate(java.sql.Date.valueOf(req.getParameter("enterEventDate")));
		}
		
		if(req.getParameter("enterRequestValue").length()>0) {
			editRequest.setRequestvalue(Double.parseDouble(req.getParameter("enterRequestValue")));
		}
		
		if(req.getParameter("enterRequestDescription").length()>0) {
		editRequest.setRequestdescription(req.getParameter("enterRequestDescription"));
		}

		if(req.getParameter("enterRequestInformation").length()>0) {
			editRequest.setRequestinformation(req.getParameter("enterRequestInformation"));
			}
		
		editRequest.setRequeststatus("Pending");
//		editRequest.s;
		System.out.println("Updating: " + editRequest);
		
		evasDao.createRequest(editRequest);
		resp.sendRedirect("index.html");

		//		doGet(request, response);
	}

}