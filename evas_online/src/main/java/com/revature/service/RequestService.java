package com.revature.service;

import com.revature.model.Request;
import com.revature.repository.EvasDAO;

public class RequestService {

	private Request openrequest;
	private EvasDAO evasDao;

	public RequestService(EvasDAO evasDAO) {
		this.evasDao = evasDao;
		this.openrequest = new Request();
			
	}
	
	public Request getOpenRequest() {
		return openrequest;
	}
	
	public void setOpenRequest(Request openRequest) {
		this.openrequest = openrequest;
	}
	
	public boolean createRequest(Request r) {
		return EvasDAO.createRequest(r);
	}
	
	public boolean updateRequest(Request ru) {
		return EvasDAO.updateRequest(ru);
	}
	
}
