package servletcontext;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServletContext extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
	PrintWriter out =response.getWriter();
	
	ServletContext context=getServletContext();
	
	String name=context.getInitParameter("User");
	out.print("User name is : "+name);
	out.close();
	}

}
