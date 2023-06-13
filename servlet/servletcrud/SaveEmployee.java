package servletcrud;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/saveEmployee")
public class SaveEmployee extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
	
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		String department=request.getParameter("department");
		
		Employee e=new Employee();
		e.setName(name);
		e.setPassword(password);
		e.setEmail(email);
		e.setDepartment(department);
		
		int status=EmployeeDao.saveEmployee(e);
		
		if(status>0){
			out.print("<p>New employee record save successfully !!!!!</p><br>");
			
		request.getRequestDispatcher("employee.html").include(request, response);
		}
		else{
			out.print("Sorry!!! unable to save records");
		}
		
		out.close();
	}

}
