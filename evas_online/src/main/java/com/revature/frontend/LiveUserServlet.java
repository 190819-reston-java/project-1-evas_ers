package com.revature.frontend;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.model.Employee;

/**
 * Servlet implementation class LiveUserServlet
 */
public class LiveUserServlet extends HttpServlet {
	
	Employee selectedEmployee = new Employee(112, "Bradley", "James", "Janitor", "jbrad@evas.com", "asdf");

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ObjectMapper om = new ObjectMapper();
		PrintWriter pw = resp.getWriter();
		HttpSession hs = req.getSession();
//		String message = om.writeValueAsString("helloooooo!");
//		String[] myString = {"hi", "hello!!"};
//		System.out.println(hs.getAttribute("activeAccount"));
		
		
//		pw.write("{ \"hi\" : \"helllllloooooo!\"}");
		
//		om.writeValue(, selectedEmployee);
		String employeeInfo=om.writeValueAsString(selectedEmployee);
		System.out.println(employeeInfo);
		pw.write(employeeInfo);
		
//		pw.write((String)hs.getAttribute("activeAccount"));
//		String jsonAccount = om.writeValueAsString(hs.getAttribute("activeAccount"));
//		pw.write(jsonAccount);

	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter pw = resp.getWriter();
		HttpSession hs = req.getSession();
		
		pw.write("helllllloooooo!");

	}
	


}
