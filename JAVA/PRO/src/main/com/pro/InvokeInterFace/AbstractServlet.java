package main.com.pro.InvokeInterFace;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
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
	
	private ServletOutputStream outstream;
	
	private PrintWriter writer;
	
	private Map FormData;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.request = request;
		this.response = response;
		this.outstream = response.getOutputStream();
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
		super.init(config);
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public ServletOutputStream getOutstream() {
		return outstream;
	}

	public PrintWriter getWriter() {
		return writer;
	}
	
	

}
