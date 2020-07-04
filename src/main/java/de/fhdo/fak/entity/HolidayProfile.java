package de.fhdo.fak.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class HolidayProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    private Date startDate;
    private Date endDate;
    private int numberPersons;
    private String country;
    private String city;

    public HolidayProfile() {
    }

    public HolidayProfile(Date startDate, Date endDate, int numberPersons, String country, String city) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.numberPersons = numberPersons;
        this.country = country;
        this.city = city;
    }

    public HolidayProfile(Date startDate, Date endDate, int numberPersons, String country) {
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
