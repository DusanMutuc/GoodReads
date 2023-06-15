package WebProjekat.GoodReads.dto;

import WebProjekat.GoodReads.entity.ZahtevZaAktivacijuNaloga;

import java.util.Date;

public class ZahtevZaAktivacijuNalogaDto {
    //Preko postmana govorimo koji autor nalog zelimo preko idAutor polja za sad, kasnije ce biti preko dugmeta.
    private Long idAutor;
    private String email;
    private String telefon;
    private String poruka;


    public ZahtevZaAktivacijuNalogaDto(ZahtevZaAktivacijuNaloga zahtevZaAktivacijuNaloga){
        this.email = zahtevZaAktivacijuNaloga.getEmail();
        this.telefon = zahtevZaAktivacijuNaloga.getPoruka();
        this.poruka = zahtevZaAktivacijuNaloga.getPoruka();
        this.idAutor=zahtevZaAktivacijuNaloga.getAutor().getID();
    }
    public ZahtevZaAktivacijuNalogaDto(String email, String telefon, String poruka){
        this.email=email;
        this.telefon = telefon;
        this.poruka = poruka;
    }
    public ZahtevZaAktivacijuNalogaDto(){

    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getPoruka() {
        return poruka;
    }

    public void setPoruka(String poruka) {
        this.poruka = poruka;
    }

    public long getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(long idAutor) {
        this.idAutor = idAutor;
    }
}
