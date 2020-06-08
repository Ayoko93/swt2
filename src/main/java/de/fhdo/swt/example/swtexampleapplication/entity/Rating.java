package de.fhdo.swt.example.swtexampleapplication.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.lang.Nullable;

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
    private UserProfile author;

    /**
     * The amount of stars given.
     */
    private int stars;

    /**
     * The comment left by the author. May be null.
     */
    @Nullable
    private String comment;

    /**
     * Constructs an instance of this class.
     * 
     * @param author   the author of this rating
     * @param stars   the amount of stars given
     * @param comment the comment left by the author
     * @throws IllegalArgumentException if {@code stars} is bigger than
     *                                  {@code 5} or smaller than {@code 0}
     */
    public Rating(UserProfile author, int stars, String comment) {
        this.stars = stars;
        this.author = author;
        setComment(comment);
    }

    /**
     * @return the amount of stars given by the author of this rating
     */
    public int getStars() {
        return stars;
    }

    /**
     * Sets the amount of stars.
     * @param stars the amount of stars given by the author of this rating
     * @throws IllegalArgumentException if {@code stars} is bigger than
     *                                  {@code 5} or smaller than {@code 0}
     */
    public void setStars(int stars) {
        if (stars <= maxStars && stars >= minStars)
            this.stars = maxStars;
        else
            throw new IllegalArgumentException("The amount of stars for a "
                    + "rating has to be between 0 and 5");
    }

    /**
     * @return the comment written by the author
     */
    public String getComment() {
        return comment;
    }

    /**
     * Sets the comment of this rating.
     * @param comment the comment written by the author
     */
    public void setComment(String comment) {
        this.comment = comment;
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
     */
    public void setAuthor(UserProfile author) {
        this.author = author;
    }
}
