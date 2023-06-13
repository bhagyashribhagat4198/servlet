package urlrewritting;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/urlrewritting1")
public class FirstExample extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String n =request.getParameter("name");
		out.print("Welcome !!! "+n+"<br><br>");
		
		out.print("<a href='urlrewritting2?uname="+n+"'>Next</a>");
		out.close();
	}	
}
