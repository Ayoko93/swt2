package de.fhdo.swt.example.swtexampleapplication.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String lastName, firstName, mailAdress, password, bankAccNumber;
    private Date birthDate;

    @Column(nullable = true)
    private int bankAccId; // optional

    @OneToMany
    private Set<Rating> ratings;

    // Constructors
    // 1. necessary
    public User(String lastName, String firstName, String mailAdress, String password) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.mailAdress = mailAdress;
        this.password = password;

    }

    // 2. necessary + birthdate
    public User(String lastName, String firstName, String mailAdress, String password, Date birthDate) {
        this(lastName, firstName, mailAdress, password);
        this.birthDate = birthDate;
    }

    // 3. ALL inclusive
    public User(String lastName, String firstName, String mailAdress, String password, Date birthDate, String bankAccNumber) {
        this(lastName, firstName, mailAdress, password, birthDate);
        this.bankAccNumber = bankAccNumber;
    }

    // Methods


    // Setter & Getter of Attributes
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMailAdress() {
        return mailAdress;
    }

    public void setMailAdress(String mailAdress) {
        this.mailAdress = mailAdress;
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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public int getBankAccId() {
        return bankAccId;
    }

    public void setBankAccId(int bankAccId) {
        this.bankAccId = bankAccId;
    }
}
