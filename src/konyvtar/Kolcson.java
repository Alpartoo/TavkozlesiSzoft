package konyvtar;

import java.util.Date;

public class Kolcson implements java.io.Serializable{
    public int KolcsonID;
    public int KonyvAzonosito;
    public int FelhasznaloID;
    public int KonyvtarosID;
    public Date KolcsonzesiDatum;
    private Date KolcsonHatarido;


    public Kolcson(int KolcsonID, int KonyvAzonosito,int FelhasznaloID,int KonyvtarosID,Date KolcsonzesiDatum,Date KolcsonHatarido){
        this.KolcsonID = KolcsonID;
        this.KonyvAzonosito = KonyvAzonosito;
        this.FelhasznaloID =FelhasznaloID;
        this.KonyvtarosID = KonyvtarosID;
        this.KolcsonzesiDatum = KolcsonzesiDatum;
        this.KolcsonHatarido = KolcsonHatarido;
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

    public void setKolcsonzesiDatum(Date kolcsonzesiDatum) {
        KolcsonzesiDatum = kolcsonzesiDatum;
    }
    public Date getKolcsonzesiDatum() {
        return KolcsonzesiDatum;
    }

    public void setKolcsonHatarido(Date kolcsonHatarido) {
        KolcsonHatarido = kolcsonHatarido;
    }

    public Date getKolcsonHatarido() {
        return KolcsonHatarido;
    }
}
