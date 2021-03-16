package konyvtar.Lista;

import konyvtar.Kolcson;
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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class KolcsonLista {

    public ArrayList<Kolcson> kolcsonLista;
    public KolcsonLista(){

        Kolcson[] Kolcsonok = new Kolcson[5];
        this.kolcsonLista = new ArrayList<>();

        Kolcsonok[0] = new Kolcson(0,2,2,0);
        Kolcsonok[1] = new Kolcson(1,1,2,2);
        Kolcsonok[2] = new Kolcson(2,5,4,1);

        for( int i=0;i< Kolcsonok.length;i++ ) {
            kolcsonLista.add(Kolcsonok[i]);
        }
    }

    public void kolcsonListaMentes (){

        try {
            FileOutputStream fileOut = new FileOutputStream("D:\\Suliba\\IV\\II felev\\TavkozlesiSzoft\\src\\konyvtar\\kolcsonLista.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(kolcsonLista);
            out.close();
            fileOut.close();
            System.out.printf("File mentve\n");
        } catch (IOException i) {
            i.printStackTrace();
        }

    }


    public void kolcsonListaOlvasas(){
        System.out.println("Konyvek listazasa...");
        try {
            FileInputStream fileIn = new FileInputStream("D:\\Suliba\\IV\\II felev\\TavkozlesiSzoft\\src\\konyvtar\\kolcsonLista.txt");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            kolcsonLista = (ArrayList<Kolcson>) in.readObject();

            for(Kolcson kolcson : kolcsonLista){
                System.out.println("KolcsonID: " + kolcson.getKolcsonID());
                System.out.println("KonyvAzonosito: " + kolcson.getKonyvAzonosito());
                System.out.println("FelhasznaloID: " + kolcson.getFelhasznaloID());
                System.out.println("KonyvtarosID: " + kolcson.getKonyvtarosID());
                System.out.println("KolcsonzesiDatum: " + kolcson.getKolcsonzesiDatum());
                System.out.println("KolcsonHatarido: " + kolcson.getKolcsonHatarido());
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
    public void kolcsonzesHozzadas (Kolcson ujkolcsonzes){

        int utolsoelem = kolcsonLista.size()-1;
        System.out.println("utolso elem"+utolsoelem);
        ujkolcsonzes.setKolcsonID((kolcsonLista.get(utolsoelem).getKolcsonID())+1);
        System.out.println("utolso elemID"+ujkolcsonzes.getKolcsonID());
        this.kolcsonLista.add(ujkolcsonzes);
    }

    public void kolcsonzesTorlese (String kolcsonzesID){
        int ID=0;
        for( int i=0;i< kolcsonLista.size();++i ) {
            ID=kolcsonLista.get(i).getKolcsonID();
            if (ID == Integer.parseInt(kolcsonzesID)) {
                kolcsonLista.remove(i);
                System.out.println("torolt");
            }
        }
    }

    public void kolcsonzesKiirasa(){

        for( int i=0;i< kolcsonLista.size();++i ) {
            kolcsonzesAdatok(i);
        }
    }

    public void kolcsonzesAdatok(int i){
                System.out.println("KolcsonID: " + kolcsonLista.get(i).getKolcsonID());
                System.out.println("KonyvAzonosito: " + kolcsonLista.get(i).getKonyvAzonosito());
                System.out.println("FelhasznaloID: " + kolcsonLista.get(i).getFelhasznaloID());
                System.out.println("KonyvtarosID: " + kolcsonLista.get(i).getKonyvtarosID());
                System.out.println("KolcsonzesiDatum: " + kolcsonLista.get(i).getKolcsonzesiDatum());
                System.out.println(": " + kolcsonLista.get(i).getKolcsonHatarido());

    }

    public void kolcsonzesAdatModositasa(int konyvID,String tipus,int ujErtek){
        int ID=0;
        for( int i=0;i< kolcsonLista.size();++i ) {
            ID=kolcsonLista.get(i).getKolcsonID();
            if (ID == konyvID) {
                switch (tipus){
                    case "KolcsonID":
                        kolcsonLista.get(i).setKolcsonID(ujErtek);
                        break;
                    case "KonyvAzonosito":
                        kolcsonLista.get(i).setKonyvAzonosito(ujErtek);
                        break;
                    case "FelhasznaloID":
                        kolcsonLista.get(i).setFelhasznaloID(ujErtek);
                        break;
                    case "KonyvtarosID":
                        kolcsonLista.get(i).setKonyvtarosID(ujErtek);
                        break;
                    default:
                        System.out.println("Kivant beallitasi tipus nincs jol megadva");
                }
            }
        }

    }

    public void kolcsonzesKeresese(String tipus,String keresett){

        switch (tipus){
            case "KolcsonID":
                for( int i=0;i< kolcsonLista.size();++i ) {
                    if (kolcsonLista.get(i).getKolcsonID() == Integer.parseInt(keresett)){
                        kolcsonzesAdatok(Integer.parseInt(keresett));
                    }
                }
                break;
            case "KonyvAzonosito":
                String Cim=null;
                for( int i=0;i< kolcsonLista.size();++i ) {
                    if (kolcsonLista.get(i).getKonyvAzonosito()== Integer.parseInt(keresett)){
                        kolcsonzesAdatok(Integer.parseInt(keresett));
                    }
                }
                break;
            case "FelhasznaloID":
                String Szerzo=null;
                for( int i=0;i< kolcsonLista.size();++i ) {
                    if (kolcsonLista.get(i).getFelhasznaloID() == Integer.parseInt(keresett)){
                        kolcsonzesAdatok(Integer.parseInt(keresett));
                    }
                }
                break;
            case "KonyvtarosID":
                String Kiado=null;
                for( int k=0;k< kolcsonLista.size();++k ) {
                    if (kolcsonLista.get(k).getKonyvtarosID() == Integer.parseInt(keresett)){
                        kolcsonzesAdatok(Integer.parseInt(keresett));
                    }
                }
                break;
            case "KolcsonzesiDatum":
                String KiadasiEv=null;
                for( int k=0;k< kolcsonLista.size();++k ) {
                    KiadasiEv = kolcsonLista.get(k).getKolcsonzesiDatum().toString();
                    if (KiadasiEv.equals(keresett)) {
                        kolcsonzesAdatok(k);
                    }
                }
                break;
            case "KolcsonHatarido":
                String Kulcsszo=null;
                for( int k=0;k< kolcsonLista.size();++k ) {
                    Kulcsszo = kolcsonLista.get(k).getKolcsonHatarido().toString();
                    if (Kulcsszo.equals(keresett)) {
                        kolcsonzesAdatok(k);
                    }
                }
                break;
            default:
                System.out.println("Kivant keresesi tipus nincs jol megadva");
        }
    }

    public  void WriteXMLFileKolcsonok(){
        try {

            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            // root elements
            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("kolcsonLista");
            doc.appendChild(rootElement);


            for (int i = 0; i < kolcsonLista.size(); ++i) {

                // staff elements
                Element kolcson = doc.createElement("kolcson");
                rootElement.appendChild(kolcson);

                // set attribute to staff element
                Attr attr = doc.createAttribute("id");
                attr.setValue(Integer.toString(kolcsonLista.get(i).getKolcsonID()));
                kolcson.setAttributeNode(attr);

                // shorten way
                // staff.setAttribute("id", "1");

                //
                Element KonyvAzonosito = doc.createElement("KonyvAzonosito");
                KonyvAzonosito.appendChild(doc.createTextNode(Integer.toString(kolcsonLista.get(i).getKonyvAzonosito())));
                kolcson.appendChild(KonyvAzonosito);

                //
                Element FelhasznaloID = doc.createElement("FelhasznaloID");
                FelhasznaloID.appendChild(doc.createTextNode(Integer.toString(kolcsonLista.get(i).getFelhasznaloID())));
                kolcson.appendChild(FelhasznaloID);

                //
                Element KonyvtarosID = doc.createElement("KonyvtarosID");
                KonyvtarosID.appendChild(doc.createTextNode(Integer.toString(kolcsonLista.get(i).getKonyvtarosID())));
                kolcson.appendChild(KonyvtarosID);

                //
                Element Telefon = doc.createElement("KolcsonzesiDatum");
                Telefon.appendChild(doc.createTextNode((kolcsonLista.get(i).getKolcsonzesiDatum()).toString()));
                kolcson.appendChild(Telefon);

                //
                Element KolcsonHatarido = doc.createElement("KolcsonHatarido");
                KolcsonHatarido.appendChild(doc.createTextNode((kolcsonLista.get(i).getKolcsonHatarido()).toString()));
                kolcson.appendChild(KolcsonHatarido);

                // write the content into xml file
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                DOMSource source = new DOMSource(doc);
                StreamResult result = new StreamResult(new File("D:\\Suliba\\IV\\II felev\\TavkozlesiSzoft\\src\\konyvtar\\kolcsonListaXML.xml"));

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

    public void OlvasasXmlKolcsonok (){
        try {

            File fXmlFile = new File("D:\\Suliba\\IV\\II felev\\TavkozlesiSzoft\\src\\konyvtar\\kolcsonListaXML.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);


            doc.getDocumentElement().normalize();

            System.out.println("Gyoker elem :" + doc.getDocumentElement().getNodeName());

            NodeList nList = doc.getElementsByTagName("kolcson");

            System.out.println("----------------------------");

            for (int temp = 0; temp < nList.getLength(); temp++) {

                Node nNode = nList.item(temp);

                System.out.println("\nCurrent Element :" + nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) nNode;

                    System.out.println("KolcsonID : " + eElement.getAttribute("id"));
                    System.out.println("KonyvAzonosito: " + eElement.getElementsByTagName("KonyvAzonosito").item(0).getTextContent());
                    System.out.println("FelhasznaloID: " + eElement.getElementsByTagName("FelhasznaloID").item(0).getTextContent());
                    System.out.println("KonyvtarosID: " + eElement.getElementsByTagName("KonyvtarosID").item(0).getTextContent());
                    System.out.println("KolcsonzesiDatum: " + eElement.getElementsByTagName("KolcsonzesiDatum").item(0).getTextContent());
                    System.out.println("KolcsonHatarido: " + eElement.getElementsByTagName("KolcsonHatarido").item(0).getTextContent());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
