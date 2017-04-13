package test;

import java.io.FileInputStream;

import main.com.pro.builder.DefaultDombuilderFactory;
import main.com.pro.builder.DomBuilder;
import main.com.pro.builder.DomBuilderFactory;
import main.com.pro.builder.DomParser;
import main.com.pro.config.Configration;

import org.junit.Test;

public class TestDomBuilder {
	
	
	
	
	@Test
	public void TestParserDom() throws Exception{
		DomBuilderFactory factory = new DefaultDombuilderFactory();
		DomBuilder builder = factory.getDomBuilder(this.getClass().getResourceAsStream("Demo.xml"));
		DomParser paser = new DomParser(builder, new Configration());
	}

}
