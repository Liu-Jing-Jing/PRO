package main.com.pro.incokeclass.factory;

import main.com.pro.incokeclass.InvokeSubject;

public class DefaultInvokeFactory implements InvokeFactory{
	
	private ClassLoader classLoader;
	
	private DefaultInvokeFactory(ClassLoader classLoader) {
		if(classLoader == null){
			this.classLoader = ClassLoader.getSystemClassLoader();
		}
		this.classLoader = classLoader;
	}
	
	public static DefaultInvokeFactory newInstance(){
		return new DefaultInvokeFactory(null);
	}
	

	@Override
	public InvokeSubject getInvokeSubject(String classname) throws ClassNotFoundException {
		Class<InvokeSubject> clas = (Class<InvokeSubject>) classLoader.loadClass(classname);
		return null;
	}

}
