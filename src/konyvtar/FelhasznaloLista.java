package konyvtar;

import java.io.*;
import java.util.ArrayList;

public class FelhasznaloLista implements java.io.Serializable {

    public ArrayList<Felhasznalo> felhasznaloLista;
    public FelhasznaloLista() {

        Felhasznalo[] Felhasznalok = new Felhasznalo[100];
        this.felhasznaloLista = new ArrayList<>();

        Felhasznalok[0] = new Felhasznalo(0, "Sandor", "Amburs Lajos", "ghguu@gmail.com", 754896378);
        Felhasznalok[1] = new Felhasznalo(1, "Pista", "Fo utca", "gaaa@gmail.com", 754586147);
        Felhasznalok[2] = new Felhasznalo(2, "Feri", "Borvizek (", "huuu@gmail.com", 754983761);
        Felhasznalok[3] = new Felhasznalo(3, "Joco", "Amburs Lajos", "hhttt@gmail.com", 754479863);
        Felhasznalok[4] = new Felhasznalo(4, "Geza", "Tóth Béla (", "okos@gmail.com", 754525885);
        Felhasznalok[5] = new Felhasznalo(5, "Csaba", "Fo utca", "ghguu@gmail.com", 754986765);

        for (int i = 0; i < Felhasznalok.length; i++) {
            felhasznaloLista.add(Felhasznalok[i]);
        }
    }
        public void felhasznaloListaMentes (){

            try {
                FileOutputStream fileOut = new FileOutputStream("D:\\Suliba\\IV\\II felev\\TavkozlesiSzoft\\src\\konyvtar\\felhasznaloLista.txt");
                ObjectOutputStream out = new ObjectOutputStream(fileOut);
                out.writeObject(felhasznaloLista);
                out.close();
                fileOut.close();
                System.out.printf("File mentve\n");
            } catch (IOException i) {
                i.printStackTrace();
            }

        }

        public void felhasznaloListaOlvasas(){
            System.out.println("Konyvek listazasa...");
            try {
                FileInputStream fileIn = new FileInputStream("D:\\Suliba\\IV\\II felev\\TavkozlesiSzoft\\src\\konyvtar\\felhasznaloLista.txt");
                ObjectInputStream in = new ObjectInputStream(fileIn);
                felhasznaloLista = (ArrayList<Felhasznalo>) in.readObject();

                for(Felhasznalo felhasznalo : felhasznaloLista){
                    System.out.println("FelhasznaloID: " + felhasznalo.getFelhasznaloID());
                    System.out.println("Nev: " + felhasznalo.getNev());
                    System.out.println("Lakcim: " + felhasznalo.getLakcim());
                    System.out.println("Email: " + felhasznalo.getEmail());
                    System.out.println("Telefon: " + felhasznalo.getTelefon());
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

        public void felhasznaloHozzadas (Felhasznalo ujFelhasznalo){

            ujFelhasznalo.setFelhasznaloID(felhasznaloLista.size());
            this.felhasznaloLista.add(ujFelhasznalo);
        }

        public void felhasznaloTorlese (String felhasznaloNev){
            String Nev=null;
            for( int i=0;i< felhasznaloLista.size();++i ) {
                Nev=felhasznaloLista.get(i).getNev();
                if (Nev.equals(felhasznaloNev)) {
                    felhasznaloLista.remove(i);
                    System.out.println("torolt");
                }
            }
        }

        public void felhasznaloKiirasa(){

            for( int i=0;i< felhasznaloLista.size();++i ) {
                felhasznaloAdatok(i);
            }
        }

        public void felhasznaloAdatok(int ID){
            for( int i=0;i< felhasznaloLista.size();++i ) {
                if (felhasznaloLista.get(i).getFelhasznaloID()== ID){
                    System.out.println("felhasznaloID: " + felhasznaloLista.get(i).felhasznaloID);
                    System.out.println("Nev: " + felhasznaloLista.get(i).getNev());
                    System.out.println("Lakcim: " + felhasznaloLista.get(i).getLakcim());
                    System.out.println("Email: " + felhasznaloLista.get(i).getEmail());
                    System.out.println("Telefon: " + felhasznaloLista.get(i).getTelefon());
                }
            }
        }

        public void felhasznaloAdatModositasa(int konyvID,String tipus,String ujErtek){
            int ID=0;
            for( int i=0;i< felhasznaloLista.size();++i ) {
                ID=felhasznaloLista.get(i).getFelhasznaloID();
                if (ID == konyvID) {
                    switch (tipus){
                        case "ID":
                            felhasznaloLista.get(i).setFelhasznaloID(Integer.parseInt(ujErtek));
                            break;
                        case "Nev":
                            felhasznaloLista.get(i).setNev(ujErtek);
                            break;
                        case "Lakcim":
                            felhasznaloLista.get(i).setLakcim(ujErtek);
                            break;
                        case "Email":
                            felhasznaloLista.get(i).setEmail(ujErtek);
                            break;
                        case "Telefon":
                            felhasznaloLista.get(i).setTelefon(Integer.parseInt(ujErtek));
                            break;
                        default:
                            System.out.println("Kivant beallitasi tipus nincs jol megadva");
                    }
                }
            }

        }

        public void felhasznaloKeresese(String tipus,String keresett){

            switch (tipus){
                case "ID":
                    for( int i=0;i< felhasznaloLista.size();++i ) {
                        if (felhasznaloLista.get(i).getFelhasznaloID() == Integer.parseInt(keresett)){
                            felhasznaloAdatok(Integer.parseInt(keresett));
                        }
                    }
                    break;
                case "Nev":
                    String Cim=null;
                    for( int i=0;i< felhasznaloLista.size();++i ) {
                        Cim = felhasznaloLista.get(i).getNev();
                        if (Cim.equals(keresett)) {
                            felhasznaloAdatok(i);
                        }
                    }
                    break;
                case "Lakcim":
                    String Szerzo=null;
                    for( int i=0;i< felhasznaloLista.size();++i ) {
                        Szerzo = felhasznaloLista.get(i).getLakcim();
                        if (Szerzo.equals(keresett)) {
                            felhasznaloAdatok(i);
                        }
                    }
                    break;
                case "Email":
                    String Kiado=null;
                    for( int k=0;k< felhasznaloLista.size();++k ) {
                        Kiado = felhasznaloLista.get(k).getEmail();
                        if (Kiado.equals(keresett)) {
                            felhasznaloAdatok(k);
                        }
                    }
                    break;
                case "Telefon":
                    long telefon=0;
                    for( int k=0;k< felhasznaloLista.size();++k ) {
                        telefon = felhasznaloLista.get(k).getTelefon();
                        if (telefon == Integer.parseInt(keresett)) {
                            felhasznaloAdatok(k);
                        }
                    }
                    break;
                default:
                    System.out.println("Kivant keresesi tipus nincs jol megadva");
            }
        }
    }
