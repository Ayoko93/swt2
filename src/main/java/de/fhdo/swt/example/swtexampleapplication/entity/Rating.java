package de.fhdo.swt.example.swtexampleapplication.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import javax.annotation.Nullable;

/**
 * A data class for a Rating.
 */
@Entity
public class Rating {

    private static final int minStars = 0;


    private static final int maxStars = 5;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    private UserProfile author;

    private int stars;


    @Nullable
    @Column(nullable = true)
    private String comment;


    @ManyToOne
    private Holiday holiday;


    public Rating(UserProfile author, int stars, @Nullable String comment,
            Holiday holiday) {
        setAuthor(author);
        setRating(stars);
        this.comment = comment;
        setHoliday(holiday);
    }


    public Rating(UserProfile author, int stars, Holiday holiday) {
        this(author, stars, null, holiday);
    }


    public UserProfile getAuthor() {
        return author;
    }


    public void setAuthor(UserProfile author) {
        if(author == null)
            throw new NullPointerException("Author is null");
        else
            this.author = author;
    }

    public int getRating() {
        return stars;
    }


    public void setRating(int stars) {
        if (stars <= maxStars && stars >= minStars)
            this.stars = maxStars;
        else
            throw new IllegalArgumentException("The amount of stars for a "
                    + "rating has to be between 0 and 5");
    }


    public String getComment() {
        return comment;
    }


    public void setComment(@Nullable String comment) {
        this.comment = comment;
    }


    public void removeComment() {
        this.comment = null;
    }


    public Holiday getHoliday() {
        return holiday;
    }


    public void setHoliday(Holiday holiday) {
        if(holiday == null)
            throw new NullPointerException("Holiday is null");
        else
            this.holiday = holiday;
    }
}
