package com.atm;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;

public class DepositeDAO {
	
	public int k=0;
	
	public int insertData(HttpServletRequest req) {
		
		try {
			Connection con=DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement
					("update atm set BALANCE=balance+? where CARDNUM=?");
			ps.setLong(1, Long.parseLong(req.getParameter("amount")));
			ps.setLong(2, Long.parseLong(req.getParameter("cardnum")));
			k=ps.executeUpdate();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return k;
	}

}
