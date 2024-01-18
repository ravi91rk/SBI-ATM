package com.atm;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@SuppressWarnings("serial")
@WebServlet("/changepin")
public class ChangePinServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
	throws ServletException,IOException
	{
		HttpSession hs=req.getSession();
		if(hs==null) {
			req.setAttribute("msg", "Session Expired");
			req.getRequestDispatcher("insert.jsp").forward(req, res);
		}
		else {
			CardBean cb= (CardBean)hs.getAttribute("cbean");
			cb.setPin(Integer.parseInt( req.getParameter("pin")));
			int k =new ChangePinDAO().change(cb);
			if(k>0) {
				req.setAttribute("msg", "Pin Succesfully change");
				req.getRequestDispatcher("pin.jsp").forward(req, res);
			}
		}
	}

}
