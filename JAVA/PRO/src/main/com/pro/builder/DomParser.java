package main.com.pro.builder;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import main.com.pro.config.Configration;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DomParser {
	
	private Configration config;
	
	private Document doc;
	
	private XPath xpath;
	
	
	public DomParser(DomBuilder builder,Configration config) {
		this.config = config;
		this.doc = builder.getDocument();
		XPathFactory factory = XPathFactory.newInstance();
	    this.xpath = factory.newXPath();
	}

	
	public Configration start() throws XPathExpressionException{
		NodeList node = evalNode("/Config");
		for (int i = 0; i < node.getLength(); i++) {
			System.out.println(node.item(i));
		}
		return config;
	}
	
	
	public NodeList evalNode(String name) throws XPathExpressionException{
		NodeList node  = (NodeList) xpath.evaluate(name, doc, XPathConstants.NODESET);
		return node;
	}
	
	
	public String evalAttr(String attrName,Object node) throws XPathExpressionException{
		return String.valueOf(xpath.evaluate("@"+attrName,node));
	}
	
	

}
