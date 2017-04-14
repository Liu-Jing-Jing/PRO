package main.com.pro.builder;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class DefaultDombuilderFactory implements DomBuilderFactory{

	@Override
	public DomBuilder getDomBuilder(InputStream inputStream) throws FileNotFoundException {
		return new DefaultDomBuilder(inputStream);
	}

}
