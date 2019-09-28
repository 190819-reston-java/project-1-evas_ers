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
							remoteEmployee = createEmployeeFomRS(resultSet);
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

		String query = "INSERT INTO request VALUES (DEFAULT, ?,?,?,?,?);";

		try {
			conn = ConnectionUtil.getConnection();
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, r.getRequestid());
			stmt.setInt(2, r.getRequestvalue());
			stmt.setString(3, r.getRequeststatus());
			stmt.setDate(4, r.getRequestdate());
			stmt.setDate(5, r.getEventdate());
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

		String query = "INSERT INTO  VALUES (DEFAULT, ?,?);";

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

		final String query = "UPDATE request SET requestvalue=?, requeststatus=?, requestdate=?, eventdate=? WHERE requestid = ?;";
		try {
			conn = ConnectionUtil.getConnection();
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, ru.getRequestvalue());
			stmt.setString(2, ru.getRequeststatus());
			stmt.setDate(3, ru.getRequestdate());
			stmt.setDate(4, ru.getEventdate());
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
	private Employee createEmployeeFomRS(ResultSet resultSet) throws SQLException {
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
				resultSet.getDate("reimbursementdate"));
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
				resultSet.getDate("requestdate"),
				resultSet.getDate("eventdate"));
	}
	
//class closed
}
