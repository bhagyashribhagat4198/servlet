package cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookieservlet")
public class CookieServlet1 extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String n =request.getParameter("name");
		out.print("Welcome User ! "+n+" <br><br>");
		Cookie ck =new Cookie("uname",n);
		response.addCookie(ck);
		out.print("<form action='cookieservlet2' method='post'>");
		out.print("<input type='submit' value='Next!'>");
		out.print("</form>");
		out.close();
		
	}
}
