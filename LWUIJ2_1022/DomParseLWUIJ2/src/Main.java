import domLWUIJ21015.DOMRead;
import domLWUIJ21015.DomWriteLWUIJ2;
import org.w3c.dom.Document;


public class Main {
    public static void main(String[] args) throws Exception {
        String path = "src/resources/LWUIJ2_orarend.xml";

        DOMRead dm = new DOMRead(path);
        Document dom = dm.buildUpDom();
        DomWriteLWUIJ2 write = new DomWriteLWUIJ2(dom.getDocumentElement());

        try {
            write.printXmlStructure(dom.getDocumentElement(),"");
            write.writeXmlFile(dom, "src/resources/LWUIJ2_orarend1.xml");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}