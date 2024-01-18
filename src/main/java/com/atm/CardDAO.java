package com.atm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;

public class CardDAO {
	
	public CardBean cb =null;
	
	public CardBean getData(HttpServletRequest req)
	{
		try {
			Connection con=DBConnection.getCon();
			
			PreparedStatement ps=con.prepareStatement
					("select * from atm where CARDNUM=? AND PIN=?");
			ps.setLong(1,Long.parseLong(req.getParameter("card")));
			
			ps.setInt(2,Integer.parseInt(req.getParameter("pin")));
			
			ResultSet rs= ps.executeQuery();
			if(rs.next()) {
				cb=new CardBean();
				cb.setName(rs.getString(1));
				
				cb.setCardNumber(rs.getLong(2));
				cb.setPin(rs.getInt(3));
				cb.setBalance(rs.getLong(4));
				cb.setMobile(rs.getLong(5));
			}	
		}
		catch(Exception e) {
			e.printStackTrace();
		}	
		return cb;
	}

}
