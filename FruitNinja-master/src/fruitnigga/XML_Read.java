package fruitnigga;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class XML_Read {
	private String score;
	public String ReadXMLFile(String namex) {
		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		
			try {
				DocumentBuilder builder=factory.newDocumentBuilder();
				Document doc=builder.parse(namex);
				NodeList personList=doc.getElementsByTagName("score");
				for(int h=0;h<personList.getLength();h++)
				{
					
					Node p=personList.item(h);
					if(p.getNodeType()==Node.ELEMENT_NODE) {
						
						Node person= p;
						NodeList nameList=person.getChildNodes();
						for(int y=0;y<nameList.getLength();y++) {
							Node n=nameList.item(y);
								Node name=n;
								//System.out.println(name.getTextContent());
								score=name.getTextContent();
						}
					}
				}
                                
			} catch (ParserConfigurationException e) {
				e.printStackTrace();
			} catch (SAXException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
                        return score;
}

}
