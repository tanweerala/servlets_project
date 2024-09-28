package com.cetpa;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

@WebServlet("/login")
public class LoginServlet extends HttpServlet 
{
	public void service(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
	{
		String userid=req.getParameter("uid");
		String password=req.getParameter("pass");
		PrintWriter pw=res.getWriter();
		pw.println("<html>");
		pw.println("<body>");
		pw.println("<div style='text-align:center'>");
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp2","root","mysql");
			PreparedStatement ps=cn.prepareStatement("select * from user where userid=?");
			ps.setString(1,userid);
			ResultSet rst=ps.executeQuery();
			if(rst.next())
			{
				String dpass=rst.getString(2);
				if(password.equals(dpass))
				{
					res.sendRedirect("home.html");
				}
				else
				{
					pw.println("<h2 style='color:red'>Password is wrong</h2>");
					RequestDispatcher dp=req.getRequestDispatcher("login.html");
					dp.include(req,res);
				}
			}
			else
			{
				pw.println("<h2 style='color:red'>User id does not exist</h2>");
				RequestDispatcher dp=req.getRequestDispatcher("login.html");
				dp.include(req,res);
			}	
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		pw.println("</div>");
		pw.println("</body>");
		pw.println("</html>");
	}
}
