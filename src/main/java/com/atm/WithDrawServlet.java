package com.atm;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@SuppressWarnings("serial")
@WebServlet("/withdraw")

public class WithDrawServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res)
	throws ServletException ,IOException
	{
		HttpSession hs=req.getSession(false);
		if(hs==null) {
			
		}
		else {
			CardBean cb=(CardBean)hs.getAttribute("cbean");
			long amount=Long.parseLong(req.getParameter("withdrwa"));
			if(cb.getBalance()>amount) {
				
				long amt=cb.getBalance();
				cb.setBalance(amount);
				int k=new WithDrawDAO().widrow(cb);
				
				if(k>0) {
					long setamount=amt-amount;
					cb.setBalance(setamount);
					req.setAttribute("msg", "WithDraw SuccesFully...!");
					req.getRequestDispatcher("insert.jsp").forward(req, res);			
				}
				
				
				
				
				
			}
			
		}
	}
		

}
