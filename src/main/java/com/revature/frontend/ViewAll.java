package com.revature.frontend;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.model.Employee;
import com.revature.model.MultiModelMode;
import com.revature.model.Reimbursement;
import com.revature.repository.EvasDAO;
import com.revature.repository.EvasJDBC;

/**
 * Servlet implementation class ViewAll
 */
public class ViewAll extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		EvasDAO evasDao = new EvasJDBC();
		Employee employeeService = evasDao.getEmployeeById(BasicLogin.loggedAccount);
		
//		Reimbursement ar = new Reimbursement();
		MultiModelMode rm = new MultiModelMode();
		
		ObjectMapper om = new ObjectMapper();
		PrintWriter pw = resp.getWriter();

		String transactionString = om.writeValueAsString(evasDao.getRequestViewManager(rm));
		System.out.println("ArrayList: " + evasDao.getRequestViewManager(rm));
		System.out.println("String being sent to JS: " + transactionString);
		pw.write(transactionString);
		pw.close();
		
	}

}
