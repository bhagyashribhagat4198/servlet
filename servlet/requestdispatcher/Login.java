package requestdispatcher;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {	
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();	
		String username=request.getParameter("username");
		String password=request.getParameter("password");	
		if(password.equals("admin"))
		{
			RequestDispatcher rd=request.getRequestDispatcher("servlet2");
			rd.forward(request, response);
		}
		else{
			out.print("Sorry ! incorrect password please login again<br>");
			RequestDispatcher rd=request.getRequestDispatcher("/login.html");
			rd.include(request, response);
		}
		out.close();
	}

}
