package WebProjekat.GoodReads.dto;

import WebProjekat.GoodReads.entity.Polica;

public class PolicaDto {
    private String naziv;
    private Boolean primarna;

    public PolicaDto(Polica polica){
        this.naziv = polica.getNaziv();
        this.primarna = polica.getPrimarna();
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Boolean getPrimarna() {
        return primarna;
    }

    public void setPrimarna(Boolean primarna) {
        this.primarna = primarna;
    }
}
