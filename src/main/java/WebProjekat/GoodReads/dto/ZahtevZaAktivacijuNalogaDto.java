package WebProjekat.GoodReads.dto;

import WebProjekat.GoodReads.entity.ZahtevZaAktivacijuNaloga;

import java.util.Date;

public class ZahtevZaAktivacijuNalogaDto {
    private String email;
    private String telefon;
    private String poruka;


    public ZahtevZaAktivacijuNalogaDto(ZahtevZaAktivacijuNaloga zahtevZaAktivacijuNaloga){
        this.email = zahtevZaAktivacijuNaloga.getEmail();
        this.telefon = zahtevZaAktivacijuNaloga.getPoruka();
        this.poruka = zahtevZaAktivacijuNaloga.getPoruka();
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
}
