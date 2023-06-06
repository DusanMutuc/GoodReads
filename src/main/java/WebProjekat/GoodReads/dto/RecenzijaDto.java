package WebProjekat.GoodReads.dto;

import WebProjekat.GoodReads.entity.Korisnik;

public class RecenzijaDto {
    private String tekst;
    private float  ocena;

    public String getTekst() {
        return tekst;
    }

    public void setTekst(String tekst) {
        this.tekst = tekst;
    }

    public float getOcena() {
        return ocena;
    }

    public void setOcena(float ocena) {
        this.ocena = ocena;
    }
}
