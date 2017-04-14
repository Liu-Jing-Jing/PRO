package main.com.pro.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ExceptionFilter implements Filter{

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest Request, ServletResponse Response,
			FilterChain Chain) throws IOException, ServletException {
		try{
			Chain.doFilter(Request, Response);
		}catch(Exception e){
			
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
