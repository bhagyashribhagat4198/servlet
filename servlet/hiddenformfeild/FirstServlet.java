package hiddenformfeild;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hiddenform1")
public class FirstServlet extends HttpServlet {	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String n =request.getParameter("name");
		out.print("Hello User! "+n+"<br><br>");
		
		out.print("<form action='hidden2'>");
		out.print("<input type='hidden' name='uname' value='"+n+"'> ");
		out.print("<input type='submit' value='next'/>");
		out.print("</form>");
		out.close();
	}
}
