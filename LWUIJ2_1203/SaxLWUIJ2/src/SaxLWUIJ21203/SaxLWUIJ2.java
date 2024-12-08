package SaxLWUIJ21203;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class SaxLWUIJ2 {

    public static void main(String[] args) {
        try {
            //Dokumentum olvasó létrehozása, SAXParseFactor osztály newInstance metódus
            SAXParser parser = SAXParserFactory.newInstance().newSAXParser();

            //Saját eseménykezelő létrehozása
            SaxHandler handler = new SaxHandler();

            //Dokumentum értelmezési folyamatának elindítása
            parser.parse(new File("src/resources/LWUIJ2_kurzusfelvetel.xml"), handler);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
