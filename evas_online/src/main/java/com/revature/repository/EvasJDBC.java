package com.revature.repository;

import java.sql.Array;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.Employee;
import com.revature.model.Image;
import com.revature.model.Reimbursement;
import com.revature.model.Request;
import com.revature.util.ConnectionUtil;
import com.revature.util.StreamCloser;

public class EvasJDBC implements EvasDAO {


	// getting email and password for login
	@Override // works
	public Employee getEmailandPass(String employeeemail, String employeepassword) {
		Employee remoteEmployee = null;
		try (Connection conn = ConnectionUtil.getConnection()) {
			String query = "SELECT * FROM Employee WHERE employeeemail = ? and employeepassword = ?;";
			try (PreparedStatement stmt = conn.prepareStatement(query)) {
				stmt.setString(1, employeeemail);
				stmt.setString(2, employeepassword);
				if (stmt.execute()) {
					try (ResultSet resultSet = stmt.getResultSet()) {
						if (resultSet.next()) {
							remoteEmployee = createEmployeeFormRS(resultSet);
						}
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return remoteEmployee;
	}

	// creating a request
	@Override
	public boolean createRequest(int requestid, double requestvalue, String requeststatus, String requestcatagory,
			String requestdescription, Date requestdate, Date eventdate, String requestinformation) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		String query = "INSERT INTO request VALUES (DEFAULT, ?,?,?,?,?,?,?,? );";

		try {
			conn = ConnectionUtil.getConnection();
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, requestid);
			stmt.setDouble(2, requestvalue);
			stmt.setString(3, requeststatus);
			stmt.setString(4, requestcatagory);
			stmt.setString(5, requestdescription);
			stmt.setDate(6, requestdate);
			stmt.setDate(7, eventdate);
			stmt.setString(8, requestinformation);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			StreamCloser.close(rs);
			StreamCloser.close(stmt);
			StreamCloser.close(conn);
		}

		return false;
	}

	@Override
	public boolean updateEmployee(Employee em) {
		Connection conn = null;
		PreparedStatement stmt = null;

		final String query = "UPDATE employee SET employelastname=?, employeefirstname=?, employeeposition=?, employeeemail=?, employeepassword=? WHERE employeeid = ?;";
		try {
			conn = ConnectionUtil.getConnection();
			stmt = conn.prepareStatement(query);
			stmt.setString(1, em.getEmployeelastname());
			stmt.setString(2, em.getEmployeefirstname());
			stmt.setString(3, em.getEmployeeposition());
			stmt.setString(4, em.getEmployeeemail());
			stmt.setString(5, em.getEmployeepassword());
			
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			StreamCloser.close(stmt);
			StreamCloser.close(conn);
		}
		return true;
	}

	@Override
	public Image insertImage(String imagename, byte[] image) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		String query = "INSERT INTO image VALUES (DEFAULT, ?,?);";

		try {
			conn = ConnectionUtil.getConnection();
			stmt = conn.prepareStatement(query);
			stmt.setString(1, imagename);
			stmt.setBytes(2, image);
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			StreamCloser.close(rs);
			StreamCloser.close(stmt);
			StreamCloser.close(conn);
		}

		return null;
	}

	@Override//works
	public boolean updateRequest(int requestid, double requestvalue, String requeststatus, String requestcatagory,
			String requestdescription, Date requestdate, Date eventdate, String requestinformation) {
		Connection conn = null;
		PreparedStatement stmt = null;
		//Request ru = null;
		
		final String query = "UPDATE request SET requestvalue=?, requeststatus=?, requestcatagory = ?, requestdescription = ?, requestdate=?, eventdate=?, requestinformation = ? WHERE requestid = ? ;";
		try {
			conn = ConnectionUtil.getConnection();
			stmt = conn.prepareStatement(query);
				
			stmt.setDouble(1, requestvalue);
			stmt.setString(2, requeststatus);
			stmt.setString(3, requestcatagory);
			stmt.setString(4, requestdescription);
			stmt.setDate(5, requestdate);
			stmt.setDate(6, eventdate);
			stmt.setString(7, requestinformation);
			stmt.setInt(8, requestid);
			
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			StreamCloser.close(stmt);
			StreamCloser.close(conn);
		}
		return true;
	}

	@Override
	public Reimbursement getReimbursement(int reimbursementid) {
		Reimbursement remoteReimbursement = null;

		try (Connection conn = ConnectionUtil.getConnection()) {
			String query = "SELECT * FROM reimbursement WHERE reimbursementid = ?;";
			try (PreparedStatement stmt = conn.prepareStatement(query)) {
				stmt.setInt(1, reimbursementid);
				if (stmt.execute()) {
					try (ResultSet resultSet = stmt.getResultSet()) {
						if (resultSet.next()) {
							remoteReimbursement = createReimbursementFromRS(resultSet);

						}
					}

				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return remoteReimbursement;
	}

	
	@Override
	public List<Employee> getEmployee(Employee ea) {
		Statement stmt = null;
		ResultSet resultSet = null;
		Connection conn = null;
		
		List<Employee> employees = new ArrayList<Employee>();
		
		try {
			conn = ConnectionUtil.getConnection();
			stmt = conn.createStatement();
			resultSet = stmt.executeQuery("SELECT * FROM employee;");
			while (resultSet.next()) {
				employees.add(createEmployeeFormRS(resultSet));
			}
		}
			catch (SQLException e) {
				e.printStackTrace();
			} finally {
				StreamCloser.close(resultSet);
				StreamCloser.close(stmt);
				StreamCloser.close(conn);
			}
		
		
		
		return employees;
	}
	
	@Override
	public List<Request> getRequest(Request ra) {
		Statement stmt = null;
		ResultSet resultSet = null;
		Connection conn = null;
		
		List<Request> requests = new ArrayList<Request>();
		
		try {
			conn = ConnectionUtil.getConnection();
			stmt = conn.createStatement();
			resultSet = stmt.executeQuery("SELECT * FROM request;");
			while (resultSet.next()) {
				requests.add(createRequestFromRS(resultSet));
			}
		}
			catch (SQLException e) {
				e.printStackTrace();
			} finally {
				StreamCloser.close(resultSet);
				StreamCloser.close(stmt);
				StreamCloser.close(conn);
			}
		return requests;
	}
	
	// resultSet methods
	private Employee createEmployeeFormRS(ResultSet resultSet) throws SQLException {
		return new Employee(
				resultSet.getInt("employeeid"),
				resultSet.getString("employeelastname"),
				resultSet.getString("employeefirstname"),
				resultSet.getString("employeeposition"),
				resultSet.getString("employeeemail"),
				resultSet.getString("employeepassword"));
	}

	private Reimbursement createReimbursementFromRS(ResultSet resultSet) throws SQLException {
		return new Reimbursement(
				resultSet.getInt("reimbursementid"),
				resultSet.getDouble("reimbursementamount"),
				resultSet.getDate("reimbursementdate"),
				resultSet.getString("reimbursementstatus"));
	}
	
	private Image createImageFromRS(ResultSet resultSet) throws SQLException {
		return new Image(
				resultSet.getInt("imageid"),
				resultSet.getString("imagename"),
				resultSet.getBytes("image"));
	}
	
	private Request createRequestFromRS(ResultSet resultSet) throws SQLException {
		return new Request(
				resultSet.getInt("requestid"),
				resultSet.getDouble("requestvalue"),
				resultSet.getString("requeststatus"),
				resultSet.getString("requestcatagory"),
				resultSet.getString("requestdescription"),
				resultSet.getDate("requestdate"),
				resultSet.getDate("eventdate"),
				resultSet.getString("requestinformation"));
	}

	

	private static java.sql.Date getDate() {
	    java.util.Date today = new java.util.Date();
	    return new java.sql.Date(today.getTime());
	}

//	@Override
//	public List<Request> updateRequest(int requestid, double requestvalue, String requeststatus, String requestcatagory,
//			String requestdescription, Date requestdate, Date eventdate, String requestinformation) {
//		
//		Statement stmt = null;
//		ResultSet resultSet = null;
//		Connection conn = null;
//		
//		List<Request> requests = new ArrayList<Request>();
//		
//		try {
//			conn = ConnectionUtil.getConnection();
//			stmt = conn.createStatement();
//			resultSet = stmt.executeQuery("UPDATE request SET requestvalue = ?, requeststatus = ?, requestcatagory = ?, requestdescription = ?, requestdate = ?, eventdate = ?, requestinformation = ? WHERE requestid = ?; ");
//			while (resultSet.next()) {
//				requests.add(createRequestFromRS(resultSet));
//			}
//		}
//			catch (SQLException e) {
//				e.printStackTrace();
//			} finally {
//				StreamCloser.close(resultSet);
//				StreamCloser.close(stmt);
//				StreamCloser.close(conn);
//			}
//		return requests;
//	}
//		

	

	
	
//class closed
}
