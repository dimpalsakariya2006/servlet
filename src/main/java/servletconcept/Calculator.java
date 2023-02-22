package servletconcept;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calci")
public class Calculator extends HttpServlet{

	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		
		String choice = req.getParameter("calculation");
		PrintWriter out = res.getWriter();
		System.out.println(choice);
		
		int i =Integer.parseInt(req.getParameter("num1"));
		int j =Integer.parseInt(req.getParameter("num2"));
		int k=0;
//		if(choice.equals("Addition"))
//			 k = i+j;
//		if(choice.equals("Substraction"))
//			k=i-j;
//		if(choice.equals("Multiplication"))
//			k=i*j;
//		if(choice.equals("Division"))
//		{
//			if(j==0)
//			{
//				out.print("Division operation is not possible (it's infinite)");
//				return;
//			}
//			
//			k=i/j;
//			
//		}
		
		switch(choice) {
		
		case "Addition" :
			k = i+j;
			break;
		case "Substraction" :
			k=i-j;
			break;
		case "Multiplication" :
			k=i*j;
			break;
		case "Division" :
		
			if(j==0)
			{
				out.print("<b>Division operation is not possible (it's infinite)</b>");	
			}
			k=i/j;
			break;
			
		
		}
		out.print("<html><body>");
		out.print("Entered First Number is : "+i);
		out.print("<br>Entered Second Number is : "+j);
		out.print("<br>Performed operation : "+choice);
		
		out.println("<br><b>Result is : "+k+ "</b>");
		out.print("</body></html>");
		
	}

}

