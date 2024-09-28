package com.cetpa;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;

@WebServlet("/login")
public class LoginServlet extends HttpServlet 
{
	public void service(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
	{
		String userid=req.getParameter("uid");
		String password=req.getParameter("pass");
		PrintWriter pw=res.getWriter();
		pw.println("<html><body>");
		if(userid.equals("admin") && password.equals("cetpa"))
		{
			pw.println("<h1 style='color:green'>Login success</h1>");
		}
		else
		{
			pw.println("<h1 style='color:red'>Login fail</h1>");
		}
		pw.println("</body></html>");
	}
}
