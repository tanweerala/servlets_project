package com.cetpa;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/cetpa")
public class DemoServlet implements Servlet
{
	public DemoServlet()
	{
		System.out.println("Intantiating servlet class");
	}
	static
	{
		System.out.println("Loading servlet class");
	}
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException 
	{
		System.out.println("Service method invoked");
	}
	public void destroy() 
	{
		System.out.println("Destroying servlet");
	}
	public ServletConfig getServletConfig() 
	{
		System.out.println("getServletConfig() method invoked");
		return null;
	}
	public String getServletInfo() 
	{
		System.out.println("getServletInfo() method invoked");
		return null;
	}
	public void init(ServletConfig arg0) throws ServletException 
	{
		System.out.println("Initializng servlet");
	}
}
