package main.com.pro.invoke;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import main.com.pro.tools.JsonTool;

@SuppressWarnings("serial")
public class AbstractServlet extends HttpServlet{
	
	
	protected HttpServletRequest request;
	
	protected HttpServletResponse response;
	
	protected PrintWriter writer;
	
	protected Map FormData;

	@Override
	protected final void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		initContext(request,response);
		doDispacher(FormData);
	}

	protected void doDispacher(Map Data){
	}
	
	private void initContext(HttpServletRequest request, HttpServletResponse response)
			throws IOException{
		this.request = request;
		this.response = response;
		this.writer = response.getWriter();
		String data = request.getParameter("data");
		this.FormData = JsonTool.ToMap(data);
	}

	@Override
	public void destroy() {
		
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
	}
	
	

}
