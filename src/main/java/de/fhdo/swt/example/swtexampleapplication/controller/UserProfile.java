package de.fhdo.swt.example.swtexampleapplication.controller;

import  java.util.Date;



public class UserProfile {
    private String lastname, firstname, mailadress, password, bankAccNumber;
    private int bankAccId; // optional
    private Date birthdate;

    // Konstruktoren
    // 1. necessary
    public UserProfile(String lastname,String firstname,String mailadress, String password)
    {
        this.lastname   = lastname;
        this.firstname  = firstname;
        this.mailadress = mailadress;
        this.password   = password;

    }

    // 2. necessary + birthdate
    public UserProfile(String lastname,String firstname,String mailadress, String password, Date birthdate)
    {
        this(lastname,firstname,mailadress,password);
        this.birthdate  = birthdate;
    }

    // 3. ALL inclusive
    public UserProfile(String lastname,String firstname,String mailadress, String password, Date birthdate, String bankAccNumber)
    {
        this(lastname,firstname,mailadress,password,birthdate);
        this.bankAccNumber = bankAccNumber;
    }

    // Methods



    //Setter & Getter der privaten Attribute
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getMailadress() {
        return mailadress;
    }

    public void setMailadress(String mailadress) {
        this.mailadress = mailadress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBankAccNumber() {
        return bankAccNumber;
    }

    public void setBankAccNumber(String bankAccNumber) {
        this.bankAccNumber = bankAccNumber;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public int getBankAccId() {
        return bankAccId;
    }

    public void setBankAccId(int bankAccId) {
        this.bankAccId = bankAccId;
    }
}
