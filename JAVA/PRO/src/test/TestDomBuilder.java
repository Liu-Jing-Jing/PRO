package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import main.com.pro.builder.DefaultDombuilderFactory;
import main.com.pro.builder.DomBuilder;
import main.com.pro.builder.DomBuilderFactory;
import main.com.pro.builder.DomParser;
import main.com.pro.config.Configration;

import org.junit.Test;
import org.w3c.dom.Document;

public class TestDomBuilder {
	
	
	
	
	@Test
	public void TestParserDom() throws Exception{
		DomBuilderFactory factory = new DefaultDombuilderFactory();
		DomBuilder builder = factory.getDomBuilder(new FileInputStream("C:/Users/jl-pc-3/Desktop/form5/src/com/jlsoft/form/scm/bbgl/bmplxs/sql/bmplxs.xml"));
		DomParser paser = new DomParser(builder, new Configration());
	}
	

}
