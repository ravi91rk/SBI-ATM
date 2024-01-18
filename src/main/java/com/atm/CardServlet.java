package com.atm;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@SuppressWarnings("serial")
@WebServlet("/log")
public class CardServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req ,HttpServletResponse res)
	throws ServletException, IOException{
		
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		
		CardBean cb=new CardDAO().getData(req);
	
		
		if(cb==null) {
			pw.println("invaled card type");
			req.getRequestDispatcher("Home.html").include(req, res);
		}
		else {
			HttpSession hs= req.getSession();
			hs.setAttribute("cbean", cb);
			req.getRequestDispatcher("viewDetails.jsp").forward(req, res);
		}
		
		
		
	}
	
	 
}
