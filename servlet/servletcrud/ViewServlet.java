package servletcrud;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/viewEmployee")
public class ViewServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {	
		response.setContentType("text/html");
		PrintWriter out =response.getWriter();	
		out.print("<a href='employee.html'>Add New Employee</a>");	
		out.print("<h1>Employee List</h1>");	
		List<Employee> listemp=EmployeeDao.getAllEmployeeList();	
		out.print("<table border='1' width='100%'");
out.print("<tr><th>ID</th><th>Name</th><th>Password</th><th>Email</th><th>Department</th>"
		+ "<th>Edit</th><th>Delete</th></tr>");
		for(Employee e:listemp)
		{
out.print("<tr><td>"+e.getId()+"</td>  <td>"+e.getName()+"</td> <td>"+e.getPassword()+" </td>"
		+ "<td>"+e.getEmail()+" </td>    <td>"+e.getDepartment()+" </td>"
		+ "<td><a href='EditEmployee1?id="+e.getId()+"'>Edit</td> "
				+ "<td><a href='DeleteEmployee?id="+e.getId()+"'>Delete</td>");
		}		
		out.print("</table>");
	out.close();
	}

}
