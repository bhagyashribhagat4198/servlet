package servletcrud;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EditEmployee2")
public class EditEmployee2 extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out =response.getWriter();
		String eid=request.getParameter("id");
		int id=Integer.parseInt(eid);
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		String department=request.getParameter("department");	
		Employee e=new Employee();
		e.setId(id);
		e.setName(name);
		e.setPassword(password);
		e.setEmail(email);
		e.setDepartment(department);
		int status=EmployeeDao.editEmployee(e);
		if(status>0){
			response.sendRedirect("viewEmployee");	
		}
		else{
			out.print("Sorry ! Unable to Update Record");
		}
		out.close();
	}

}
