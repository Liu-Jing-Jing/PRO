package main.com.pro.invoke;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.xpath.XPathExpressionException;

import main.com.pro.builder.DefaultDombuilderFactory;
import main.com.pro.builder.DomBuilder;
import main.com.pro.builder.DomBuilderFactory;
import main.com.pro.builder.DomParser;
import main.com.pro.builder.Resources;
import main.com.pro.config.Configration;
import main.com.pro.tools.JsonTool;

@SuppressWarnings("serial")
@WebServlet("/invoke")
public class AbstractServlet extends HttpServlet{
	
	
	protected HttpServletRequest request;
	
	protected HttpServletResponse response;
	
	protected PrintWriter writer;
	
	protected Map FormData;

	@Override
	public void init() throws ServletException {
		DomBuilderFactory factory = new DefaultDombuilderFactory();
		DomBuilder builder = null;
		try {
			builder = factory.getDomBuilder(Resources.getResourceAsStream("Config.xml"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		DomParser paser = new DomParser(builder, new Configration());
		Configration config = null;
		try {
			config = paser.start();
		} catch (XPathExpressionException e1) {
		}
		String classname = "main.com.pro.builder.ConfigProxy";
		Class<?> cla = null;
		Method method = null;
		try {
			cla = Thread.currentThread().getContextClassLoader().loadClass(classname);
			Object obj = cla.newInstance();
			method = cla.getMethod("setConfig", Configration.class);
			method.invoke(obj,config);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected final void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		initContext(request,response);
		doDispacher(FormData);
	}

	protected void doDispacher(Map data){
		System.out.println(data);
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

	

}
