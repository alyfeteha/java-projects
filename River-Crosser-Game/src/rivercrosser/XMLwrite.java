/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rivercrosser;

/**
 *
 * @author Eco
 */
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.Text;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLwrite {
 

private int i=0;
private int y=0;
private int p=0;
private int fteha=0;
ArrayList<Crosser>R=new ArrayList<>();
ArrayList<Crosser>L=new ArrayList<>();
ArrayList<Crosser>O=new ArrayList<>();
FillArrayList a=new FillArrayList();
int u=a.boat();

public void arrayRight(ArrayList<Crosser> k) {
	
	while(fteha<k.size()) {
		R.add((Crosser) k.get(fteha));
	fteha++;
	}
}
public void arrayLeft(ArrayList l) {
	while(i<l.size()) {
		L.add((Crosser) l.get(i));
	i++;
	}
}
public void arrayonboat(ArrayList q) {
	while(p<q.size()) {
		O.add((Crosser) q.get(p));
	p++;
	}
}

	public  void writeXML(){
		try {
			int j=0;
			int x=0;
			int y=0;
		Document doc=new Document();
		Element root=new Element("Crossers");
		doc.setRootElement(root);
		Element CrosserLeft=new Element("LeftCrossers");
		//root.addContent(CrosserLeft);
		while(j<L.size()) {
                    System.out.println(" hi left size "+L.size());
		if(L.get(j) instanceof Farmer){
		Element c=new Element("Human");
		c.addContent(new Text("Human"));
		CrosserLeft.addContent(c);
		//root.addContent(CrosserLeft);
		}
		if(L.get(j) instanceof Carnivore)
		{
			Element c=new Element("Carnivore");
			c.addContent(new Text("Carnivore"));
			CrosserLeft.addContent(c);
                  //      root.addContent(CrosserLeft);
		}
                if(L.get(j) instanceof Herbivore)
		{
			Element c=new Element("Herbivore");
			c.addContent(new Text("Herbivore"));
			CrosserLeft.addContent(c);
                    //    root.addContent(CrosserLeft);
		}
		if(L.get(j) instanceof Plant)
		{
			Element c=new Element("Plant");
			c.addContent(new Text("Plant"));
			CrosserLeft.addContent(c);
                      //  root.addContent(CrosserLeft);
		}
		j++;
                
		}
                root.addContent(CrosserLeft);
                
		Element OnBoat=new Element("OnBoat");
		//root.addContent(CrosserLeft);
		while(y<O.size()) {
		if(O.get(y) instanceof Farmer){
		Element c=new Element("Farmer");
		c.addContent(new Text("Farmer"));
		OnBoat.addContent(c);
		//root.addContent(OnBoat);
		}
		if(O.get(y) instanceof Herbivore)
		{
			Element c=new Element("Herbivore");
			c.addContent(new Text("Herbivore"));
			OnBoat.addContent(c);
                       // root.addContent(OnBoat);
		}
                if(O.get(y) instanceof Carnivore)
		{
			Element c=new Element("Carnivore");
			c.addContent(new Text("Carnivore"));
			OnBoat.addContent(c);
                        //root.addContent(OnBoat);
		}
		if(O.get(y) instanceof Plant)
		{
			Element c=new Element("Plant");
			c.addContent(new Text("Plant"));
			OnBoat.addContent(c);
                        //root.addContent(OnBoat);
		}
		y++;
		}
                root.addContent(OnBoat);
		Element CrosserRight=new Element("CrosserRight");
		while(x<R.size()) {
                    System.out.println("CHHECKING RIGTH SIZE "+R.size());
		if(R.get(x) instanceof Farmer){
		Element c=new Element("Farmer");
			c.addContent(new Text("Farmer"));
			CrosserRight.addContent(c);
			//root.addContent(CrosserRight);
		}
		if(R.get(x) instanceof Carnivore)
		{
			Element c=new Element("Carnivore");
			c.addContent(new Text("Carnivore"));
			CrosserRight.addContent(c);
                        //root.addContent(CrosserRight);
		}
                if(R.get(x) instanceof Herbivore)
		{
			Element c=new Element("Herbivore");
			c.addContent(new Text("Herbivore"));
			CrosserRight.addContent(c);
                       // root.addContent(CrosserRight);
		}
		if(R.get(x) instanceof Plant)
		{
			Element c=new Element("Plant");
			c.addContent(new Text("Plant"));
			CrosserRight.addContent(c);
                //        root.addContent(CrosserRight);
		}
		x++;
		}
		root.addContent(CrosserRight);
		Element Boat=new Element("Boat");
		
		if(u==0){
		    Element g=new Element("BoatPosition");
			g.addContent(new Text("0"));
			Boat.addContent(g);
			root.addContent(Boat);
		}
		if(u==1)
		{
			Element g=new Element("BoatPosition");
			g.addContent(new Text("1"));
			Boat.addContent(g);
			root.addContent(Boat);
		}
		
		System.out.println("wrote to the file");
		XMLOutputter xmlOutput=new XMLOutputter(Format.getPrettyFormat());
		xmlOutput.output(doc,new FileOutputStream(new File("./src/Story1.xml")));
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	
}
    

