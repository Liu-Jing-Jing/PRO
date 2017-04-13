package main.com.pro.builder;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;

import main.com.pro.config.Configration;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DomParser {
	
	private DomBuilder builder;
	
	private Configration config;
	
	private Document doc;
	
	private XPath xpath;
	
	
	public DomParser(DomBuilder builder,Configration config) {
		this.builder = builder;
		this.config = config;
		this.doc = builder.getDocument();
		XPathFactory factory = XPathFactory.newInstance();
	    this.xpath = factory.newXPath();
		this.loadConfig();
	}

	
	private void loadConfig() {
		Node node = parseNameSpace();
		NamedNodeMap attr = node.getAttributes();
		
		
	}


	private void parseInvokeClass() {
		
	}


	private Node parseNameSpace() {
		NodeList list = parseElement("Config");
		if(list.getLength() > 1){
			throw new RuntimeException("only one Config Element needed!");
		}
		return list.item(0);
	}
	

	private void parseAttr() {
		
		
	}

	
	
	
	
	
	private NodeList parseElement(String elementName) {
		NodeList list = doc.getElementsByTagName(elementName);
		return list;
	}
	
	
	
	
	

}
