package konyvtar;

import java.util.ArrayList;

public class KolcsonLista {

    public ArrayList<Kolcson> kolcsonLista;
    public KolcsonLista(){

        Kolcson[] Kolcsonok = new Kolcson[5];
        this.kolcsonLista = new ArrayList<>();

        Kolcsonok[0] = new Kolcson(0,2,2,0);
        Kolcsonok[1] = new Kolcson(1,1,2,2);
        Kolcsonok[2] = new Kolcson(2,5,4,1);

    }
}
