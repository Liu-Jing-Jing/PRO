package main.com.pro.incokeclass.factory;

import main.com.pro.builder.ConfigProxy;
import main.com.pro.incokeclass.InvokeSubject;

public abstract class AbstractInvokeFactory extends ConfigProxy implements InvokeFactory{

	@Override
	public abstract InvokeSubject getInvokeSubject(String classname) throws Exception;

}
