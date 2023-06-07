package WebProjekat.GoodReads.entity;

import WebProjekat.GoodReads.dto.ZahtevZaAktivacijuNalogaDto;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;


@Entity
public class ZahtevZaAktivacijuNaloga implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    private String email;
    private String telefon;
    private String poruka;
    private Date datum;
    @Enumerated(EnumType.STRING)
    private Status status;
    @ManyToOne
    private Autor autor;

    public ZahtevZaAktivacijuNaloga(){
        this.email = "";
        this.telefon = "";
        this.poruka = "";
        this.datum = new Date();
    }
    public ZahtevZaAktivacijuNaloga(ZahtevZaAktivacijuNalogaDto dto){
        this.email = dto.getEmail();
        this.telefon = dto.getTelefon();
        this.poruka = dto.getPoruka();
        this.datum = new Date();
        this.status = Status.NACEKANJU;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
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

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }
}
