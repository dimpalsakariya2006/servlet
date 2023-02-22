package servletconcept;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/register")
public class Registration extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		resp.setContentType("text/html");
		

		
		String uname = req.getParameter("uname");
		String pass = req.getParameter("pass");
		String rpass = req.getParameter("rpass");
		String que = req.getParameter("Question");
		String ans = req.getParameter("Answer");
		String fname = req.getParameter("fname");
		String lname = req.getParameter("lname");
		String email = req.getParameter("email");
		String bdate = req.getParameter("bdate");
		
		PrintWriter out = resp.getWriter();
		
		ServletContext sc = getServletContext();
		sc.setAttribute("name", uname);
		sc.setAttribute("password",	 pass);
		sc.setAttribute("Question", que);
		sc.setAttribute("ans", ans);	
		
		if(pass.equals(rpass))
		{
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/registration","root","Nikunj.007");
				PreparedStatement st  = con.prepareStatement("insert into candidates1 values(?,?,?,?,?,?,?,?)");
				st.setString(1, uname);
				st.setString(2, fname);
				st.setString(3, lname);	
				st.setString(4, pass);
				st.setString(5, bdate);
				st.setString(6, que);
				st.setString(7, ans);
				st.setString(8, email);
				int row = st.executeUpdate();
				out.print("Successfully Registered");
				
				con.close();
			}catch(Exception e)
			{
				System.out.println(e);
			}
			out.print("<h3>Successfully Registered  : </h3>" +uname);
			RequestDispatcher rd = req.getRequestDispatcher("header.jsp");
			rd.include(req, resp);
			
		}
		else {
			out.print("<h3>Passwords must be same</h3>");
			RequestDispatcher rd = req.getRequestDispatcher("registration.jsp");
			rd.include(req, resp);
		}	
	}

}
