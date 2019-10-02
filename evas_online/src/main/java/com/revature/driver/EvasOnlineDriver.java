package com.revature.driver;

import java.sql.Date;

import org.apache.log4j.Logger;

import com.revature.model.Employee;
import com.revature.repository.EvasDAO;
import com.revature.repository.EvasJDBC;
import com.revature.util.ConnectionUtil;


public class EvasOnlineDriver {
/**
 * EVAS Online Driver
 * @param args
 */
	public static void main(String[] args) {

		
		Logger logger = Logger.getLogger(EvasOnlineDriver.class);
		logger.debug("Conenction test");
		ConnectionUtil.getConnection();

		
		// create testing from db to forward
		EvasDAO evasDao = new EvasJDBC();
		
		
		
		logger.info("getEmailandPass"); // works
		System.out.println(evasDao.getEmailandPass("ev", "4321"));
		
		logger.info("getReimbursement"); // works
		System.out.println(evasDao.getReimbursement(8));
		
		logger.info("updateEmployee");
		//System.out.println(evasDao.updateEmployee("Spring", "Java", "Coder", "jspring@evas.com", "js456"));
		//System.out.println(evasDao.updateEmployee(null));
		
		logger.info("updateRequest");// works
		//System.out.println(evasDao.updateRequest(8, 25.58, "pending", "Fuel", "Home", java.sql.Date.valueOf("2019-09-28"), java.sql.Date.valueOf("2019-10-01"), "Short trip"));
		
		logger.info("createRequest");
		System.out.println(evasDao.createRequest(0, 10.50, "pending", "Travel", "Work-Related", java.sql.Date.valueOf("2019-07-01"), java.sql.Date.valueOf("2019-10-29"), "public transit"));
	
		
		logger.info("insertImage");
		//System.out.println(evasDao.insertImage(imagename, image));

		System.out.println("result end");
	}

}
