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
import com.revature.util.StreamCloser;

public class EvasJDBC implements EvasDAO {

	// getting email and password for login
	@Override
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
	public boolean createRequest(Request r) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		String query = "INSERT INTO request VALUES (DEFAULT, ?,?,?,?,?,?);";

		try {
			conn = ConnectionUtil.getConnection();
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, r.getRequestid());
			stmt.setInt(2, r.getRequestvalue());
			stmt.setString(3, r.getRequeststatus());
			stmt.setString(4, r.getRequestcatagory());
			stmt.setString(5, r.getRequestdescription());
			stmt.setDate(6, r.getRequestdate());
			stmt.setDate(7, r.getEventdate());
			stmt.setString(8, r.getRequestinformation());
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

	@Override
	public boolean updateRequest(Request ru) {
		Connection conn = null;
		PreparedStatement stmt = null;

		final String query = "UPDATE request SET requestvalue=?, requeststatus=?, requestcatagory=?, requestdescription=?, requestdate=?, eventdate=? requestinformation=? WHERE requestid = ?;";
		try {
			conn = ConnectionUtil.getConnection();
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, ru.getRequestid());
			stmt.setInt(2, ru.getRequestvalue());
			stmt.setString(3, ru.getRequeststatus());
			stmt.setString(4, ru.getRequestcatagory());
			stmt.setString(5, ru.getRequestdescription());
			stmt.setDate(6, ru.getRequestdate());
			stmt.setDate(7, ru.getEventdate());
			stmt.setString(8, ru.getRequestinformation());
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
				resultSet.getInt("requestvalue"),
				resultSet.getString("requeststatus"),
				resultSet.getString("requestcatagory"),
				resultSet.getString("requestdescription"),
				resultSet.getDate("requestdate"),
				resultSet.getDate("eventdate"),
				resultSet.getString("requestinformation"));
	}
	
//class closed
}
