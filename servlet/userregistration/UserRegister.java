package userregistration;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserRegister extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {	
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();	
	String name=	request.getParameter("userName");
	String password=request.getParameter("password");
	String email=	request.getParameter("userEmail");
	String state=	request.getParameter("state");
	try {
		Class.forName("com.mysql.jdbc.Driver");  
Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/database7pm?characterEncoding=utf8",
	"root","password");		
	PreparedStatement ps=con.prepareStatement("insert into registeruser values(?,?,?,?)");
	ps.setString(1, name);
	ps.setString(2, password);
	ps.setString(3, email);
	ps.setString(4, state);	
	int i =ps.executeUpdate();	
	if(i>0){
		out.print("User is Successfully register");
	}
		con.close();	
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

}
