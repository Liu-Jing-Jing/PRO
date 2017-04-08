package main.com.pro.InvokeInterFace;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("")
public class AbstractServlet extends HttpServlet{
	
	
	private HttpServletRequest request;
	
	private HttpServletResponse response;
	
	private ServletOutputStream outstream;
	
	private PrintWriter writer;

	@Override
	protected  void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		super.doGet(req, resp);
	}

	@Override
	protected final void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.request = req;
		this.response = resp;
		this.outstream = resp.getOutputStream();
		this.writer = resp.getWriter();
		doGet(req, resp);
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
