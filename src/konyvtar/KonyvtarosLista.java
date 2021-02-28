package konyvtar;

import java.util.ArrayList;

public class KonyvtarosLista {

    public ArrayList<Konyvtaros> konyvtarosLista;
    public KonyvtarosLista(){

        Konyvtaros[] Konyvtarosok = new Konyvtaros[5];
        this.konyvtarosLista = new ArrayList<>();

        Konyvtarosok[0] = new Konyvtaros(0,"Sandor","Amburs Lajos","ghguu@gmail.com",754896378,"fdsfsdf");
        Konyvtarosok[1] = new Konyvtaros(1,"Pista","Fo utca","gaaa@gmail.com",754586147,"23jjrj");
        Konyvtarosok[2] = new Konyvtaros(2,"Feri","Borvizek (","huuu@gmail.com",754983761,"dsds678");


    }
}
