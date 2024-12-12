package hu.domparse.LWUIJ2;

import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class DOMWriteLWUIJ2 {

    public static void main(String[] args) throws Exception {

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();

            Element root = document.createElement("root");
            root.setAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
            root.setAttribute("xsi:noNamespaceSchemaLocation", "DOMParseLWUIJ2/XMLSchemaLWUIJ2.xsd");
            document.appendChild(root);

            Element versenyzok = document.createElement("Versenyzok");
            root.appendChild(versenyzok);
            addVersenyzok(document, versenyzok);

            Element doksik = document.createElement("Doksik");
            root.appendChild(doksik);
            addDoksik(document, doksik);

            Element versenyBirok = document.createElement("Verseny_Birok");
            root.appendChild(versenyBirok);
            addVersenyBirok(document, versenyBirok);

            Element kifogottHalak = document.createElement("Kifogott_Halak");
            root.appendChild(kifogottHalak);
            addKifogottHalak(document, kifogottHalak);
            Element ellenorzesek = document.createElement("Ellenorzesek");
            root.appendChild(ellenorzesek);

            addEllenorzesek(document, ellenorzesek);
            Element dijak = document.createElement("Dijak");
            root.appendChild(dijak);
            addDijak(document, dijak);

            Element helyszinek = document.createElement("Helyszinek");
            root.appendChild(helyszinek);
            addHelyszinek(document, helyszinek);

            Element halTipusok = document.createElement("Hal_Tipusok");
            root.appendChild(halTipusok);
            addHalTipusok(document, halTipusok);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File("XMLLWUIJ2out.xml"));
            transformer.transform(domSource, streamResult);
            System.out.println("Az XML fájl sikeresen létrehozva!");

            printDocumentToConsole(document);

        } catch (ParserConfigurationException | TransformerException e) {
            e.printStackTrace();
        }
    }

    private static void addVersenyzok(Document document, Element versenyzok) {

        String[][] versenyzoAdatok = {
                {"1", "1", "1", "Bence", "1997.01.06", "Gyula"},
                {"2", "2", "2", "Akos", "2000.10.15", "Miskolc"},
                {"3", "3", "3", "Alex", "1999.03.20", "Budapest"}
        };

        for (String[] adat : versenyzoAdatok) {
            Element versenyzo = document.createElement("Versenyzo");
            versenyzo.setAttribute("VAzon", adat[0]);
            versenyzo.setAttribute("Szektorazon", adat[1]);
            versenyzo.setAttribute("Dazon", adat[2]);
            versenyzok.appendChild(versenyzo);

            Element vNev = document.createElement("VNev");
            vNev.appendChild(document.createTextNode(adat[3]));
            versenyzo.appendChild(vNev);

            Element szAdatok = document.createElement("Sz_adatok");
            versenyzo.appendChild(szAdatok);

            Element szulIdo = document.createElement("Szul_ido");
            szulIdo.appendChild(document.createTextNode(adat[4]));
            szAdatok.appendChild(szulIdo);

            Element szulHely = document.createElement("Szul_hely");
            szulHely.appendChild(document.createTextNode(adat[5]));
            szAdatok.appendChild(szulHely);

        }
    }

    private static void addDoksik(Document document, Element doksik) {
        String[] igazolvanyok = {"Taj_Kartya", "Vezetoi_Engedely", "Szig_szam", "Lakcim_kartya"};

        for (int i = 1; i <= igazolvanyok.length; i++) {
            Element doksi = document.createElement("Doksi");
            doksi.setAttribute("Vazon", String.valueOf(i));
            doksik.appendChild(doksi);

            Element igazolvany = document.createElement("Igazolvany");
            igazolvany.appendChild(document.createTextNode(igazolvanyok[i - 1]));
            doksi.appendChild(igazolvany);
        }
    }

    private static void addVersenyBirok(Document document, Element versenyBirok) {
        String[][] birok = {
                {"1", "Kiss", "Joe", "1980.06.20", "Budapest"},
                {"2", "Nagy", "Ferenc", "1985.12.03", "Sopron"},
                {"3", "Kovacs", "Janos", "1975.02.10", "Gyor"}
        };

        for (String[] biro : birok) {
            Element versenyBiro = document.createElement("Verseny_Biro");
            versenyBiro.setAttribute("BAzon", biro[0]);
            versenyBirok.appendChild(versenyBiro);

            Element vNev = document.createElement("VNev");
            vNev.appendChild(document.createTextNode(biro[1]));
            versenyBiro.appendChild(vNev);

            Element kNev = document.createElement("KNev");
            kNev.appendChild(document.createTextNode(biro[2]));
            versenyBiro.appendChild(kNev);

            Element szAdatok = document.createElement("Sz_adatok");
            versenyBiro.appendChild(szAdatok);
            Element szulIdo = document.createElement("Szul_ido");
            szulIdo.appendChild(document.createTextNode(biro[3]));
            szAdatok.appendChild(szulIdo);

            Element szulHely = document.createElement("Szul_hely");
            szulHely.appendChild(document.createTextNode(biro[4]));
            szAdatok.appendChild(szulHely);
        }
    }

    private static void addKifogottHalak(Document document, Element kifogottHalak) {
        String[][] halak = {
                {"1", "1", "1", "Csuka", "5", "14:00"},
                {"2", "2", "2", "Ponty", "10", "15:00"},
                {"3", "3", "3", "Amur", "8", "17:00"}
        };

        for (String[] hal : halak) {
            Element kifogottHal = document.createElement("Kifogott_hal");
            kifogottHal.setAttribute("Hazon", hal[0]);
            kifogottHal.setAttribute("Halindex", hal[1]);
            kifogottHal.setAttribute("VerAzon", hal[2]);
            kifogottHalak.appendChild(kifogottHal);

            Element tHal = document.createElement("THal");
            tHal.appendChild(document.createTextNode(hal[3]));
            kifogottHal.appendChild(tHal);

            Element kg = document.createElement("Kg");
            kg.appendChild(document.createTextNode(hal[4]));
            kifogottHal.appendChild(kg);

            Element ido = document.createElement("ido");
            ido.appendChild(document.createTextNode(hal[5]));
            kifogottHal.appendChild(ido);
        }
    }

    private static void addEllenorzesek(Document document, Element ellenorzesek) {
        String[][] ellenorzesekAdatok = {
                {"2", "1", "17:55"},
                {"1", "1", "17:50"},
                {"3", "3", "17:45"},
                {"2", "3", "17:40"},
                {"1", "2", "17:35"}
        };

        for (String[] adat : ellenorzesekAdatok) {
            Element ellenorzes = document.createElement("Ellenorzes");
            ellenorzes.setAttribute("VersenyzoId", adat[0]);
            ellenorzes.setAttribute("VBiroId", adat[1]);
            ellenorzesek.appendChild(ellenorzes);

            Element mikor = document.createElement("Mikor");
            mikor.appendChild(document.createTextNode(adat[2]));
            ellenorzes.appendChild(mikor);
        }
    }

    private static void addDijak(Document document, Element dijak) {
        String[][] dijakAdatok = {
                {"1", "Legtobb_Hal", "5000", "18:00"},
                {"2", "Legnagyobb_Hal", "5000", "18:30"},
                {"3", "Gyoztes", "20000", "19:00"}
        };

        for (String[] adat : dijakAdatok) {
            Element dij = document.createElement("Dij");
            dij.setAttribute("Dazon", adat[0]);
            dijak.appendChild(dij);

            Element dNev = document.createElement("DNev");
            dNev.appendChild(document.createTextNode(adat[1]));
            dij.appendChild(dNev);

            Element erteke = document.createElement("Erteke");
            erteke.appendChild(document.createTextNode(adat[2]));
            dij.appendChild(erteke);

            Element atadasiIdo = document.createElement("At_adasi_idopont");
            atadasiIdo.appendChild(document.createTextNode(adat[3]));
            dij.appendChild(atadasiIdo);
        }
    }

    private static void addHelyszinek(Document document, Element helyszinek) {
        String[][] helyszinekAdatok = {
                {"1", "Alacsony_part", "2033", "A"},
                {"2", "Magas_part", "25", "B"},
                {"3", "Alacsony_part", "30", "C"}
        };
        for (String[] adat : helyszinekAdatok) {
            Element helyszin = document.createElement("Helyszin");
            helyszin.setAttribute("SzektorAzon", adat[0]);
            helyszinek.appendChild(helyszin);

            Element helyszinTipusa = document.createElement("Helyszin_tipusa");
            helyszinTipusa.appendChild(document.createTextNode(adat[1]));
            helyszin.appendChild(helyszinTipusa);

            Element meret = document.createElement("Meret");
            meret.appendChild(document.createTextNode(adat[2]));
            helyszin.appendChild(meret);

            Element szektor = document.createElement("Szektor");
            szektor.appendChild(document.createTextNode(adat[3]));
            helyszin.appendChild(szektor);
        }
    }

    private static void addHalTipusok(Document document, Element halTipusok) {
        String[][] halTipusAdatok = {
                {"1", "igen", "VedettHal", "nem"},
                {"2", "nem", "VedettHal", "igen"},
                {"3", "igen", "NemVedettHal", "igen"}
        };

        for (String[] adat : halTipusAdatok) {
            Element halTipus = document.createElement("Hal_Tipus");
            halTipus.setAttribute("index", adat[0]);
            halTipusok.appendChild(halTipus);

            Element ragadozo = document.createElement("Ragadozo");
            ragadozo.appendChild(document.createTextNode(adat[1]));
            halTipus.appendChild(ragadozo);

            Element tipusa = document.createElement("Tipusa");
            tipusa.appendChild(document.createTextNode(adat[2]));
            halTipus.appendChild(tipusa);

            Element oshonos = document.createElement("Oshonos");
            oshonos.appendChild(document.createTextNode(adat[3]));
            halTipus.appendChild(oshonos);
        }
    }
    private static void printDocumentToConsole(Document document) throws Exception {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        DOMSource source = new DOMSource(document);
        StreamResult consoleResult = new StreamResult(System.out);
        transformer.transform(source, consoleResult);
    }
}