package servletcrud;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EditEmployee1")
public class EditEmployee1 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {	
		response.setContentType("text/html");
		PrintWriter out =response.getWriter();
		out.print("<h1>Edit Employee Data</h1>");	
		String eid=request.getParameter("id");
		int id=Integer.parseInt(eid);
		Employee e=EmployeeDao.getEmployeeById(id);	
		out.print("<form action='EditEmployee2' method='post'>");
	out.print("<table>");
	out.print("<tr><td></td><td><input type='hidden' name='id' value='"+e.getId()+"'/></td></tr>");
	out.print("<tr><td>Name : </td><td><input type='text' name='name' value='"+e.getName()+"'/>"
			+ "</td></tr>");
	out.print("<tr><td>Password : </td>"
			+ "<td><input type='text' name='password' value='"+e.getPassword()+"'/></td></tr>");
	out.print("<tr><td>Email : </td>"
			+ "<td><input type='text' name='email' value='"+e.getEmail()+"'/></td></tr>");
	out.print("<tr><td>Department : </td><td>");
	out.print("<select name='department' style='width:150px'>");
	out.print("<option>Testing</option>");
	out.print("<option>Q&A</option>");
	out.print("<option>HR</option>");
	out.print("<option>Marketing</option>");
	out.print("</select>");
	out.print("</td></tr>");
	
	out.print("<tr><td colspan='2'><input type='submit'  value='Edit & Save'/></td></tr>");
	out.print("</table>");
	out.print("</form>");
	out.close();
	}

}
