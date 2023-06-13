package attributeinservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestAttribute1 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		
		response.setContentType("text/html");
		PrintWriter out =response.getWriter();
		
		ServletContext context=getServletContext();
		
		context.setAttribute("UserName", "Admin");
		
		out.print("Welcome to first servlet<br><br>");
		out.print("<a href='attribute2'>Go</a> ");
		out.close();
	}

}
