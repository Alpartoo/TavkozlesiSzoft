package konyvtar.Lista;

import konyvtar.Konyvtaros;
import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.ArrayList;

public class KonyvtarosLista {

    public ArrayList<Konyvtaros> konyvtarosLista;

    public KonyvtarosLista() {

        Konyvtaros[] Konyvtarosok = new Konyvtaros[5];
        this.konyvtarosLista = new ArrayList<>();

        Konyvtarosok[0] = new Konyvtaros(0, "Sandor", "Amburs Lajos", "ghguu@gmail.com", 754896378, "fdsfsdf");
        Konyvtarosok[1] = new Konyvtaros(1, "Pista", "Fo utca", "gaaa@gmail.com", 754586147, "23jjrj");
        Konyvtarosok[2] = new Konyvtaros(2, "Feri", "Borvizek (", "huuu@gmail.com", 754983761, "dsds678");


        for (int i = 0; i < Konyvtarosok.length; i++) {
            konyvtarosLista.add(Konyvtarosok[i]);
        }
    }

    public void konyvtarosListaMentes() {

        try {
            FileOutputStream fileOut = new FileOutputStream("D:\\Suliba\\IV\\II felev\\TavkozlesiSzoft\\src\\konyvtar\\konyvtarosLista.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(konyvtarosLista);
            out.close();
            fileOut.close();
            System.out.printf("File mentve\n");
        } catch (IOException i) {
            i.printStackTrace();
        }

    }

    public void konyvtarosListaOlvasas() {
        System.out.println("Konyvek listazasa...");
        try {
            FileInputStream fileIn = new FileInputStream("D:\\Suliba\\IV\\II felev\\TavkozlesiSzoft\\src\\konyvtar\\konyvtarosLista.txt");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            konyvtarosLista = (ArrayList<Konyvtaros>) in.readObject();

            for (Konyvtaros konyvtaros : konyvtarosLista) {
                System.out.println("konyvtarosID: " + konyvtaros.getKonyvtarosID());
                System.out.println("Nev: " + konyvtaros.getNev());
                System.out.println("Lakcim: " + konyvtaros.getLakcim());
                System.out.println("Email: " + konyvtaros.getEmail());
                System.out.println("Telefon: " + konyvtaros.getTelefon());
                System.out.println("Jelszo: " + konyvtaros.getJelszo());
            }

            in.close();
            fileIn.close();

        } catch (IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("Nem kapom az osztalyt...");
            c.printStackTrace();
            return;
        }

    }

    public void konyvtarosHozzadas(Konyvtaros ujkonyvtaros) {
        int utolsoelem = konyvtarosLista.size() - 1;
        System.out.println("utolso elem" + utolsoelem);
        ujkonyvtaros.setKonyvtarosID((konyvtarosLista.get(utolsoelem).getKonyvtarosID()) + 1);
        System.out.println("utolso elemID" + ujkonyvtaros.getKonyvtarosID());
        this.konyvtarosLista.add(ujkonyvtaros);
    }

    public void konyvtarosTorlese(String konyvtarosNeve) {
        String Nev = null;
        for (int i = 0; i < konyvtarosLista.size(); ++i) {
            Nev = konyvtarosLista.get(i).getNev();
            if (Nev.equals(konyvtarosNeve)) {
                konyvtarosLista.remove(i);
                System.out.println("torolt");
            }
        }
    }

    public void konyvtarosokKiirasa() {

        for (int i = 0; i < konyvtarosLista.size(); ++i) {
            konyvtarosAdatok(i);
        }
    }

    public void konyvtarosAdatok(int i) {
        System.out.println("konyvtarosID: " + konyvtarosLista.get(i).getKonyvtarosID());
        System.out.println("Nev: " + konyvtarosLista.get(i).getNev());
        System.out.println("Lakcim: " + konyvtarosLista.get(i).getLakcim());
        System.out.println("Email: " + konyvtarosLista.get(i).getEmail());
        System.out.println("Telefon: " + konyvtarosLista.get(i).getTelefon());
        System.out.println("Jelszo: " + konyvtarosLista.get(i).getJelszo());
    }

    public void konyvtarosAdatModositasa(int konyvID, String tipus, String ujErtek) {
        int ID = 0;
        for (int i = 0; i < konyvtarosLista.size(); ++i) {
            ID = konyvtarosLista.get(i).getKonyvtarosID();
            if (ID == konyvID) {
                switch (tipus) {
                    case "ID":
                        konyvtarosLista.get(i).setKonyvtarosID(Integer.parseInt(ujErtek));
                        break;
                    case "Nev":
                        konyvtarosLista.get(i).setNev(ujErtek);
                        break;
                    case "Lakcim":
                        konyvtarosLista.get(i).setLakcim(ujErtek);
                        break;
                    case "Email":
                        konyvtarosLista.get(i).setEmail(ujErtek);
                        break;
                    case "Telefon":
                        konyvtarosLista.get(i).setTelefon(Integer.parseInt(ujErtek));
                        break;
                    case "Jelszo":
                        konyvtarosLista.get(i).setJelszo(ujErtek);
                        break;
                    default:
                        System.out.println("Kivant beallitasi tipus nincs jol megadva");
                }
            }
        }

    }

    public void konyvtarosKeresese(String tipus, String keresett) {

        switch (tipus) {
            case "ID":
                for (int i = 0; i < konyvtarosLista.size(); ++i) {
                    if (konyvtarosLista.get(i).getKonyvtarosID() == Integer.parseInt(keresett)) {
                        konyvtarosAdatok(Integer.parseInt(keresett));
                    }
                }
                break;
            case "Nev":
                String Nev = null;
                for (int i = 0; i < konyvtarosLista.size(); ++i) {
                    Nev = konyvtarosLista.get(i).getNev();
                    if (Nev.equals(keresett)) {
                        konyvtarosAdatok(i);
                    }
                }
                break;
            case "Lakcim":
                String Lakcim = null;
                for (int i = 0; i < konyvtarosLista.size(); ++i) {
                    Lakcim = konyvtarosLista.get(i).getLakcim();
                    if (Lakcim.equals(keresett)) {
                        konyvtarosAdatok(i);
                    }
                }
                break;
            case "Email":
                String Email = null;
                for (int k = 0; k < konyvtarosLista.size(); ++k) {
                    Email = konyvtarosLista.get(k).getEmail();
                    if (Email.equals(keresett)) {
                        konyvtarosAdatok(k);
                    }
                }
                break;
            case "Telefon":
                String Telefon = null;
                for (int k = 0; k < konyvtarosLista.size(); ++k) {
                    if (konyvtarosLista.get(k).getTelefon() == Integer.parseInt(keresett)) {
                        konyvtarosAdatok(Integer.parseInt(keresett));
                    }
                }
                break;
            case "Jelszo":
                String Jelszo = null;
                for (int k = 0; k < konyvtarosLista.size(); ++k) {
                    Jelszo = konyvtarosLista.get(k).getJelszo();
                    if (Jelszo.equals(keresett)) {
                        konyvtarosAdatok(k);
                    }
                }
                break;
            default:
                System.out.println("Kivant keresesi tipus nincs jol megadva");
        }
    }

    public  void WriteXMLFileKonyvtaros(){
        try {

            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            // root elements
            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("Konyvtarosok");
            doc.appendChild(rootElement);


            for (int i = 0; i < konyvtarosLista.size(); ++i) {

                // staff elements
                Element Konyvtaros = doc.createElement("Konyvtaros");
                rootElement.appendChild(Konyvtaros);

                // set attribute to staff element
                Attr attr = doc.createAttribute("id");
                attr.setValue(Integer.toString(konyvtarosLista.get(i).getKonyvtarosID()));
                Konyvtaros.setAttributeNode(attr);

                // shorten way
                // staff.setAttribute("id", "1");

                //
                Element Nev = doc.createElement("Nev");
                Nev.appendChild(doc.createTextNode(konyvtarosLista.get(i).getNev()));
                Konyvtaros.appendChild(Nev);

                //
                Element Lakcim = doc.createElement("Lakcim");
                Lakcim.appendChild(doc.createTextNode(konyvtarosLista.get(i).getLakcim()));
                Konyvtaros.appendChild(Lakcim);

                //
                Element Email = doc.createElement("Email");
                Email.appendChild(doc.createTextNode(konyvtarosLista.get(i).getEmail()));
                Konyvtaros.appendChild(Email);

                //
                Element Jelszo = doc.createElement("Jelszo");
                Jelszo.appendChild(doc.createTextNode(konyvtarosLista.get(i).getJelszo()));
                Konyvtaros.appendChild(Jelszo);

                //
                Element Telefon = doc.createElement("Telefon");
                Telefon.appendChild(doc.createTextNode(Integer.toString(konyvtarosLista.get(i).getTelefon())));
                Konyvtaros.appendChild(Telefon);

                // write the content into xml file
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                DOMSource source = new DOMSource(doc);
                StreamResult result = new StreamResult(new File("D:\\Suliba\\IV\\II felev\\TavkozlesiSzoft\\src\\konyvtar\\konyvtarosListaXML.xml"));

                // Output to console for testing
                // StreamResult result = new StreamResult(System.out);

                transformer.transform(source, result);
            }
            System.out.println("File saved!");

        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }
    }

    public void OlvasasXmlKonyvtaros (){
        try {

            File fXmlFile = new File("D:\\Suliba\\IV\\II felev\\TavkozlesiSzoft\\src\\konyvtar\\konyvtarosListaXML.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);


            doc.getDocumentElement().normalize();

            System.out.println("Gyoker elem :" + doc.getDocumentElement().getNodeName());

            NodeList nList = doc.getElementsByTagName("Konyvtaros");

            System.out.println("----------------------------");

            for (int temp = 0; temp < nList.getLength(); temp++) {

                Node nNode = nList.item(temp);

                System.out.println("\nCurrent Element :" + nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) nNode;

                    System.out.println("konyvtarosID : " + eElement.getAttribute("id"));
                    System.out.println("Nev: " + eElement.getElementsByTagName("Nev").item(0).getTextContent());
                    System.out.println("Lakcim: " + eElement.getElementsByTagName("Lakcim").item(0).getTextContent());
                    System.out.println("Email: " + eElement.getElementsByTagName("Email").item(0).getTextContent());
                    System.out.println("Telefon: " + eElement.getElementsByTagName("Telefon").item(0).getTextContent());
                    System.out.println("Jelszo: " + eElement.getElementsByTagName("Jelszo").item(0).getTextContent());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}