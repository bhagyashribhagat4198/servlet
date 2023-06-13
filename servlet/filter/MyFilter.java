package filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyFilter implements Filter {

	public void init(FilterConfig con){
		
	}
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {		
		PrintWriter out=res.getWriter();	
		out.print("Filter invoked Before<br><br> ");	
		chain.doFilter(req, res);	
		out.print("Filter invoked After");
	}
	public void destroy(){
		
	}	
}
