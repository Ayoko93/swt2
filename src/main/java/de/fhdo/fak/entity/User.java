package de.fhdo.fak.entity;

import java.util.Date;
import java.util.List;

import javax.annotation.Nullable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Past;

@Entity
@Table(name = "user_")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String lastName;

    private String firstName;

    @Column(unique = true)
    private String mailAddress;

    private String password;

    @Past
    @Nullable
    @Column(nullable = true)
    private Date birthDate;

    @Nullable
    @Column(nullable = true)
    private String iban;

    @Nullable
    @Column(nullable = true)
    private String bic;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Rating> ratings;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Booking> bookings;

    public User() { }

    // Constructors
    // 1. necessary
    public User(String lastName, String firstName, String mailAddress,
            String password) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.mailAddress = mailAddress;
        this.password = password;

    }

    // 2. necessary + birthdate
    public User(String lastName, String firstName, String mailAddress,
            String password, Date birthDate) {
        this(lastName, firstName, mailAddress, password);
        this.birthDate = birthDate;
    }

    // 3. ALL inclusive
    public User(String lastName, String firstName, String mailAddress,
            String password, Date birthDate, String iban, String bic) {
        this(lastName, firstName, mailAddress, password, birthDate);
        this.iban = iban;
        this.bic = bic;
    }

    // Methods


    // Setter & Getter of Attributes
    public long getId() {
        return id;
    }

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

    public String getMailAddress() {
        return mailAddress;
    }

    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getBic() {
        return bic;
    }

    public void setBic(String bic) {
        this.bic = bic;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void addRating(Rating rating) {
        ratings.add(rating);
    }

    public void removeRating(Rating rating) {
        ratings.add(rating);
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void addBooking(Booking booking) {
        bookings.add(booking);
    }

    public void removeBooking(Booking booking) {
        bookings.remove(booking);
    }
}
