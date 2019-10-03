package com.revature.frontend;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.model.Employee;
import com.revature.repository.EvasDAO;
import com.revature.repository.EvasJDBC;

/**
 * Servlet implementation class SettingsServlet
 */
public class SettingsServlet extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		EvasDAO evasDao = new EvasJDBC();
//		new Employee
		Employee editEmployee = evasDao.getEmployeeById(BasicLogin.loggedAccount);
		
		//checking if the fields have changed
		if(req.getParameter("enterEmail").length()>0) {
		editEmployee.setEmployeeemail(req.getParameter("enterEmail"));
		}
		
		if(req.getParameter("enterFirstName").length()>0) {
		editEmployee.setEmployeefirstname(req.getParameter("enterFirstName"));
		}
		
		if(req.getParameter("enterLastName").length()>0) {
		editEmployee.setEmployeelastname(req.getParameter("enterLastName"));
		}
		
		if(req.getParameter("enterNewPassword").length()>0) {
		editEmployee.setEmployeepassword(req.getParameter("enterNewPassword"));
		}
		
		System.out.println("Updating: " + editEmployee);
		
		evasDao.updateEmployee(editEmployee);
		resp.sendRedirect("index.html");

		//		doGet(request, response);
	}

}
