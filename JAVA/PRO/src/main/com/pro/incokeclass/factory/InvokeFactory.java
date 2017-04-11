package main.com.pro.incokeclass.factory;

import main.com.pro.incokeclass.InvokeSubject;

public interface InvokeFactory {
	
	
	public InvokeSubject getInvokeSubject(String classname) throws Exception;

}
