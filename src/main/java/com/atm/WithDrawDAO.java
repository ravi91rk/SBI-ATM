package com.atm;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class WithDrawDAO{
	
	public int k=0;
	
	public int widrow(CardBean cb) {
		
		try {
			
			Connection con=DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement
					("update atm set BALANCE=balance-? where CARDNUM=?");
			ps.setLong(1, cb.getBalance());
			ps.setLong(2, cb.getCardNumber());
			k=ps.executeUpdate();
				
		}
		catch(Exception e) {
			
		}
		
		return k;
	}
	
	

}
