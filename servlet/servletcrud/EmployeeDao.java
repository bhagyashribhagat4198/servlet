package servletcrud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {

	public static Connection getConnection(){	
		Connection con =null;
		try {
			Class.forName("com.mysql.jdbc.Driver");  
con =DriverManager.getConnection("jdbc:mysql://localhost:3306/database7pm?characterEncoding=utf8",
		"root","password");					
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return con;	
	}
	
	public static int saveEmployee(Employee e){
		int status=0;
		try {
		Connection con=EmployeeDao.getConnection();
PreparedStatement ps=con.prepareStatement("insert into employeecrud"
		+ "(name, password, email, department) values(?,?,?,?)");
		
	ps.setString(1, e.getName());
	ps.setString(2, e.getPassword());
	ps.setString(3, e.getEmail());
	ps.setString(4, e.getDepartment());
		
	status=ps.executeUpdate();
	con.close();	
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return status;	
	}
	
	public static List<Employee> getAllEmployeeList(){	
		List <Employee> emplist=new ArrayList<Employee>();	
		try {
			Connection con=EmployeeDao.getConnection();
	PreparedStatement ps=con.prepareStatement("select * from employeecrud");
		ResultSet rs= ps.executeQuery();
		while(rs.next()){
			Employee e=new Employee();
			e.setId(rs.getInt(1));
			e.setName(rs.getString(2));
			e.setPassword(rs.getString(3));
			e.setEmail(rs.getString(4));
			e.setDepartment(rs.getString(5));
			emplist.add(e);
		}
	con.close();	
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return emplist;	
	}
	
	public static int editEmployee(Employee e){	
		int status=0;
		try {
			Connection con=EmployeeDao.getConnection();
	PreparedStatement ps=con.prepareStatement
			("update employeecrud set name=?,password=?,email=?,department=? where id=?");		
	ps.setString(1, e.getName());
	ps.setString(2, e.getPassword());
	ps.setString(3, e.getEmail());
	ps.setString(4, e.getDepartment());
	ps.setInt(5, e.getId());
	status=ps.executeUpdate();		
		con.close();	
	} catch (Exception e1) {
		e1.printStackTrace();
	}
		return status;	
	}
	
	public static Employee getEmployeeById(int id){
		Employee e=new Employee();
		try {
			Connection con=EmployeeDao.getConnection();
	PreparedStatement ps=con.prepareStatement("select * from employeecrud where id=?");			
	ps.setInt(1, id);
	ResultSet rs=ps.executeQuery();
	if(rs.next()){	
		e.setId(rs.getInt(1));
		e.setName(rs.getString(2));
		e.setPassword(rs.getString(3));
		e.setEmail(rs.getString(4));
		e.setDepartment(rs.getString(5));
	}
	con.close();	
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return e;
	}
	
	public static int deleteEmployee(int id){
		int status=0;
		
		try {
			Connection con=EmployeeDao.getConnection();
	PreparedStatement ps=con.prepareStatement("delete from employeecrud where id=?");
		ps.setInt(1, id);
		status=ps.executeUpdate();
		
	con.close();	
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return status;
		
	}
}
