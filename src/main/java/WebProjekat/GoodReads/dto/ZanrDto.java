package WebProjekat.GoodReads.dto;

import WebProjekat.GoodReads.entity.Zanr;

public class ZanrDto {
    private String naziv;
    public ZanrDto(Zanr zanr){
        this.naziv = zanr.getNaziv();
    }
    public ZanrDto(){

    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
}
