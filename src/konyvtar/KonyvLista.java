package konyvtar;

import java.util.ArrayList;

public class KonyvLista implements java.io.Serializable {

    public ArrayList<Konyv>  konyvLista;
    public KonyvLista(){

        Konyv[] Konyvek = new Konyv[5];
        this.konyvLista = new ArrayList<>();

        ArrayList<String> Kulcsszavak =new ArrayList<>();
        Kulcsszavak.add("Fuzo");
        Kulcsszavak.add("AKASZTO");

        Konyvek[0] = new Konyv(0,"Elso","Amburs Lajos","Corvin","1996.04.08",Kulcsszavak,true);
        Konyvek[1] = new Konyv(1,"ElsoKORBEN","Babits Mihály","Corvin","1996.04.08",Kulcsszavak,true);
        Konyvek[2] = new Konyv(2,"bARMI JO","Tóth Béla (","Corvin","1996.04.08",Kulcsszavak,true);
        Konyvek[3] = new Konyv(3,"NAGY SZAVAK","Amburs Lajos","Abel","1996.04.08",Kulcsszavak,true);
        Konyvek[4] = new Konyv(4,"Valtozo","Tóth Béla (","Abel","1996.04.08",Kulcsszavak,true);
        Konyvek[5] = new Konyv(5,"Ido","Babits Mihály","Abel","1996.04.08",Kulcsszavak,true);

    }

}
