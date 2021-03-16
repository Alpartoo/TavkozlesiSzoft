package konyvtar;

import konyvtar.Lista.FelhasznaloLista;
import konyvtar.Lista.KolcsonLista;
import konyvtar.Lista.KonyvLista;
import konyvtar.Lista.KonyvtarosLista;

public class Main {



    public static void main(String[] args) {

        Konyv ujkonyv = new Konyv(6,"Proba","Babits Mihály","Corvin","1996.04.08","kulcsszo",true);
        Konyv ujkonyv2 = new Konyv(7,"Proba2","Babits Mihály","Corvin","1996.04.08","kulcsszo",true);
        Konyv ujkonyv3 = new Konyv(8,"Proba3rtrt","Babits Mihály","Corvin","1996.04.08","kulcsszo",true);
        Konyv ujkonyv4 = new Konyv(9,"Pruht","Babits Mihály","Corvin","1996.04.08","kulcsszo",true);

        KonyvLista konyvlista = new KonyvLista();
        KolcsonLista kolcsonLista =new KolcsonLista();
        KonyvtarosLista konyvtarosLista = new KonyvtarosLista();
        FelhasznaloLista felhasznaloLista = new FelhasznaloLista();


        //konyvlista.konyvekSzama();
        /*konyvlista.konyvHozzadas(ujkonyv);
        konyvlista.konyvHozzadas(ujkonyv2);
        konyvlista.konyvHozzadas(ujkonyv3);*/
        //konyvlista.konyvListaMentes();
        //konyvlista.konyvListaOlvasas();
       /* konyvlista.konyvekKiirasa();
        konyvlista.konyvTorlese("Proba");
        konyvlista.konyvekSzama();
        konyvlista.konyvekKiirasa();
        konyvlista.konyvHozzadas(ujkonyv4);*/
        //konyvlista.konyvListaMentes();
        //konyvlista.konyvListaOlvasas();
        //konyvlista.konyvAdatModositasa(6,"ID","7");
        //konyvlista.konyvListaMentes();
        //konyvlista.konyvListaOlvasas();
        //konyvlista.konyvekKiirasa();
        //konyvlista.konyvKeresese("Elerhetoseg","true");
        //kolcsonLista.kolcsonListaOlvasas();
        //konyvlista.WriteXMLFileKonyvek();
        konyvlista.OlvasasXmlKonyvek();
        //kolcsonLista.WriteXMLFileKolcsonok();
        kolcsonLista.OlvasasXmlKolcsonok();
        //konyvtarosLista.WriteXMLFileKonyvtaros();
        konyvtarosLista.OlvasasXmlKonyvtaros();


    }

}
