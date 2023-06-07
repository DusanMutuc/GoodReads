package WebProjekat.GoodReads.dto;

import WebProjekat.GoodReads.entity.Korisnik;
import WebProjekat.GoodReads.entity.Recenzija;

public class RecenzijaDto {
    private String tekst;
    private float  ocena;



    public RecenzijaDto(Recenzija recenzija){
        this.tekst = recenzija.getTekst();
        this.ocena = recenzija.getOcena();
    }

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
