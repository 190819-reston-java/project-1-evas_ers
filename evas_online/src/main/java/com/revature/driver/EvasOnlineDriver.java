package com.revature.driver;

import java.sql.Date;

import org.apache.log4j.Logger;

import com.revature.model.Employee;
import com.revature.model.Image;
import com.revature.model.MultiModelMode;
import com.revature.model.Reimbursement;
import com.revature.model.Request;
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
		logger.debug("Connection test");
		ConnectionUtil.getConnection();

		
		// create testing from db to forward
		EvasDAO evasDao = new EvasJDBC();
		
		
		
		logger.info("getEmailandPass"); // works
			//System.out.println(evasDao.getEmailandPass("ev", "4321"));
		
		logger.info("getReportTo"); // wip
			//Employee em = new Employee();
			//System.out.println(evasDao.getReportTo(em));	
			
		logger.info("getRequest"); // works
			System.out.println(evasDao.getRequest(8));
		
		logger.info("updateEmployee"); // works
			//Employee ru = new Employee(10, "Spring", "Java", "Coder", "jspring@evas.com", "js9876");
				//System.out.println(evasDao.updateEmployee(ru));
		
		
		logger.info("updateRequest");// works
			//Request ru = new Request(8, 15.28, "pending", "Fuel", "Work-related", java.sql.Date.valueOf("2019-09-28"), java.sql.Date.valueOf("2019-10-01"), "Short trip");
				//System.out.println(evasDao.updateRequest(ru));
		
		logger.info("createRequest"); //works !
			//Request rc = new Request(11, 5.25, "pending", "Travel", "Work-Related", java.sql.Date.valueOf("2019-07-01"), java.sql.Date.valueOf("2019-10-29"), "public transit");
				//System.out.println(evasDao.createRequest(rc));
		
		logger.info("getEmployeee List"); // works
			//Employee ea = new Employee ();
			//System.out.println(evasDao.getEmployee(ea));
		
		logger.info("getRequest List"); // works
			//Request ra = new Request ();
			//System.out.println(evasDao.getRequest(ra));
			
		logger.info("getReimbursement List"); // works
			//Reimbursement ar = new Reimbursement ();
			//System.out.println(evasDao.getReimbursement(ar));	
			
		logger.info("getImage List"); // wip array works .. need images
			//Image ia = new Image();
			//System.out.println(evasDao.getImage(ia));	
		
		logger.info("insertImage"); // not working
			//System.out.println(evasDao.insertImage(smilyface, image));
		
		logger.info("getEmployeeReimbursements");
			//System.out.println(evasDao.getEmployeeReimbursement(5));

		logger.info("getRequest with manager List");// wip[]
			//Request rm = new Request ();
			//System.out.println(evasDao.viewRequestManager(rm));
			
//			logger.info("getRequest with manager List");// works	
//			MultiModelMode rm = new MultiModelMode();
//			System.out.println(evasDao.getRequestViewManager(rm));
//			
//			logger.info("getViewPending");// works
//			MultiModelMode vp = new MultiModelMode();
//			System.out.println(evasDao.getViewPending(vp));
//			
//			logger.info("getViewResolved");// works
//			MultiModelMode vr = new MultiModelMode();
//			System.out.println(evasDao.getViewResolved(vr));
//			
//			logger.info("getViewDenied");// works
//			MultiModelMode vd = new MultiModelMode();
//			System.out.println(evasDao.getViewDenied(vd));
//			
//			logger.info("getMyPending");// works
//			System.out.println(evasDao.getMyPending(9));
//			
//			logger.info("getMyResolved");// works
//			System.out.println(evasDao.getMyResolved(9));
//			
//			logger.info("getMyDenied");// works
//			System.out.println(evasDao.getMyDenied(5));
			
			
		
		System.out.println("result end");
	}

}
