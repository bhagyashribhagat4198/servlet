package httpsession;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/userLogin")
public class UserLoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
	response.setContentType("text/html");
	PrintWriter out =response.getWriter();
	request.getRequestDispatcher("link.html").include(request, response);	
	String name=request.getParameter("name");
	String password=request.getParameter("pass");
	
	if(password.equals("admin")){
		out.print("welcome to the home page !!!! "+name);	
		HttpSession session =request.getSession();
		session.setAttribute("uname", name);
	}
	else{
		out.print("Sorry !!! Username or password error<br><br>");
		request.getRequestDispatcher("userLogin.html").include(request, response);
	}
	}
}
