package com.atm;



import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

import  static com.atm.DBInfo.*;
public class DBConnection {
	
	private static Connection con;
	
	static {
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,user,pass);
			
				
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static Connection getCon() {
		return con;
	}
	}
	


