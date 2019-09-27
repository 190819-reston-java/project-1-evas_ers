package com.revature.driver;

import com.revature.repository.EvasDAO;
import com.revature.repository.EvasJDBC;
import com.revature.util.ConnectionUtil;

public class Driver {
/**
 * EVAS Online Driver
 * @param args
 */
	public static void main(String[] args) {
		
		ConnectionUtil.getConnection();

		EvasDAO test1 = new EvasJDBC();
		System.out.println(test1.getEmailandPass("fursa@evas.com", "FU9630"));


		System.out.println("hi");
	}

}
