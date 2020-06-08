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
    /**
     * The minimum rating possible.
     */
    private static final int minStars = 0;

    /**
     * The maximum rating possible.
     */
    private static final int maxStars = 5;

    /**
     * The primary identifier of this rating.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    /**
     * The author of this rating.
     */
    @ManyToOne
    private UserProfile author;

    /**
     * The amount of stars given.
     */
    private int stars;

    /**
     * The comment left by the author. May be null.
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
     * @throws IllegalArgumentException if {@code stars} is bigger than
     *                                  {@code 5} or smaller than {@code 0}
     */
    public Rating(UserProfile author, int stars, @Nullable String comment,
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
     * @throws IllegalArgumentException if {@code stars} is bigger than
     *                                  {@code 5} or smaller than {@code 0}
     */
    public Rating(UserProfile author, int stars, Holiday holiday) {
        this(author, stars, null, holiday);
    }

    /**
     * @return the author of this rating
     */
    public UserProfile getAuthor() {
        return author;
    }

    /**
     * Sets the author of this rating.
     * @param author the author of this rating
     * @throws NullPointerException if {@code author} is {@code null}
     */
    public void setAuthor(UserProfile author) {
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
     * @throws IllegalArgumentException if {@code stars} is bigger than
     *                                  {@code 5} or smaller than {@code 0}
     */
    public void setRating(int stars) {
        if (stars <= maxStars && stars >= minStars)
            this.stars = maxStars;
        else
            throw new IllegalArgumentException("The amount of stars for a "
                    + "rating has to be between 0 and 5");
    }

    /**
     * @return the comment written by the author or {@code null} if there is
     *         none
     */
    public String getComment() {
        return comment;
    }

    /**
     * Sets the comment of this rating.
     * @param comment the comment written by the author or {@code null} to
     *                remove it
     */
    public void setComment(@Nullable String comment) {
        this.comment = comment;
    }

    /**
     * Remove the comment of this rating.
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
