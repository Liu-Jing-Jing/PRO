package main.com.pro.builder;

import java.io.InputStream;

public interface DomBuilderFactory {
	
	
	public DomBuilder getDomBuilder(InputStream inputStream) throws Exception;
	

}
