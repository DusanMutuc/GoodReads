package WebProjekat.GoodReads.dto;

public class RegisterDto {
    private String ime;
    private String prezime;
    private String korisnickoIme;
    private String mail;
    private String lozinka;
    private String lozinkaConfirmation;

    RegisterDto(String ime, String prezime, String korisnickoIme, String mail, String lozinka, String lozinkaConfirmation){
        this.ime = ime;
        this.prezime = prezime;
        this.korisnickoIme = korisnickoIme;
        this.mail = mail;
        this.lozinka = lozinka;
        this.lozinkaConfirmation = lozinkaConfirmation;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public String getLozinkaConfirmation() {
        return lozinkaConfirmation;
    }

    public void setLozinkaConfirmation(String lozinkaConfirmation) {
        this.lozinkaConfirmation = lozinkaConfirmation;
    }
}
