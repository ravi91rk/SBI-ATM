package com.atm;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@SuppressWarnings("serial")
@WebServlet("/Deposite")
public class DepositeServlet  extends HttpServlet {
	
	@Override
	protected  void doPost(HttpServletRequest req,HttpServletResponse res)
	throws ServletException ,IOException {
		HttpSession hs=req.getSession(false);
		if(hs==null) {
			req.setAttribute("msg", "Invalid login....!" );
			req.getRequestDispatcher("insert.jsp").forward(req, res);
			
		}else {
			int k=new DepositeDAO().insertData(req);
			CardBean cb=(CardBean)hs.getAttribute("cbean");
			System.out.println(cb.getName());
			long amount=Long.parseLong(req.getParameter("amount"));
			System.out.println(amount);
			
			if(k>0) {
				req.setAttribute("msg","Data sussuce fully inserted");
				req.getRequestDispatcher("insert.jsp").forward(req, res);
				cb.setBalance(cb.getBalance()+amount);
				System.out.println("updeted amount"+cb.getBalance());
			}
		}
		
		
		
	}

}
