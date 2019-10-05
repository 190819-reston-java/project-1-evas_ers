package com.revature.frontend;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.model.MultiModelMode;
import com.revature.repository.EvasDAO;
import com.revature.repository.EvasJDBC;

/**
 * Servlet implementation class SelectRequest
 */
public class SelectRequest extends HttpServlet {
	
	MultiModelMode mmm = null;
	public static int requestOfInterest = 0;
	
	//this gets called by the request-list field to redirect to the request examination stage
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//		requestOfInterest = 0;
		requestOfInterest = Integer.parseInt(req.getParameter("id"));
        EvasDAO evasDao = new EvasJDBC();
		
		System.out.println("Investigating request #" + requestOfInterest);
		System.out.println(evasDao.getRequest(requestOfInterest));
		
		
		mmm = evasDao.getRequest(requestOfInterest);
		if(evasDao.getRequest(requestOfInterest)==null) {
			System.out.println("Nonexistant ID selected");
			resp.sendRedirect("index.html");
		} else {
		resp.sendRedirect("ReviewRequest.html");
		}
//        ObjectMapper om = new ObjectMapper();
//        PrintWriter pw = resp.getWriter();
//        
//        System.out.println("######  Sending request: "+mmm);
//        String request = om.writeValueAsString(mmm);
//        System.out.println("### " + request);
//        pw.write(request);
//        pw.close();
	}

	
	//this gets called by review-request.js to fetch the request information
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ObjectMapper om = new ObjectMapper();
        PrintWriter pw = resp.getWriter();
        
        System.out.println("######  Sending request: "+mmm);
        String request = om.writeValueAsString(mmm);
        System.out.println("### " + request);
        pw.write(request);
        pw.close();
		
	}

}
