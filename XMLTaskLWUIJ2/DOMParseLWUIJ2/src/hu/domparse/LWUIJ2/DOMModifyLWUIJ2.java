package hu.domparse.LWUIJ2;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class DOMModifyLWUIJ2 {
    public static void main(String[] args) {
        NodeList nodeList;
        try{
            DocumentBuilderFactory factory =DocumentBuilderFactory.newInstance();
            DocumentBuilder builder=factory.newDocumentBuilder();
            //Fájl beolvasása
            Document document=builder.parse(new File("XMLLWUIJ2.xml"));
            document.getDocumentElement().normalize();
            //Aktuális elem meghatározása
            nodeList=document.getElementsByTagName("Versenyzo");
            for(int i =0;i<nodeList.getLength();i++){
                Node node=nodeList.item(i);
                System.out.println("\nAktuális elem: " + node.getNodeName());
                //Versenyzo adatainak kiirása
                if(node.getNodeType()==Node.ELEMENT_NODE){
                    Element element=(Element) node;
                    //Versenyzo idjének eltárolása
                    String id= element.getAttribute("VAzon");

                    System.out.println("Versenyzo id: " + element.getAttribute("VAzon"));
                    System.out.println("Szektorazonositó id: " + element.getAttribute("Szektorazon"));
                    System.out.println("Díj id: " + element.getAttribute("Dazon"));
                    System.out.println("VersenyzőNév: "
                            + element.getElementsByTagName("VNev").item(0).getTextContent());

                    //Versenyző születési adatainak kiirása
                    Node nodeszuladat=nodeList.item(i);
                    if(nodeszuladat.getNodeType()==Node.ELEMENT_NODE){
                        Element elementszuldat=(Element) node;
                        //id vizsgálata ha megegyezik a megadot id-vel akkor születési hely módositás
                        if(id.equals("2")) {
                            elementszuldat.getElementsByTagName("Szul_hely").item(0).setTextContent("Los Angeles");
                        }
                        System.out.println("Születési idő: " + elementszuldat.getElementsByTagName("Szul_ido").item(0).getTextContent());
                        System.out.println("Születési hely: " + elementszuldat.getElementsByTagName("Szul_hely").item(0).getTextContent());
                    }
                }
            }
            //létrehozza az xml fájlt módositva
            Transformer transformer= TransformerFactory.newInstance().newTransformer();
            Source input=new DOMSource(document);
            Result output=new StreamResult(new File("XMLLWUIJ2Modify.xml"));
            transformer.transform(input,output);
        }catch (ParserConfigurationException e){
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
