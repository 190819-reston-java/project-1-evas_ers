package com.revature.driver;

import com.revature.repository.EvasDAO;
import com.revature.repository.EvasJDBC;
import com.revature.util.ConnectionUtil;

public class EvasOnlineDriver {
/**
 * EVAS Online Driver
 * @param args
 */
	public static void main(String[] args) {

		System.out.println("hi");
		ConnectionUtil.getConnection();

		
		
		EvasDAO evasDao = new EvasJDBC();
		System.out.println(evasDao.getEmailandPass("fursa@evas.com", "asdf"));


		System.out.println("hi");
	}

}
