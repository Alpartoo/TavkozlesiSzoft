package konyvtar;

import java.time.LocalDate;
import java.util.Date;

public class Kolcson implements java.io.Serializable{
    public int KolcsonID;
    public int KonyvAzonosito;
    public int FelhasznaloID;
    public int KonyvtarosID;
    public LocalDate KolcsonzesiDatum;
    private LocalDate KolcsonHatarido;


    public Kolcson(int KolcsonID, int KonyvAzonosito,int FelhasznaloID,int KonyvtarosID){
        this.KolcsonID = KolcsonID;
        this.KonyvAzonosito = KonyvAzonosito;
        this.FelhasznaloID =FelhasznaloID;
        this.KonyvtarosID = KonyvtarosID;

    }

    public void setKolcsonID(int kolcsonID) {
        KolcsonID = kolcsonID;
    }
    public int getKolcsonID() {
        return KolcsonID;
    }

    public void setKonyvAzonosito(int konyvAzonosito) {
        KonyvAzonosito = konyvAzonosito;
    }
    public int getKonyvAzonosito() {
        return KonyvAzonosito;
    }

    public void setFelhasznaloID(int felhasznaloID) {
        FelhasznaloID = felhasznaloID;
    }
    public int getFelhasznaloID() {
        return FelhasznaloID;
    }

    public void setKonyvtarosID(int konyvtarosID) {
        KonyvtarosID = konyvtarosID;
    }
    public int getKonyvtarosID() {
        return KonyvtarosID;
    }

}
