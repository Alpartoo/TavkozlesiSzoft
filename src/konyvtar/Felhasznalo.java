package konyvtar;

public class Felhasznalo implements java.io.Serializable {
    public int felhasznaloID;
    public String Nev;
    public String Lakcim;
    public String Email;
    public int Telefon;

    public Felhasznalo(int felhasznaloID, String Nev,String Lakcim,String Email,int Telefon){
        this.felhasznaloID = felhasznaloID;
        this.Nev = Nev;
        this.Lakcim =Lakcim;
        this.Email = Email;
        this.Telefon = Telefon;
    }

    public void setFelhasznaloID(int felhasznaloID) {
        this.felhasznaloID = felhasznaloID;
    }

    public int getFelhasznaloID() {
        return felhasznaloID;
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

    public int getTelefon() {
        return Telefon;
    }
}


