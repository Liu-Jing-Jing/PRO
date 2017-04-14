package main.com.pro.incokeclass.factory;

import main.com.pro.builder.Resources;
import main.com.pro.incokeclass.InvokeSubject;

public class DefaultInvokeFactory extends AbstractInvokeFactory{
	
	public static DefaultInvokeFactory newInstance(){
		return new DefaultInvokeFactory();
	}
	
	@Override
	public InvokeSubject getInvokeSubject(String classname) throws ClassNotFoundException {
		Class<?> clas = Resources.getDefaultClassLoader().loadClass(classname);
		return null;
	}

}
