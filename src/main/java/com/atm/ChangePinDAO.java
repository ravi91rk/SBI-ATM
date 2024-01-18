package com.atm;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ChangePinDAO {

	public int k=0;
	public int  change(CardBean cb) {
		
		try {
			Connection con=DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement
					("update atm set PIN=? where CARDNUM=?");
			ps.setInt(1, cb.getPin());
			ps.setLong(2, cb.getCardNumber());
			
			k=ps.executeUpdate();
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return k;
		
		
	}

}
