package konyvtar;

import java.util.ArrayList;

public class FelhasznaloLista implements java.io.Serializable {

    public ArrayList<Felhasznalo> felhasznaloLista;
    public FelhasznaloLista(){

        Felhasznalo[] Felhasznalok = new Felhasznalo[5];
        this.felhasznaloLista = new ArrayList<>();

        Felhasznalok[0] = new Felhasznalo(0,"Sandor","Amburs Lajos","ghguu@gmail.com",754896378);
        Felhasznalok[1] = new Felhasznalo(1,"Pista","Fo utca","gaaa@gmail.com",754586147);
        Felhasznalok[2] = new Felhasznalo(2,"Feri","Borvizek (","huuu@gmail.com",754983761);
        Felhasznalok[3] = new Felhasznalo(3,"Joco","Amburs Lajos","hhttt@gmail.com",754479863);
        Felhasznalok[4] = new Felhasznalo(4,"Geza","Tóth Béla (","okos@gmail.com",754525885);
        Felhasznalok[5] = new Felhasznalo(5,"Csaba","Fo utca","ghguu@gmail.com",754986765);

    }

}
