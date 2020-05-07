package rivercrosser;

import java.util.ArrayList;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.jdom2.Element;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLread {
	private ArrayList<String> rightcross=new ArrayList<>();
	private ArrayList<String> leftcross=new ArrayList<>();
	private ArrayList<String> OnBoat=new ArrayList<>();
	private String BoatState;
	
	public ArrayList<String> getRightcross() {
		return rightcross;
	}

	public void setRightcross(ArrayList<String> rightcross) {
		this.rightcross = rightcross;
	}

	public ArrayList<String> getLeftcross() {
		return leftcross;
	}

	public void setLeftcross(ArrayList<String> leftcross) {
		this.leftcross = leftcross;
	}

	public String getBoatState() {
		return BoatState;
	}

	public void setBoatState(String boatState) {
		BoatState = boatState;
	}

	public void ReadXMLFile() {
		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
			try {
				DocumentBuilder builder=factory.newDocumentBuilder();
				Document doc=builder.parse("C:\\Users\\New\\eclipse-workspace\\RiverCrosser\\src\\jdommMade.xml");
				NodeList personList=doc.getElementsByTagName("CrosserRight");
				for(int h=0;h<personList.getLength();h++)
				{
					Node p=personList.item(h);
					if(p.getNodeType()==Node.ELEMENT_NODE) {
						Node person= p;
						NodeList nameList=person.getChildNodes();
						for(int y=0;y<nameList.getLength();y++) {
							Node n=nameList.item(y);
							if(n.getNodeType()==Node.ELEMENT_NODE) {
								Node name=n;
								System.out.println(name.getTextContent());
								rightcross.add(name.getTextContent());
							}
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
			try {
				DocumentBuilder builder=factory.newDocumentBuilder();
				Document doc=builder.parse("C:\\Users\\New\\eclipse-workspace\\RiverCrosser\\src\\jdommMade.xml");
				NodeList personList=doc.getElementsByTagName("LeftCrossers");
				for(int h=0;h<personList.getLength();h++)
				{
					Node p=personList.item(h);
					if(p.getNodeType()==Node.ELEMENT_NODE) {
						Node person= p;
						NodeList nameList=person.getChildNodes();
						for(int y=0;y<nameList.getLength();y++) {
							Node n=nameList.item(y);
							if(n.getNodeType()==Node.ELEMENT_NODE) {
								Node name=n;
								System.out.println(name.getTextContent());
								leftcross.add(name.getTextContent());
							}
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
			try {
				DocumentBuilder builder=factory.newDocumentBuilder();
				Document doc=builder.parse("C:\\Users\\New\\eclipse-workspace\\RiverCrosser\\src\\jdommMade.xml");
				NodeList personList=doc.getElementsByTagName("Boat");
				for(int h=0;h<personList.getLength();h++)
				{
					Node p=personList.item(h);
					if(p.getNodeType()==Node.ELEMENT_NODE) {
						Node person= p;
						NodeList nameList=person.getChildNodes();
						for(int y=0;y<nameList.getLength();y++) {
							Node n=nameList.item(y);
							if(n.getNodeType()==Node.ELEMENT_NODE) {
								Node name=n;
								System.out.println(name.getTextContent());
								BoatState=name.getTextContent();
							}
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
			try {
				DocumentBuilder builder=factory.newDocumentBuilder();
				Document doc=builder.parse("C:\\Users\\New\\eclipse-workspace\\RiverCrosser\\src\\jdommMade.xml");
				NodeList personList=doc.getElementsByTagName("OnBoat");
				for(int h=0;h<personList.getLength();h++)
				{
					Node p=personList.item(h);
					if(p.getNodeType()==Node.ELEMENT_NODE) {
						Node person= p;
						NodeList nameList=person.getChildNodes();
						for(int y=0;y<nameList.getLength();y++) {
							Node n=nameList.item(y);
							if(n.getNodeType()==Node.ELEMENT_NODE) {
								Node name=n;
								System.out.println(name.getTextContent());
								OnBoat.add(name.getTextContent());
							}
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
}

}

