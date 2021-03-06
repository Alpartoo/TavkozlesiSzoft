package konyvtar.Lista;

import konyvtar.Konyv;
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

public class KonyvLista implements java.io.Serializable {

    public ArrayList<Konyv>  konyvLista;

    public KonyvLista(){

        Konyv[] Konyvek = new Konyv[6];
        this.konyvLista = new ArrayList<>();



        Konyvek[0] = new Konyv(0,"Elso","Amburs Lajos","Corvin","1996.04.08","kulcsszo",true);
        Konyvek[1] = new Konyv(1,"ElsoKORBEN","Babits Mihály","Corvin","1996.04.08","kulcsszo",true);
        Konyvek[2] = new Konyv(2,"bARMI JO","Tóth Béla (","Corvin","1996.04.08","kulcsszo",false);
        Konyvek[3] = new Konyv(3,"NAGY SZAVAK","Amburs Lajos","Abel","1996.04.08","kulcsszo",true);
        Konyvek[4] = new Konyv(4,"Valtozo","Tóth Béla (","Abel","1996.04.08","kulcsszo",true);
        Konyvek[5] = new Konyv(5,"Ido","Babits Mihály","Abel","1996.04.08","kulcsszo",true);

        for( int i=0;i< Konyvek.length;i++ ) {
            konyvLista.add(Konyvek[i]);
        }
    }

    public void konyvListaMentes(){

        try {
            FileOutputStream fileOut = new FileOutputStream("D:\\Suliba\\IV\\II felev\\TavkozlesiSzoft\\src\\konyvtar\\konyvLista.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(konyvLista);
            out.close();
            fileOut.close();
            System.out.printf("File mentve\n");
        } catch (IOException i) {
            i.printStackTrace();
        }

    }

    public void konyvListaOlvasas(){
        System.out.println("Konyvek listazasa...");
        try {
            FileInputStream fileIn = new FileInputStream("D:\\Suliba\\IV\\II felev\\TavkozlesiSzoft\\src\\konyvtar\\konyvLista.txt");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            konyvLista = (ArrayList<Konyv>) in.readObject();

            for(Konyv Konyv : konyvLista){
                System.out.println("konyvID: " + Konyv.getKonyvID());
                System.out.println("Cim: " + Konyv.getCim());
                System.out.println("Szerzo: " + Konyv.getSzerzo());
                System.out.println("Kiado: " + Konyv.getKiado());
                System.out.println("KiadasiEv: " + Konyv.getKiadasiEv());
                System.out.println("Kulcsszo: " + Konyv.getKulcsszo());
                System.out.println("Elerhetoseg: " + Konyv.isElerhetoseg());
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

    public void konyvHozzadas (Konyv ujkonyv){
        int utolsoelem = konyvLista.size()-1;
        System.out.println("utolso elem"+utolsoelem);
        ujkonyv.setKonyvID((konyvLista.get(utolsoelem).getKonyvID())+1);
        System.out.println("utolso elemID"+ujkonyv.getKonyvID());
        this.konyvLista.add(ujkonyv);
    }

    public void konyvTorlese (String konyvcim){
        String Cim=null;
        for( int i=0;i< konyvLista.size();++i ) {
            Cim=konyvLista.get(i).getCim();
            if (Cim.equals(konyvcim)) {
                konyvLista.remove(i);
                System.out.println("torolt"+i);
            }
        }
    }

    public void konyvekKiirasa(){

        for( int i=0;i< konyvLista.size();++i ) {
            konyAdatok(i);
        }
    }

    public void konyAdatok(int ID){
                System.out.println("konyvID: " + konyvLista.get(ID).getKonyvID());
                System.out.println("Cim: " + konyvLista.get(ID).getCim());
                System.out.println("Szerzo: " + konyvLista.get(ID).getSzerzo());
                System.out.println("Kiado: " + konyvLista.get(ID).getKiado());
                System.out.println("KiadasiEv: " + konyvLista.get(ID).getKiadasiEv());
                System.out.println("Kulcsszo: " + konyvLista.get(ID).getKulcsszo());
                System.out.println("Elerheto: " + konyvLista.get(ID).getElerhetoseg());
    }


    public void konyvAdatModositasa(int konyvID,String tipus,String ujErtek){
        int ID=0;                                                       // meglehet csinalni,hogy egyszerre tobb parametert is valtoztassunk,
        for( int i=0;i< konyvLista.size();++i ) {                       // de jelenleg csak egyre mukodik.
            ID=konyvLista.get(i).getKonyvID();
            if (ID == konyvID) {
                switch (tipus){
                    case "ID":
                        konyvLista.get(i).setKonyvID(Integer.parseInt(ujErtek));            //TODO:valahol kell figyelni,hogy ha atallitok egy ID-t akkor
                        break;                                                              //TODO:kovetkezo kony ID hozzadasanal ne legyen utkozes --utolagos munka
                    case "Cim":
                        konyvLista.get(i).setCim(ujErtek);
                        break;
                    case "Szerzo":
                        konyvLista.get(i).setSzerzo(ujErtek);
                        break;
                    case "Kiado":
                        konyvLista.get(i).setKiado(ujErtek);
                        break;
                    case "KiadasiEv":
                        konyvLista.get(i).setKiadasiEv(ujErtek);
                        break;
                    case "Kulcsszo":
                        konyvLista.get(i).setKulcsszo(ujErtek);
                        break;
                    case "Elerhetoseg":
                        konyvLista.get(i).setElerhetoseg(Boolean.parseBoolean(ujErtek));
                        break;
                    default:
                        System.out.println("Kivant beallitasi tipus nincs jol megadva");
                }
            }
        }

    }

    public void konyvKeresese(String tipus,String keresett){

        switch (tipus){
            case "ID":
                for( int i=0;i< konyvLista.size();++i ) {
                    if (konyvLista.get(i).getKonyvID() == Integer.parseInt(keresett)){
                        konyAdatok(Integer.parseInt(keresett));
                    }
                }
                break;
            case "Cim":
                String Cim=null;
                for( int i=0;i< konyvLista.size();++i ) {
                    Cim = konyvLista.get(i).getCim();
                    if (Cim.equals(keresett)) {
                        konyAdatok(i);
                    }
                }
                break;
            case "Szerzo":
                String Szerzo=null;
                for( int i=0;i< konyvLista.size();++i ) {
                    Szerzo = konyvLista.get(i).getSzerzo();
                    if (Szerzo.equals(keresett)) {
                        konyAdatok(i);
                    }
                }
                break;
            case "Kiado":
                String Kiado=null;
                for( int k=0;k< konyvLista.size();++k ) {
                    Kiado = konyvLista.get(k).getKiado();
                    if (Kiado.equals(keresett)) {
                        konyAdatok(k);
                    }
                }
                break;
            case "KiadasiEv":
                String KiadasiEv=null;
                for( int k=0;k< konyvLista.size();++k ) {
                    KiadasiEv = konyvLista.get(k).getKiadasiEv();
                    if (KiadasiEv.equals(keresett)) {
                        konyAdatok(k);
                    }
                }
                break;
            case "Kulcsszo":
                String Kulcsszo=null;
                for( int k=0;k< konyvLista.size();++k ) {
                    Kulcsszo = konyvLista.get(k).getKulcsszo();
                    if (Kulcsszo.equals(keresett)) {
                        konyAdatok(k);
                    }
                }
                break;
            case "Elerhetoseg":
                Boolean Elerhetoseg=null;
                for( int k=0;k< konyvLista.size();++k ) {
                    Elerhetoseg = konyvLista.get(k).getElerhetoseg();
                    if (Elerhetoseg.equals(Boolean.parseBoolean(keresett))) {
                        konyAdatok(k);
                    }
                }
                break;
            default:
                System.out.println("Kivant keresesi tipus nincs jol megadva");
        }
    }

    public void konyvekSzama(){
        System.out.println(konyvLista.size());
    }

    public  void WriteXMLFileKonyvek(){
        try {

            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            // root elements
            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("konyvtar");
            doc.appendChild(rootElement);


            for (int i = 0; i < konyvLista.size(); ++i) {

                // staff elements
                Element Konyv = doc.createElement("Konyv");
                rootElement.appendChild(Konyv);

                // set attribute to staff element
                Attr attr = doc.createAttribute("id");
                attr.setValue(Integer.toString(konyvLista.get(i).getKonyvID()));
                Konyv.setAttributeNode(attr);

                // shorten way
                // staff.setAttribute("id", "1");

                //
                Element Cim = doc.createElement("Cim");
                Cim.appendChild(doc.createTextNode(konyvLista.get(i).getCim()));
                Konyv.appendChild(Cim);

                //
                Element Szerzo = doc.createElement("Szerzo");
                Szerzo.appendChild(doc.createTextNode(konyvLista.get(i).getSzerzo()));
                Konyv.appendChild(Szerzo);

                //
                Element Kiado = doc.createElement("Kiado");
                Kiado.appendChild(doc.createTextNode(konyvLista.get(i).getKiado()));
                Konyv.appendChild(Kiado);

                //
                Element KiadasiEv = doc.createElement("KiadasiEv");
                KiadasiEv.appendChild(doc.createTextNode(konyvLista.get(i).getKiadasiEv()));
                Konyv.appendChild(KiadasiEv);

                //
                Element Elerhetoseg = doc.createElement("Elerhetoseg");
                Elerhetoseg.appendChild(doc.createTextNode(Boolean.toString(konyvLista.get(i).getElerhetoseg())));
                Konyv.appendChild(Elerhetoseg);

                //
                Element Kulcsszo = doc.createElement("Kulcsszo");
                Kulcsszo.appendChild(doc.createTextNode(konyvLista.get(i).getKulcsszo()));
                Konyv.appendChild(Kulcsszo);

                // write the content into xml file
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                DOMSource source = new DOMSource(doc);
                StreamResult result = new StreamResult(new File("D:\\Suliba\\IV\\II felev\\TavkozlesiSzoft\\src\\konyvtar\\konyvLista.txt"));

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

    public void OlvasasXmlKonyvek (){
        try {

            File fXmlFile = new File("D:\\Suliba\\IV\\II felev\\TavkozlesiSzoft\\src\\konyvtar\\konyvLista.txt");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);


            doc.getDocumentElement().normalize();

            System.out.println("GYoker elem :" + doc.getDocumentElement().getNodeName());

            NodeList nList = doc.getElementsByTagName("Konyv");

            System.out.println("----------------------------");

            for (int temp = 0; temp < nList.getLength(); temp++) {

                Node nNode = nList.item(temp);

                System.out.println("\nCurrent Element :" + nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) nNode;

                    System.out.println("konyvID : " + eElement.getAttribute("id"));
                    System.out.println("Cim: " + eElement.getElementsByTagName("Cim").item(0).getTextContent());
                    System.out.println("Szerzo: " + eElement.getElementsByTagName("Szerzo").item(0).getTextContent());
                    System.out.println("Kiado: " + eElement.getElementsByTagName("Kiado").item(0).getTextContent());
                    System.out.println("KiadasiEv: " + eElement.getElementsByTagName("KiadasiEv").item(0).getTextContent());
                    System.out.println("Kulcsszo: " + eElement.getElementsByTagName("Kulcsszo").item(0).getTextContent());
                    System.out.println("Elerhetoseg: " + eElement.getElementsByTagName("Elerhetoseg").item(0).getTextContent());

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
