package de.fhdo.swt.example.swtexampleapplication.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Date;

@Entity
public class SupportTicket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String bearbeiter;
    private String autor;
    //private TicketStatus status;
    private String titel;
    private String beschreibung;
    private Date erstelldatum;
    private Date aktualisierungsdatum;
    private ArrayList<String> kommentare;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBearbeiter() {
        return bearbeiter;
    }

    public void setBearbeiter(String bearbeiter) {
        this.bearbeiter = bearbeiter;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public Date getErstelldatum() {
        return erstelldatum;
    }

    public void setErstelldatum(Date erstelldatum) {
        this.erstelldatum = erstelldatum;
    }

    public Date getAktualisierungsdatum() {
        return aktualisierungsdatum;
    }

    public void setAktualisierungsdatum(Date aktualisierungsdatum) {
        this.aktualisierungsdatum = aktualisierungsdatum;
    }

    public ArrayList<String> getKommentare() {
        return kommentare;
    }

    public void setKommentare(ArrayList<String> kommentare) {
        this.kommentare = kommentare;
    }
}
