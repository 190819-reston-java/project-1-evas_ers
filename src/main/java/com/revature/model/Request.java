package com.revature.model;

import java.sql.Date;

public class Request {
	
	private int requestid;
	private double requestvalue;
	private String requeststatus;
	private String requestcatagory;
	private String requestdescription;
	private Date requestdate;
	private Date eventdate;
//	private int employeerequest;
	private String requestinformation;
	
//	public int getEmployeerequest() {
//		return employeerequest;
//	}
//
//
//	public void setEmployeerequest(int employeerequest) {
//		this.employeerequest = employeerequest;
//	}


	
	
	//default constructor for jackson
	public Request() {
		super();
	}


	//generate by Source Menu - Constructor
	public Request(int requestid, double requestvalue, String requeststatus, String requestcatagory,
			String requestdescription, Date requestdate, Date eventdate, String requestinformation) {
		super();
		this.requestid = requestid;
		this.requestvalue = requestvalue;
		this.requeststatus = requeststatus;
		this.requestcatagory = requestcatagory;
		this.requestdescription = requestdescription;
		this.requestdate = requestdate;
		this.eventdate = eventdate;
		this.requestinformation = requestinformation;
	}

	
//	public Request(int requestid, double requestvalue, String requeststatus, String requestcatagory,
//			String requestdescription, Date requestdate, Date eventdate, String requestinformation) {
//		super();
//		this.requestid = requestid;
//		this.requestvalue = requestvalue;
//		this.requeststatus = requeststatus;
//		this.requestcatagory = requestcatagory;
//		this.requestdescription = requestdescription;
//		this.requestdate = requestdate;
//		this.eventdate = eventdate;
//		//this.employeerequest = employeerequest;
//		this.requestinformation = requestinformation;
//	}


	public Request(int requestid, double requestvalue, String requeststatus, Date requestdate,
			Date eventdate) {
		super();
		this.requestid = requestid;
		this.requestvalue = requestvalue;
		this.requeststatus = requeststatus;
		this.requestdate = requestdate;
		this.eventdate = eventdate;
	}
	
	public Request(double requestvalue, String requeststatus, String requestcatagory,
			String requestdescription, Date requestdate, Date eventdate, String requestinformation) {
		super();
		this.requestvalue = requestvalue;
		this.requeststatus = requeststatus;
		this.requestcatagory = requestcatagory;
		this.requestdescription = requestdescription;
		this.requestdate = requestdate;
		this.eventdate = eventdate;
		this.requestinformation = requestinformation;
	}


	//generate by Source Menu - Getter and Setter
	public int getRequestid() {
		return requestid;
	}
	public void setRequestid(int requestid) {
		this.requestid = requestid;
	}
	public double getRequestvalue() {
		return requestvalue;
	}
	public void setRequestvalue(double requestvalue) {
		this.requestvalue = requestvalue;
	}
	public String getRequeststatus() {
		return requeststatus;
	}
	public void setRequeststatus(String requeststatus) {
		this.requeststatus = requeststatus;
	}
	public Date getRequestdate() {
		return requestdate;
	}
	public void setRequestdate(Date requestdate) {
		this.requestdate = requestdate;
	}
	public Date getEventdate() {
		return eventdate;
	}
	public void setEventdate(Date eventdate) {
		this.eventdate = eventdate;
	}
	
	public String getRequestcatagory() {
		return requestcatagory;
	}

	public void setRequestcatagory(String requestcatagory) {
		this.requestcatagory = requestcatagory;
	}

	public String getRequestdescription() {
		return requestdescription;
	}

	public void setRequestdescription(String requestdescription) {
		this.requestdescription = requestdescription;
	}

	public String getRequestinformation() {
		return requestinformation;
	}

	public void setRequestinformation(String requestinformation) {
		this.requestinformation = requestinformation;
	}


	@Override
	public String toString() {
		return "Request [requestid=" + requestid + ", requestvalue=" + requestvalue + ", requeststatus=" + requeststatus
				+ ", requestcatagory=" + requestcatagory + ", requestdescription=" + requestdescription
				+ ", requestdate=" + requestdate + ", eventdate=" + eventdate + "requestinformation=" + requestinformation + "]";
	}

	//generated by Source Menu - toString
	
	
	
}