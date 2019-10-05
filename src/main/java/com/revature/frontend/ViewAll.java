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
//
//		EvasDAO evasDao = new EvasJDBC();
//		Employee employeeService = evasDao.getEmployeeById(BasicLogin.loggedAccount);
//		
//		Reimbursement ar = new Reimbursement();
//		
//		ObjectMapper om = new ObjectMapper();
//		PrintWriter pw = resp.getWriter();
//
//		String transactionString = om.writeValueAsString(evasDao.getReimbursement(ar));
//		System.out.println("ArrayList: " + evasDao.getReimbursement(ar));
//		System.out.println("String being sent to JS: " + transactionString);
//		pw.write(transactionString);
		

        EvasDAO evasDao = new EvasJDBC();
        Employee employeeService = evasDao.getEmployeeById(BasicLogin.loggedAccount);
        
        MultiModelMode vp = new MultiModelMode();
        MultiModelMode vr = new MultiModelMode();
        
        ObjectMapper om = new ObjectMapper();
        PrintWriter pw = resp.getWriter();
        
//        String str = evasDao.getViewPending(vp) + evasDao.getViewResolved(vr));
//        String transactionString = om.writeValueAsString(str);
//        System.out.println("ArrayList: " + evasDao.getViewPending(vp));
//        System.out.println("String being sent to JS: " + transactionString);
//        pw.write(transactionString);
//		pw.close();
		
	}

}