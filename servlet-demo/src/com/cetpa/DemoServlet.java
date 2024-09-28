package com.cetpa;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/employee")
public class DemoServlet implements Servlet
{
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException 
	{
		String[] name= {"Amit Singh","Manoj Mishra","Hemant Pandey","Kuldeep Verma"};
		String[] department= {"Sales","Marketing","Sales","Accounts"};
		int[] salary= {90000,67000,50000,70000};
		PrintWriter pw=res.getWriter();
		pw.println("<html>");
		pw.println("<body>");
		pw.println("<table style='border-collapse:collapse;font-size:18px;width:40%' border='1'>");
		pw.println("<tr>");
		pw.println("<th>Name</th><th>Department</th><th>Salary</th>");
		pw.println("</tr>");
		for(int i=0;i<name.length;i++)
		{
			pw.println("<tr>");
			pw.println("<td>"+name[i]+"</td><td>"+department[i]+"</td><td>"+salary[i]+"</td>");
			pw.println("</tr>");
		}
		pw.println("</table>");
		pw.println("</body>");
		pw.println("</html>");
		
	}
	public void destroy() 
	{
	}
	public ServletConfig getServletConfig() 
	{
		return null;
	}
	public String getServletInfo() 
	{
		return null;
	}
	public void init(ServletConfig arg0) throws ServletException 
	{
	}
}
