package konyvtar;

import java.util.ArrayList;
import java.util.Date;

public class Konyv  implements java.io.Serializable{

    public int konyvID;
    public String Cim;
    public String Szerzo;
    public String Kiado;
    public String KiadasiEv;                                //TODO:Datum tipusra allitas
    public String Kulcsszo;
    public boolean Elerhetoseg;

    public Konyv(int konyvID, String Cim,String Szerzo,String Kiado,String KiadasiEv,String Kulcsszo, boolean Elerhetoseg){
        this.konyvID = konyvID;
        this.Cim = Cim;
        this.Szerzo =Szerzo;
        this.Kiado = Kiado;
        this.KiadasiEv = KiadasiEv;
        this.Kulcsszo = Kulcsszo;
        this.Elerhetoseg = Elerhetoseg;
    }



    public void setKonyvID(int konyvID) {
        this.konyvID = konyvID;
    }

    public int getKonyvID() {
        return konyvID;
    }

    public void setCim(String cim) {
        Cim = cim;
    }

    public String getCim() {
        return Cim;
    }

    public void setSzerzo(String szerzo) {
        Szerzo = szerzo;
    }

    public String getSzerzo() {
        return Szerzo;
    }

    public void setKiado(String kiado) {
        Kiado = kiado;
    }
    public String getKiado() {
        return Kiado;
    }

    public void setKiadasiEv(String kiadasiEv) {
        KiadasiEv = kiadasiEv;
    }

    public String getKiadasiEv() {
        return KiadasiEv;
    }

    public void setKulcsszo(String kulcsszo) {
        Kulcsszo = kulcsszo;
    }

    public String getKulcsszo() {
        return Kulcsszo;
    }

    public void setElerhetoseg(boolean elerhetoseg) {
        Elerhetoseg = elerhetoseg;
    }

    public boolean getElerhetoseg(){ return Elerhetoseg; }

    public boolean isElerhetoseg() {
        return Elerhetoseg;
    }

}
