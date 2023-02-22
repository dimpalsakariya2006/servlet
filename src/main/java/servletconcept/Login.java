package servletconcept;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebServlet(value = "/login", initParams = {
//@WebInitParam(name="email" , value = "d@gmail.com")})
		

public class Login extends HttpServlet{
	private static final long serialVersionUID = 1L;




	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		resp.setHeader("Cache-Control", "no-cache");
		resp.setHeader("Cache-control", "no-store");
		resp.setHeader("Pragma", "no-cache");
		resp.setHeader("Expires","0");
		resp.setDateHeader("Expires",0);

		String uname = req.getParameter("uname");
		String pass = req.getParameter("pass");
		
		PrintWriter out = resp.getWriter();
		
//		ServletContext sc = getServletConfig().getServletContext();
//		String s1= (String)sc.getAttribute("name");
//		String s2 = (String)sc.getAttribute("password");
//		
//		String s4 = (String)sc.getAttribute("ans");
		
		ServletConfig sf = getServletConfig();
		String email = sf.getInitParameter("email");
		out.println("<br>Email is : "+email);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/registration","root","Nikunj.007");
		PreparedStatement st = con.prepareStatement("SELECT PASSWORD,FIRST_NAME,LAST_NAME FROM CANDIDATES1 WHERE USER_NAME=?");
		st.setString(1, uname);
		ResultSet rs=st.executeQuery();
		
		if(rs.next())
		{
			System.out.println(rs.getString(1));
			
		if(pass.equals(rs.getString(1)))
		{
			//create cookie using Cookie
			Cookie ck = new Cookie("username",uname);
			resp.addCookie(ck);
			
			// create cookie using httpsession
			 HttpSession htp = req.getSession();
		     htp.setAttribute("firstname", rs.getString(2));
		     htp.setAttribute("lastname", rs.getString(3));
		     System.out.println(rs.getString(2));
			
			RequestDispatcher rd = req.getRequestDispatcher("myaccount.jsp");
			rd.include(req, resp);
			//rd.forward(req, resp);
			//resp.sendRedirect("myaccount.jsp");
		}
		else
		{
			out.print("<h3>Please enter correct password </h3>");
			RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
			rd.include(req, resp);
		}
		}
		else
		{
			out.print("<h3>Enter correct information</h3>");
			RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
			rd.include(req, resp);
		}
		
	
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}
		
	}
