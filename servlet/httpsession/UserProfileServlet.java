package httpsession;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/userProfile")
public class UserProfileServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out =response.getWriter();
		request.getRequestDispatcher("link.html").include(request, response);
		
		HttpSession session= request.getSession(false);
		
		if(session!=null){
			String name=(String) session.getAttribute("uname");
			out.print("Hello !! "+name+" Welcome to profile page ..............");
		}
		else{
			out.print("Please login first <br><br>");
			request.getRequestDispatcher("userLogin.html").include(request, response);
		}
	}

}
