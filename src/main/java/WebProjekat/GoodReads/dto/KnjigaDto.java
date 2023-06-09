package WebProjekat.GoodReads.dto;

import WebProjekat.GoodReads.entity.Knjiga;

import java.util.Date;

public class KnjigaDto {
    private String naslov;
    private String naslovnaFotografija;
    private String isbn;
    private Date datumObjavljivanja;
    private String opis;
    private Integer brojStrana;


    public KnjigaDto(Knjiga knjiga){
        this.naslov = knjiga.getNaslov();
        this.naslovnaFotografija = knjiga.getNaslovnaFotografija();
        this.isbn = knjiga.getIsbn();
        this.datumObjavljivanja = knjiga.getDatumObjavljivanja();
        this.opis = knjiga.getOpis();
        this.brojStrana = knjiga.getBrojStrana();
    }
    public KnjigaDto(){

    }

    public KnjigaDto(String naslov, String naslovnaFotografija, String isbn, Date datumObjavljivanja, String opis,Integer brojStrana) {
        this.naslov = naslov;
        this.naslovnaFotografija = naslovnaFotografija;
        this.isbn = isbn;
        this.datumObjavljivanja = datumObjavljivanja;
        this.opis = opis;
        this.brojStrana = brojStrana;
    }

    public String getNaslov() {
        return naslov;
    }

    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }

    public String getNaslovnaFotografija() {
        return naslovnaFotografija;
    }

    public void setNaslovnaFotografija(String naslovnaFotografija) {
        this.naslovnaFotografija = naslovnaFotografija;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setisbn(String isbn) {
        this.isbn = isbn;
    }

    public Date getDatumObjavljivanja() {
        return datumObjavljivanja;
    }

    public void setDatumObjavljivanja(Date datumObjavljivanja) {
        this.datumObjavljivanja = datumObjavljivanja;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Integer getBrojStrana() {
        return brojStrana;
    }

    public void setBrojStrana(Integer brojStrana) {
        this.brojStrana = brojStrana;
    }
}
