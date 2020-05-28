package de.fhdo.swt.example.swtexampleapplication.entity;

import java.util.Date;

public class HoliydayProfile {
    private Date startDate;
    private Date endDate;
    private int numberPersons;
    private String country;
    private String city;

    public HoliydayProfile(Date startDate, Date endDate, int numberPersons, String country, String city) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.numberPersons = numberPersons;
        this.country = country;
        this.city = city;
    }

    public HoliydayProfile(Date startDate, Date endDate, int numberPersons, String country) {
       this(startDate, endDate, numberPersons, country,null);
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getNumberPersons() {
        return numberPersons;
    }

    public void setNumberPersons(int numberPersons) {
        this.numberPersons = numberPersons;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
