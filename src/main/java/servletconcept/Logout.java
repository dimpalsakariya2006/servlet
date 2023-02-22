package servletconcept;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class Logout extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		Cookie c = new Cookie("username","");
		c.setMaxAge(0);
		resp.addCookie(c);
		
		//Using HttpSession - session.invalidate();
		
		HttpSession htp = req.getSession();
		htp.invalidate();
		
		
		out.print("<h3>Successfully Logged out</h3>");
		RequestDispatcher rd = req.getRequestDispatcher("header.jsp");
		rd.include(req, resp);  
	}

}
