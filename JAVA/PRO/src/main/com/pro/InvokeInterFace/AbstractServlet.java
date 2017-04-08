package main.com.pro.InvokeInterFace;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.com.pro.tools.JsonTool;

@SuppressWarnings("serial")
@WebServlet("/Invoke")
public class AbstractServlet extends HttpServlet{
	
	
	private HttpServletRequest request;
	
	private HttpServletResponse response;
	
	private PrintWriter writer;
	
	private Map FormData;

	@Override
	protected final void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		initContext(request,response);
		doDispacher(request,response,FormData);
	}

	protected void doDispacher(HttpServletRequest request,
			HttpServletResponse response,Map Data){
	}
	
	@SuppressWarnings("unchecked")
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
		super.destroy();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public PrintWriter getWriter() {
		return writer;
	}
	
	

}
