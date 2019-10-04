package com.revature.model;

public class MultiModelMode {

	private int employeerequest;
	private String employeename;
	private Double requestvalue;
	private String requestcatagory;
	private String requestdescription;
	private String requestinformation;
	private String requeststatus;
	private String manager;
	private int transaction;
	
	public int getTransaction() {
		return transaction;
	}
	public void setTransaction(int transaction) {
		this.transaction = transaction;
	}
	public MultiModelMode(int transaction, int employeerequest, String employeename, Double requestvalue, String requestcatagory,
			String requestdescription, String requestinformation, String requeststatus, String manager) {
		super();
		this.employeerequest = employeerequest;
		this.employeename = employeename;
		this.requestvalue = requestvalue;
		this.requestcatagory = requestcatagory;
		this.requestdescription = requestdescription;
		this.requestinformation = requestinformation;
		this.requeststatus = requeststatus;
		this.manager = manager;
		this.transaction = transaction;
	}
	public MultiModelMode() {
		super();
	}
	public int getEmployeerequest() {
		return employeerequest;
	}
	public void setEmployeerequest(int employeerequest) {
		this.employeerequest = employeerequest;
	}
	public String getEmployeename() {
		return employeename;
	}
	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}
	public Double getRequestvalue() {
		return requestvalue;
	}
	public void setRequestvalue(Double requestvalue) {
		this.requestvalue = requestvalue;
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
	public String getRequeststatus() {
		return requeststatus;
	}
	public void setRequeststatus(String requeststatus) {
		this.requeststatus = requeststatus;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	@Override
	public String toString() {
		return "MultiModelMode [employeerequest=" + employeerequest + ", employeename=" + employeename
				+ ", requestvalue=" + requestvalue + ", requestcatagory=" + requestcatagory + ", requestdescription="
				+ requestdescription + ", requestinformation=" + requestinformation + ", requeststatus=" + requeststatus
				+ ", manager=" + manager + ", transaction=" + transaction + "]";
	}
	
	
	
	
	
	
}