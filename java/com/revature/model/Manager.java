package com.revature.model;

public class Manager {

	private int managerid;
	private int employeeid;
	
	//generated by Source Menu - Constructor
	public Manager(int managerid, int employeeid) {
		super();
		this.managerid = managerid;
		this.employeeid = employeeid;
	}
	
	//generated by Source Menu - Getters and Setters
	public int getManagerid() {
		return managerid;
	}
	public void setManagerid(int managerid) {
		this.managerid = managerid;
	}
	public int getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
	}
	
	// generated by Source Menu - toString
	@Override
	public String toString() {
		return "Manager [managerid=" + managerid + ", employeeid=" + employeeid + "]";
	}
	
}
