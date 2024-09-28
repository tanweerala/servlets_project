package com.cetpa;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet 
{
	public void service(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
	{
		String name=req.getParameter("str");
		PrintWriter pw=res.getWriter();
		pw.println("<html><body>");
		pw.println("<h2>Hello "+name+"</h2>");
		pw.println("</body></html>");
	}
}
