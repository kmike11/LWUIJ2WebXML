package hu.domparse.LWUIJ2;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class DOMQueryLWUIJ2 {
    public static void main(String[] args) {
        try {
                NodeList nodeList;

                DocumentBuilderFactory factory =DocumentBuilderFactory.newInstance();
                DocumentBuilder builder=factory.newDocumentBuilder();
                //Fájl beolvasása
                Document document=builder.parse(new File("XMLLWUIJ2.xml"));
                document.getDocumentElement().normalize();

                //Aktuális elem meghatározása
                nodeList=document.getElementsByTagName("Hal_Tipus");

                for(int i =0;i<nodeList.getLength();i++){
                    Node node=nodeList.item(i);

                    //Hal tipusok adatainak kiirása
                    if(node.getNodeType()==Node.ELEMENT_NODE){
                        Element element=(Element) node;
                        String tipus= element.getElementsByTagName("Tipusa").item(0).getTextContent();

                        if(tipus.equals("VedettHal"))
                        {
                            System.out.println("\nAktuális elem: " + node.getNodeName());
                            System.out.println("-------");
                            System.out.println("");
                        System.out.println("Hal tipus id: " + element.getAttribute("index"));
                            System.out.println("Ragadozó: " + element.getElementsByTagName("Ragadozo").item(0).getTextContent());
                            System.out.println("Tipusa: " + element.getElementsByTagName("Tipusa").item(0).getTextContent());
                        System.out.println("Oshonos: " + element.getElementsByTagName("Oshonos").item(0).getTextContent());

                    }
                }
            }
        } catch (ParserConfigurationException | IOException | SAXException e){
            e.printStackTrace();
        }
    }
}

