package com.revature.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.model.Employee;
import com.revature.model.Image;
import com.revature.model.Reimbursement;
import com.revature.model.Request;
import com.revature.util.ConnectionUtil;

public class EvasJDBC implements EvasDAO {

	//getting email and password for login
	@Override
	public Employee getEmailandPass(String employeeemail, String employeepassword) {
		Employee remoteEmployee = null;
			try(Connection conn = ConnectionUtil.getConnection()) {
				String query = "SELECT * FROM employee WHERE employeeemail = ? and employeepassword = ?;";
					try (PreparedStatement stmt = conn.prepareStatement(query)) {
							stmt.setString(1, employeeemail);
							stmt.setString(2, employeepassword);
								if(stmt.execute()) {
									try (ResultSet resultSet = stmt.getResultSet()) {
										if(resultSet.next()) {
											remoteEmployee = createEmployeeFomRS(resultSet);
										}
									}
								}
					}
			}catch (SQLException e) {
				e.printStackTrace();
			}
		
	return remoteEmployee;
	}

	// creating a request
	@Override
	public boolean createRequest(Request r) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String query = "INSERT INTO request VALUES (DEFAULT, ?,?,?,?,?,?);";
		
		conn = ConnectionUtil.getConnection();
		stmt = conn.prepareStatement(query);
		
		
		return false;
	}

	@Override
	public boolean updateEmployee(int employeeid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Image insertImage(int imageid, byte[] image) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateRequest(int requestid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Reimbursement getReimbursement(int reimburementid) {
		// TODO Auto-generated method stub
		return null;
	}
	
	//resultSet methods
	private Employee createEmployeeFomRS(ResultSet resultSet) throws SQLException {
		return new Employee(
				resultSet.getInt("employeeid"),
				resultSet.getString("employeelastname"),
				resultSet.getString("employeefirstname"),
				resultSet.getString("employeeposition"),
				resultSet.getString("employeeemail"),
				resultSet.getString("employeepassword"));
	}





	
//class closed
}
