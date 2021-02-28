package konyvtar;

import java.util.ArrayList;

public class Main {



    public static void main(String[] args) {

        Konyv ujkonyv = new Konyv(6,"Proba","Babits Mihály","Corvin","1996.04.08","kulcsszo",true);
        KonyvLista konyvlista = new KonyvLista();
        KolcsonLista kolcsonLista =new KolcsonLista();

        //konyvlista.konyvHozzadas(ujkonyv);
        //konyvlista.konyvListaMentes();
        //konyvlista.konyvListaOlvasas();
        //konyvlista.konyvTorlese("Proba");
        //konyvlista.konyvListaMentes();
        //konyvlista.konyvListaOlvasas();
        //konyvlista.konyvAdatModositasa(6,"ID","7");
        //konyvlista.konyvListaMentes();
        //konyvlista.konyvListaOlvasas();
        //konyvlista.konyvekKiirasa();
        konyvlista.konyvKeresese("Elerhetoseg","true");
        kolcsonLista.kolcsonListaMentes();
        kolcsonLista.kolcsonListaOlvasas();

    }

}
