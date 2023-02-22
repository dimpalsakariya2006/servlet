package servletconcept;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.xdevapi.Statement;

@WebServlet("/myaccount")
public class MyAccount extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		String ans = req.getParameter("Answer");
		
		ServletContext sc = getServletContext();
		String ans1 = (String) sc.getAttribute("answer");
		
		Cookie[] cookie= req.getCookies();
		boolean f  = false;
		String name= "";
	
		
		
		
		if(cookie==null)
		{
			out.print("<h3>New User</h3>");
			out.print("<h3>Please Login First</h3>");
			RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
			rd.forward(req, resp);
			
		}
		else
		{
			
			for(Cookie ck :cookie)
			{
				String tname = ck.getName();
				if(tname.equals("username"))
				{
					f=true;
					name = ck.getValue();
					
				}
			}
		}
		
			if(f)
			{
				if(ans.equals(ans1))
				{
				out.print("<h2> Congratulations .. You are successfully logged in..</h2>");  
				out.print("<h3>|| Dimpal's Calculator ||</h3>");
				
				HttpSession htp1 = req.getSession(false);
				String n = (String) htp1.getAttribute("firstname");
				String n1 = (String) htp1.getAttribute("lastname");
				out.println("First name : "+n);
				out.println("<br>Last name : "+n1);
				
	            out.print("<h4>Welcome, "+name+" </h4>");
	            out.print("<form action = 'calc.jsp' method='post'>"
	            		+ "<br>"
	            		+ "<input type = 'submit' value = 'Calculator'>"
	            		+ "</form>");
	            out.print("<form action = 'shop.jsp' method='post'>"
	            		+ "<br>"
	            		+ "<input type = 'submit' value = 'Shop'>"
	            		+ "</form>");
	            out.print("<form action = 'logout' method='post'>"
	            		+ "<br>"
	            		+ "<input type = 'submit' value = 'Logout'>'"
	            		+ "</form>");
	            
				}
				else
				{
					out.print("<h2>Please enter correct answer</h2>");
					RequestDispatcher rd = req.getRequestDispatcher("myaccount.jsp");
					rd.include(req, resp);	
				}
	            
			}
			else 
			{
				out.print("<h3>Please Login First......</h3>");
				RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
				rd.include(req, resp);	
			}
			}
		}


