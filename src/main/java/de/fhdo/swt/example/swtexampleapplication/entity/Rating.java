package de.fhdo.swt.example.swtexampleapplication.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.Range;

import javax.annotation.Nullable;

/**
 * A data class for a Rating. Holds information about the author, the rating as
 * well as any comment left by the author.
 */
@Entity
public class Rating {
    /**
     * The minimum rating possible. Any rating below this is invalid.
     */
    private static final int minStars = 0;

    /**
     * The maximum rating possible. Any rating above this is invalid.
     */
    private static final int maxStars = 5;

    /**
     * The primary identifier of this rating. Basically the primary key inside
     * the database table. Of no further use in the program.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    /**
     * The author of this rating.
     */
    @ManyToOne
    private User author;

    /**
     * The amount of stars the author gave.
     */
    @Range(min = minStars, max = maxStars)
    private int stars;

    /**
     * The comment left by the author. May be {@code null}, if none has been
     * written.
     */
    @Nullable
    @Column(nullable = true)
    private String comment;

    /**
     * The holiday the rating is for.
     */
    @ManyToOne
    private Holiday holiday;

    /**
     * Constructs an instance of this class.
     * 
     * @param author  the author of this rating
     * @param stars   the amount of stars given
     * @param comment the comment left by the author
     * @param holiday the holiday this rating is for
     * 
     * @throws NullPointerException if either {@code author} or {@code holiday}
     *                              is {@code null}
     * @throws IllegalArgumentException if {@code stars} is outside the valid
     *                                  range of values, defined by
     *                                  {@link #minStars} and {@link maxStars}
     */
    public Rating(User author, int stars, @Nullable String comment,
            Holiday holiday) {
        setAuthor(author);
        setRating(stars);
        this.comment = comment;
        setHoliday(holiday);
    }

    /**
     * Constructs an instance of this class.
     * 
     * @param author  the author of this rating
     * @param stars   the amount of stars given
     * @param holiday the holiday this rating is for
     * 
     * @throws NullPointerException if either {@code author} or {@code holiday}
     *                              is {@code null}
     * @throws IllegalArgumentException if {@code stars} is outside the valid
     *                                  range of values defined by
     *                                  {@link #minStars} and {@link maxStars}
     */
    public Rating(User author, int stars, Holiday holiday) {
        this(author, stars, null, holiday);
    }

    /**
     * @return the author of this rating
     */
    public User getAuthor() {
        return author;
    }

    /**
     * Sets the author of this rating.
     * @param author the author of this rating
     * @throws NullPointerException if {@code author} is {@code null}
     */
    public void setAuthor(User author) {
        if(author == null)
            throw new NullPointerException("Author is null");
        else
            this.author = author;
    }

    /**
     * @return the amount of stars given by the author of this rating
     */
    public int getRating() {
        return stars;
    }

    /**
     * Sets the amount of stars.
     * @param stars the amount of stars given by the author of this rating
     * @throws IllegalArgumentException if {@code stars} is outside the valid
     *                                  range of values defined by
     *                                  {@link #minStars} and {@link maxStars}
     */
    public void setRating(int stars) {
        if (stars <= maxStars && stars >= minStars)
            this.stars = maxStars;
        else
            throw new IllegalArgumentException("The amount of stars for a "
                    + "rating has to be between 0 and 5");
    }

    /**
     * @return the comment written by the author or {@code null} if the author
     *         did not write one
     */
    @Nullable
    public String getComment() {
        return comment;
    }

    /**
     * Sets the comment of this rating.
     * @param comment the comment written by the author or {@code null} if none
     *                has been written
     */
    public void setComment(@Nullable String comment) {
        this.comment = comment;
    }

    /**
     * Removes the comment of this rating if any has been set.
     */
    public void removeComment() {
        this.comment = null;
    }

    /**
     * @return the holiday this rating is for
     */
    public Holiday getHoliday() {
        return holiday;
    }

    /**
     * Sets the holiday this rating is for.
     * @param holiday the holiday this rating is for
     * @throws NullPointerException if {@code holiday} is {@code null}
     */
    public void setHoliday(Holiday holiday) {
        if(holiday == null)
            throw new NullPointerException("Holiday is null");
        else
            this.holiday = holiday;
    }
}
