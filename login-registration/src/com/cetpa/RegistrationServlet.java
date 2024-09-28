package com.cetpa;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

@WebServlet("/register-user")
public class RegistrationServlet extends HttpServlet 
{
	public void service(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
	{
		String userid=req.getParameter("uid");
		String password=req.getParameter("pass");
		String name=req.getParameter("name");
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp2","root","mysql");
			PreparedStatement ps=cn.prepareStatement("insert into user values(?,?,?)");
			ps.setString(1,userid);
			ps.setString(2,password);
			ps.setString(3,name);
			ps.executeUpdate();
			PrintWriter pw=res.getWriter();
			pw.println("<html>");
			pw.println("<body>");
			pw.println("<div style='text-align:center'>");
			pw.println("<h1>Dear "+name+" you have been registered successfully</h1>");
			pw.println("<a href='login.html' style='font-size:20px'>Click to login</a>");
			pw.println("</div>");
			pw.println("</body>");
			pw.println("</html>");
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
	}
}
