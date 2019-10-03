package com.revature.service;

import java.io.File;

import org.postgresql.core.Utils;

import com.revature.repository.EvasJDBC;
import com.revature.util.ImageConversion;

//public class ImageService throws FileNotFoundException, IOException {
//
//	EvasJDBC bd = new EvasJDBC();
//	
//	String fileSource = "C:/imgSource/image.jpg"; // need to figure out how to utilize
//	String fileDestination = "C:/imgDestination/destination.jpeg"; // need to figure out how to utilize
//	
//	try {
//		
//		 byte [] byteImage = ImageConversion.ImageToByte(new File(fileSource));
//		 
//		 bd.addImage(1, byteImage);
//		 System.out.println(org.postgresql.util.Base64.encodeBytes(bd.getImage(1)));
//		Utils.byteToImage(bd.getImage(1), new File(fileDestination));
//		} catch (Exception e) {	
//		e.printStackTrace();
//		}
//	
//}

