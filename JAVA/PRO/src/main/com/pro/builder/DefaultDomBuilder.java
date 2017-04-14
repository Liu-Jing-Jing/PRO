package main.com.pro.builder;

import java.io.IOException;
import java.io.InputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class DefaultDomBuilder implements DomBuilder{
	
	protected Document document;
	
	DefaultDomBuilder(InputStream inputSource) {
		try {
			if(document == null){
				InitDomParser(inputSource);
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void InitDomParser(InputStream inputSource) throws ParserConfigurationException, SAXException, IOException{
		DocumentBuilderFactory DBF = DocumentBuilderFactory.newInstance();
		DBF.setNamespaceAware(false);
		DBF.setIgnoringComments(true);
		DBF.setIgnoringElementContentWhitespace(false);
		DBF.setCoalescing(false);
		DBF.setExpandEntityReferences(true);
		DBF.setIgnoringComments(true);
		DocumentBuilder builder = DBF.newDocumentBuilder();
		builder.setEntityResolver(new EntityResolver() {
			
			@Override
			public InputSource resolveEntity(String publicId, String systemId)
					throws SAXException, IOException {
				return null;
			}
		});
		InputSource source = new InputSource();
		source.setEncoding("utf-8");
		source.setByteStream(inputSource);
		this.document = builder.parse(source);
	}
	
	
	public Document getDocument() {
		return this.document;
	}
	
	

}
