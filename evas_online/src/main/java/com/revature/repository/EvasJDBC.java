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
import com.revature.model.MultiModelMode;
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

	@Override
	public Employee getReportTo(Employee em) {
		Employee reportstomanager = null;
		try (Connection conn = ConnectionUtil.getConnection()) {
			String query = "SELECT * FROM reportto";
			try (PreparedStatement stmt = conn.prepareStatement(query)) {
//				stmt.setInt(1, em.getEmployeeid());
//				stmt.setString(2, em.getEmployeelastname());
//				stmt.setString(3, em.getEmployeefirstname());
//				stmt.setString(4, em.getEmployeeposition());
//				stmt.setString(5, em.getEmployeeemail());
//				stmt.setString(6, em.getEmployeepassword());
				
				
				if (stmt.execute()) {
					try (ResultSet resultSet = stmt.getResultSet()) {
						if (resultSet.next()) {
							reportstomanager = createEmployeeFormRS(resultSet);
						}
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return reportstomanager;
	}


	// creating a request
	@Override
	public boolean createRequest(Request rc) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		String query = "INSERT INTO request VALUES (DEFAULT,?,?,?,?,?,?,?,Default);";

		try {
			conn = ConnectionUtil.getConnection();
			stmt = conn.prepareStatement(query);
			//stmt.setInt(8, rc.getRequestid());
			stmt.setDouble(1, rc.getRequestvalue());
			stmt.setString(2, rc.getRequeststatus());
			stmt.setString(3, rc.getRequestcatagory());
			stmt.setString(4, rc.getRequestdescription());
			stmt.setDate(5, rc.getRequestdate());
			stmt.setDate(6, rc.getEventdate());
			stmt.setString(7, rc.getRequestinformation());
			//stmt.setInt(9, rc.getEmployeerequest());
			
			//System.out.println(stmt.toString());
			
			stmt.execute();
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

	
	// updates employee
	@Override
	public boolean updateEmployee(Employee em) {
		Connection conn = null;
		PreparedStatement stmt = null;

		final String query = "UPDATE employee SET employeelastname=?, employeefirstname=?, employeeposition=?, employeeemail=?, employeepassword=? WHERE employeeid = ?;";
		try {
			conn = ConnectionUtil.getConnection();
			stmt = conn.prepareStatement(query);
			stmt.setString(1, em.getEmployeelastname());
			stmt.setString(2, em.getEmployeefirstname());
			stmt.setString(3, em.getEmployeeposition());
			stmt.setString(4, em.getEmployeeemail());
			stmt.setString(5, em.getEmployeepassword());
			stmt.setInt(6, em.getEmployeeid());
			
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

	
	// updates request
	@Override//works
	public boolean updateRequest(Request ru) {
	
	//public boolean updateRequest(int requestid, double requestvalue, String requeststatus, String requestcatagory,
	//		String requestdescription, Date requestdate, Date eventdate, String requestinformation) {
		Connection conn = null;
		PreparedStatement stmt = null;
		//Request ru = null;
		
		final String query = "UPDATE request SET requestvalue=?, requeststatus=?, requestcatagory = ?, requestdescription = ?, requestdate=?, eventdate=?, requestinformation = ? WHERE requestid = ? ;";
		try {
			conn = ConnectionUtil.getConnection();
			stmt = conn.prepareStatement(query);
				
			stmt.setDouble(1, ru.getRequestvalue());
			stmt.setString(2, ru.getRequeststatus());
			stmt.setString(3, ru.getRequestcatagory());
			stmt.setString(4, ru.getRequestdescription());
			stmt.setDate(5, ru.getRequestdate());
			stmt.setDate(6, ru.getEventdate());
			stmt.setString(7, ru.getRequestinformation());
			stmt.setInt(8, ru.getRequestid());
			
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
	
	// gets reimbursement by id
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
	public Reimbursement getEmployeeReimbursement(int employeeid) {
		Reimbursement remoteEReimbursement = null;

		try (Connection conn = ConnectionUtil.getConnection()) {
			String query = "SELECT * FROM reimbursement WHERE employeereimbursement= ?;";
			try (PreparedStatement stmt = conn.prepareStatement(query)) {
				stmt.setInt(1, employeeid);
				if (stmt.execute()) {
					try (ResultSet resultSet = stmt.getResultSet()) {
						if (resultSet.next()) {
							remoteEReimbursement = createReimbursementFromRS(resultSet);

						}
					}

				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return remoteEReimbursement;
	}
	@Override
	public List<Reimbursement> getEmployeeReimbursements(int employeeid) {
		Statement stmt = null;
		ResultSet resultSet = null;
		Connection conn = null;

		List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();

		try {
			conn = ConnectionUtil.getConnection();
			stmt = conn.createStatement();
			resultSet = stmt.executeQuery("SELECT * FROM reimbursement WHERE employeereimbursement = ?;");
			((PreparedStatement) stmt).setInt(1, employeeid);
			
			
			while (resultSet.next()) {
				reimbursements.add(createReimbursementFromRS(resultSet));
			}
		}
			catch (SQLException e) {
				e.printStackTrace();
			} finally {
				StreamCloser.close(resultSet);
				StreamCloser.close(stmt);
				StreamCloser.close(conn);
			}
		return reimbursements;

	}
	
	@Override//pulls employees
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
	
	// pulls Requests
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
	
	//pulls reimbursement
	@Override
	public List<Reimbursement> getReimbursement(Reimbursement ar) {
		Statement stmt = null;
		ResultSet resultSet = null;
		Connection conn = null;
		
		List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
		
		try {
			conn = ConnectionUtil.getConnection();
			stmt = conn.createStatement();
			resultSet = stmt.executeQuery("SELECT * FROM reimbursement;");
			while (resultSet.next()) {
				reimbursements.add(createReimbursementFromRS(resultSet));
			}
		}
			catch (SQLException e) {
				e.printStackTrace();
			} finally {
				StreamCloser.close(resultSet);
				StreamCloser.close(stmt);
				StreamCloser.close(conn);
			}
		return reimbursements;
	
	}
	
	//pulls images
	@Override
	public List<Image> getImage(Image ia) {
		Statement stmt = null;
		ResultSet resultSet = null;
		Connection conn = null;
		
		List<Image> images = new ArrayList<Image>();
		
		try {
			conn = ConnectionUtil.getConnection();
			stmt = conn.createStatement();
			resultSet = stmt.executeQuery("SELECT * FROM image;");
			while (resultSet.next()) {
				images.add(createImageFromRS(resultSet));
			}
		}
			catch (SQLException e) {
				e.printStackTrace();
			} finally {
				StreamCloser.close(resultSet);
				StreamCloser.close(stmt);
				StreamCloser.close(conn);
			}
		return images;
	
	}

	// wip inserting image to db 1
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
	
	// wip inserting image 2
	@Override
	public void addImage(int id, byte[] image) {
		Connection conn = null;
		try {
			conn = ConnectionUtil.getConnection();
			Statement statement = conn.createStatement();
			PreparedStatement ps = conn.prepareStatement("INSERT INTO image VALUES (?, ?, ?)");
			ps.setInt(1, id);
			ps.setBytes(2, image);
			ps.executeUpdate();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (Exception e) {
			}
		}
	}
	
	// wip getting image from db
	@Override
	public byte[] getImage(int id) {
		byte[] byteImg = null;
		Connection conn = null;
		try {
			conn = ConnectionUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT image FROM image WHERE id = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				 byteImg = rs.getBytes(1);
			}
			rs.close();
			ps.close();
			return byteImg;
		}catch (Exception e) {
			return null;
		}
		
	
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
				//resultSet.getInt("employeerequest"),
				
	}

	private Request createRequestManagerFromRS(ResultSet resultSet) throws SQLException {
		return new Request(
				
				resultSet.getInt("requestid"),
				resultSet.getDouble("requestvalue"),
				resultSet.getString("requeststatus"),
				resultSet.getString("requestcatagory"),
				resultSet.getString("requestdescription"),
				resultSet.getDate("requestdate"),
				resultSet.getDate("eventdate"),
				resultSet.getString("requestinformation"),
				resultSet.getInt("employeerequest"));
				
	}
	
	
	

	private static java.sql.Date getDate() {
	    java.util.Date today = new java.util.Date();
	    return new java.sql.Date(today.getTime());
	}

	@Override
	public List<Request> viewRequestManager(Request rm) {
		Statement stmt = null;
		ResultSet resultSet = null;
		Connection conn = null;
		
		List<Request> requestmanager = new ArrayList<Request>();
		
		try {
			conn = ConnectionUtil.getConnection();
			stmt = conn.createStatement();
			resultSet = stmt.executeQuery("SELECT * FROM request_with_manager;");
			while (resultSet.next()) {
				System.out.println(resultSet);
			}
		}
			catch (SQLException e) {
				e.printStackTrace();
			} finally {
				StreamCloser.close(resultSet);
				StreamCloser.close(stmt);
				StreamCloser.close(conn);
			}
		return requestmanager;
	}

	@Override
	public List<MultiModelMode> getRequestViewManager(MultiModelMode rm) {
		Statement stmt = null;
		ResultSet resultSet = null;
		Connection conn = null;
		
		List<MultiModelMode> requestviewmanager = new ArrayList<MultiModelMode>();
		
		try {
			conn = ConnectionUtil.getConnection();
			stmt = conn.createStatement();
			resultSet = stmt.executeQuery("SELECT * FROM request_with_manager;");
			while (resultSet.next()) {
				requestviewmanager .add(createMultiModelFormRS(resultSet));
			}
		}
			catch (SQLException e) {
				e.printStackTrace();
			} finally {
				StreamCloser.close(resultSet);
				StreamCloser.close(stmt);
				StreamCloser.close(conn);
			}
		
		
		
		return requestviewmanager;
	}

	private MultiModelMode createMultiModelFormRS(ResultSet resultSet) throws SQLException {
		return new MultiModelMode(
				resultSet.getInt("Employee Id"),
				resultSet.getString("Employee Name"),
				resultSet.getDouble("Requested Amount"),
				resultSet.getString("Catagory"),
				resultSet.getString("Description"),
				resultSet.getString("Information"),
				resultSet.getString("Status"),
				resultSet.getString("Manager"));
				
	}

	@Override
	public List<MultiModelMode> getViewPending(MultiModelMode vp) {
		Statement stmt = null;
		ResultSet resultSet = null;
		Connection conn = null;
		
		List<MultiModelMode> requestviewpending = new ArrayList<MultiModelMode>();
		
		try {
			conn = ConnectionUtil.getConnection();
			stmt = conn.createStatement();
			resultSet = stmt.executeQuery("SELECT * FROM viewpending");
			while (resultSet.next()) {
				requestviewpending .add(createMultiModelFormRS(resultSet));
			}
		}
			catch (SQLException e) {
				e.printStackTrace();
			} finally {
				StreamCloser.close(resultSet);
				StreamCloser.close(stmt);
				StreamCloser.close(conn);
			}
		
		
		
		return requestviewpending;
	}

	@Override
	public List<MultiModelMode> getViewResolved(MultiModelMode vr) {
		Statement stmt = null;
		ResultSet resultSet = null;
		Connection conn = null;
		
		List<MultiModelMode> requestviewresolved = new ArrayList<MultiModelMode>();
		
		try {
			conn = ConnectionUtil.getConnection();
			stmt = conn.createStatement();
			resultSet = stmt.executeQuery("SELECT * FROM viewresolved");
			while (resultSet.next()) {
				requestviewresolved .add(createMultiModelFormRS(resultSet));
			}
		}
			catch (SQLException e) {
				e.printStackTrace();
			} finally {
				StreamCloser.close(resultSet);
				StreamCloser.close(stmt);
				StreamCloser.close(conn);
			}
		
		
		
		return requestviewresolved;
	}

	@Override
	public List<MultiModelMode> getViewDenied(MultiModelMode vd) {
		Statement stmt = null;
		ResultSet resultSet = null;
		Connection conn = null;
		
		List<MultiModelMode> requestviewdenied = new ArrayList<MultiModelMode>();
		
		try {
			conn = ConnectionUtil.getConnection();
			stmt = conn.createStatement();
			resultSet = stmt.executeQuery("SELECT * FROM viewdenied");
			while (resultSet.next()) {
				requestviewdenied .add(createMultiModelFormRS(resultSet));
			}
		}
			catch (SQLException e) {
				e.printStackTrace();
			} finally {
				StreamCloser.close(resultSet);
				StreamCloser.close(stmt);
				StreamCloser.close(conn);
			}
		
		
		
		return requestviewdenied;
	}

	@Override
	public List<MultiModelMode> getMyPending(int employeerequest){//MultiModelMode mp) {
		//Statement stmt = null;
		//ResultSet resultSet = null;
		//Connection conn = null;
		
		List<MultiModelMode> requestmypending = new ArrayList<MultiModelMode>();

		try (Connection conn = ConnectionUtil.getConnection()) {
		String query = "SELECT r.employeerequest \"Employee Id\", concat(e.employeefirstname , ' ', e.employeelastname) \"Employee Name\", r.requestvalue \"Requested Amount\", r.requestcatagory \"Catagory\", r.requestdescription \"Description\", r.requestinformation \"Information\", r.requeststatus \"Status\", concat(m.employeefirstname , ' ', m.employeelastname) \"Manager\" \r\n" + 
				"FROM request r INNER join employee e ON r.employeerequest = e.employeeid INNER JOIN employee m ON m.employeeid = e.reportsto WHERE r.requeststatus = 'pending' AND e.employeeid = ?;";
		try (PreparedStatement stmt = conn.prepareStatement(query)) {
			stmt.setInt(1, employeerequest);
			if (stmt.execute()) {
				try (ResultSet resultSet = stmt.getResultSet()) {
					while (resultSet.next()) {
						requestmypending.add(createMultiModelFormRS(resultSet));
					}
				}
			}
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	return requestmypending;
}		
		
		


	@Override
	public List<MultiModelMode> getMyResolved(int employeerequest) {
		List<MultiModelMode> requestmyresolved = new ArrayList<MultiModelMode>();

		try (Connection conn = ConnectionUtil.getConnection()) {
		String query = "SELECT r.employeerequest \"Employee Id\", concat(e.employeefirstname , ' ', e.employeelastname) \"Employee Name\", r.requestvalue \"Requested Amount\", r.requestcatagory \"Catagory\", r.requestdescription \"Description\", r.requestinformation \"Information\", r.requeststatus \"Status\", concat(m.employeefirstname , ' ', m.employeelastname) \"Manager\" \r\n" + 
				"FROM request r INNER join employee e ON r.employeerequest = e.employeeid INNER JOIN employee m ON m.employeeid = e.reportsto WHERE r.requeststatus = 'resolved' AND e.employeeid = ?;";
		try (PreparedStatement stmt = conn.prepareStatement(query)) {
			stmt.setInt(1, employeerequest);
			if (stmt.execute()) {
				try (ResultSet resultSet = stmt.getResultSet()) {
					while (resultSet.next()) {
						requestmyresolved.add(createMultiModelFormRS(resultSet));
					}
				}
			}
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	return requestmyresolved;
}		

	@Override
	public List<MultiModelMode> getMyDenied(int employeerequest) {
		List<MultiModelMode> requestmydenied = new ArrayList<MultiModelMode>();

		try (Connection conn = ConnectionUtil.getConnection()) {
		String query = "SELECT r.employeerequest \"Employee Id\", concat(e.employeefirstname , ' ', e.employeelastname) \"Employee Name\", r.requestvalue \"Requested Amount\", r.requestcatagory \"Catagory\", r.requestdescription \"Description\", r.requestinformation \"Information\", r.requeststatus \"Status\", concat(m.employeefirstname , ' ', m.employeelastname) \"Manager\" \r\n" + 
				"FROM request r INNER join employee e ON r.employeerequest = e.employeeid INNER JOIN employee m ON m.employeeid = e.reportsto WHERE r.requeststatus = 'denied' AND e.employeeid = ?;";
		try (PreparedStatement stmt = conn.prepareStatement(query)) {
			stmt.setInt(1, employeerequest);
			if (stmt.execute()) {
				try (ResultSet resultSet = stmt.getResultSet()) {
					while (resultSet.next()) {
						requestmydenied.add(createMultiModelFormRS(resultSet));
					}
				}
			}
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	return requestmydenied;
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
