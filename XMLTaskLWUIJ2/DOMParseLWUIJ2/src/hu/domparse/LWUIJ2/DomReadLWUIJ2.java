package hu.domparse.LWUIJ2;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class DomReadLWUIJ2 {
    public static void main(String[] args){
    NodeList list;
    try {
        DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder=factory.newDocumentBuilder();
        //fájl beolvasása
        Document document=documentBuilder.parse(new File("XMLLWUIJ2.xml"));
        document.getDocumentElement().normalize();
        //Gyökér elem megkeresése
        System.out.println("Root element : " + document.getDocumentElement().getNodeName());
        System.out.println("----------------");
        //Aktuális elem meghatározása
        list=document.getElementsByTagName("Versenyzo");

        for (int i=0;i<list.getLength();i++) {
                Node node=list.item(i);
                System.out.println("\nAktuális elem: " + node.getNodeName());
                //Versenyzok adatainak kiirása
                if(node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element=(Element) node;
                    System.out.println("Versenyzo id: " + element.getAttribute("VAzon"));
                    System.out.println("Szektorazonositó id: " + element.getAttribute("Szektorazon"));
                    System.out.println("Díj id: " + element.getAttribute("Dazon"));
                    System.out.println("VersenyzőNév: "
                    + element.getElementsByTagName("VNev").item(0).getTextContent());

                    //Versenyző születési adatainak kiirása
                    Node nodeszuladat=list.item(i);
                    if(nodeszuladat.getNodeType()==Node.ELEMENT_NODE){
                        Element elementszuldat=(Element) node;
                        System.out.println("Születési idő: " + elementszuldat.getElementsByTagName("Szul_ido").item(0).getTextContent());
                        System.out.println("Születési hely: " + elementszuldat.getElementsByTagName("Szul_hely").item(0).getTextContent());
                    }
                }
            }
        //Aktuális elem meghatározása
        list=document.getElementsByTagName("Doksi");

        for(int i=0;i<list.getLength();i++){
            Node node=list.item(i);
            System.out.println("\nAktuális elem: " + node.getNodeName());
            //Doksi adatainak kiirása
            if(node.getNodeType() == Node.ELEMENT_NODE) {
                Element element=(Element) node;
                System.out.println("Dokumentum id: " + element.getAttribute("Vazon"));
                System.out.println("Igazolvany: " + element.getElementsByTagName("Igazolvany").item(0).getTextContent());
            }
        }
        //Aktuális elem meghatározása
        list=document.getElementsByTagName("Verseny_Biro");

        for(int i=0;i<list.getLength();i++){
            Node node=list.item(i);
            System.out.println("\nAktuális elem: " + node.getNodeName());
            //Verseny Bírok adatainak kiirása
            if(node.getNodeType() == Node.ELEMENT_NODE) {
                Element element=(Element) node;
                System.out.println("Verseny Biró id: " + element.getAttribute("BAzon"));
                System.out.println("Vezetéknév: " + element.getElementsByTagName("VNev").item(0).getTextContent());
                System.out.println("Keresztnév: " + element.getElementsByTagName("KNev").item(0).getTextContent());

                //Biró születési adatainak kiirása
                Node nodeszuladat=list.item(i);
                if(nodeszuladat.getNodeType()==Node.ELEMENT_NODE){
                    Element elementszuldat=(Element) node;
                    System.out.println("Születési idő: " + elementszuldat.getElementsByTagName("Szul_ido").item(0).getTextContent());
                    System.out.println("Születési hely: " + elementszuldat.getElementsByTagName("Szul_hely").item(0).getTextContent());
                }
            }
        }
        //Aktuális elem meghatározása
        list=document.getElementsByTagName("Kifogott_hal");

        for(int i=0;i<list.getLength();i++){
            Node node=list.item(i);
            System.out.println("\nAktuális elem: " + node.getNodeName());
            //Doksi adatainak kiirása
            if(node.getNodeType() == Node.ELEMENT_NODE) {
                Element element=(Element) node;
                System.out.println("Hal id: " + element.getAttribute("Vazon"));
                System.out.println("KifogottHalnak az idje: " + element.getAttribute("Halindex"));
                System.out.println("Versenyző idje: " + element.getAttribute("VerAzon"));
                System.out.println("Tipusa: " + element.getElementsByTagName("THal").item(0).getTextContent());
                System.out.println("Mérete: " + element.getElementsByTagName("Kg").item(0).getTextContent());
                System.out.println("Mikor fogták: " + element.getElementsByTagName("ido").item(0).getTextContent());

            }
        }
        //Aktuális elem meghatározása
        list=document.getElementsByTagName("Ellenorzes");

        for(int i=0;i<list.getLength();i++){
            Node node=list.item(i);
            System.out.println("\nAktuális elem: " + node.getNodeName());
            //Doksi adatainak kiirása
            if(node.getNodeType() == Node.ELEMENT_NODE) {
                Element element=(Element) node;
                System.out.println("Biro id: " + element.getAttribute("VBiroId"));
                System.out.println("Versenyző idje: " + element.getAttribute("VersenyzoId"));
                System.out.println("Mikor: " + element.getElementsByTagName("Mikor").item(0).getTextContent());
            }
        }
        //Aktuális elem meghatározása
        list=document.getElementsByTagName("Dij");

        for(int i=0;i<list.getLength();i++){
            Node node=list.item(i);
            System.out.println("\nAktuális elem: " + node.getNodeName());
            //Doksi adatainak kiirása
            if(node.getNodeType() == Node.ELEMENT_NODE) {
                Element element=(Element) node;
                System.out.println("Dij id: " + element.getAttribute("VBiroId"));
                System.out.println("Értéke: " + element.getElementsByTagName("Erteke").item(0).getTextContent());
                System.out.println("Át adási időpont: " + element.getElementsByTagName("At_adasi_idopont").item(0).getTextContent());
            }
        }

        //Aktuális elem meghatározása
        list=document.getElementsByTagName("Helyszin");

        for(int i=0;i<list.getLength();i++){
            Node node=list.item(i);
            System.out.println("\nAktuális elem: " + node.getNodeName());
            //Doksi adatainak kiirása
            if(node.getNodeType() == Node.ELEMENT_NODE) {
                Element element=(Element) node;
                System.out.println("Szektor id: " + element.getAttribute("SzektorAzon"));
                System.out.println("Helyszin tipusa: " + element.getElementsByTagName("Helyszin_tipusa").item(0).getTextContent());
                System.out.println("Mérete: " + element.getElementsByTagName("Meret").item(0).getTextContent());
                System.out.println("Szektor: " + element.getElementsByTagName("Szektor").item(0).getTextContent());
            }
        }

        //Aktuális elem meghatározása
        list=document.getElementsByTagName("Hal_Tipus");

        for(int i=0;i<list.getLength();i++){
            Node node=list.item(i);
            System.out.println("\nAktuális elem: " + node.getNodeName());
            //Doksi adatainak kiirása
            if(node.getNodeType() == Node.ELEMENT_NODE) {
                Element element=(Element) node;
                System.out.println("Hal_tipus id: " + element.getAttribute("index"));
                System.out.println("Ragadozó: " + element.getElementsByTagName("Ragadozo").item(0).getTextContent());
                System.out.println("Tipusa: " + element.getElementsByTagName("Tipusa").item(0).getTextContent());
                System.out.println("Oshonos: " + element.getElementsByTagName("Oshonos").item(0).getTextContent());
            }
        }


        }catch (ParserConfigurationException e){
        e.printStackTrace();
    } catch (Exception e) {
        e.printStackTrace();
    }
    }
}
