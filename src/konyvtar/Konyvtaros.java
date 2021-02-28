package konyvtar;

public class Konyvtaros  implements java.io.Serializable{
    public int konyvtarosID;
    public String Nev;
    public String Lakcim;
    public String Email;
    public int Telefon;
    private String Jelszo;


    public Konyvtaros(int konyvtarosID, String Nev,String Lakcim,String Email,int Telefon,String Jelszo){
        this.konyvtarosID = konyvtarosID;
        this.Nev = Nev;
        this.Lakcim =Lakcim;
        this.Email = Email;
        this.Telefon = Telefon;
        this.Jelszo = Jelszo;
    }

    public void setKonyvtarosID(int konyvtarosID) {
        this.konyvtarosID = konyvtarosID;
    }
    public int getKonyvtarosID() {
        return konyvtarosID;
    }

    public void setNev(String nev) {
        Nev = nev;
    }
    public String getNev() {
        return Nev;
    }

    public void setLakcim(String lakcim) {
        Lakcim = lakcim;
    }
    public String getLakcim() {
        return Lakcim;
    }

    public void setEmail(String email) {
        Email = email;
    }
    public String getEmail() {
        return Email;
    }

    public void setTelefon(int telefon) {
        Telefon = telefon;
    }
    public int getTelefon(){
        return Telefon;
    }

    public void setJelszo(String jelszo) {
        Jelszo = jelszo;
    }
    public String getJelszo() {
        return Jelszo;
    }
}
