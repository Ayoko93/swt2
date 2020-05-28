package de.fhdo.swt.example.swtexampleapplication.entity;

public class Rating {
    private final int maxStars = 5;
    private int starCounter;
    private String ratingTest;
    private UserProfile valuer;

    public Rating(int starCounter, String ratingTest, UserProfile valuer) {
        this.starCounter = starCounter;
        this.ratingTest = ratingTest;
        this.valuer = valuer;
    }

    // Setter & Getter of Attributes
    public int getStarCounter() {
        return starCounter;
    }

    public void setStarCounter(int starCounter) {
        if (starCounter <= maxStars) {
            this.starCounter = starCounter;
        } else {
            this.starCounter = maxStars;
        }

    }

    public String getRatingTest() {
        return ratingTest;
    }

    public void setRatingTest(String ratingTest) {
        this.ratingTest = ratingTest;
    }

    public UserProfile getValuer() {
        return valuer;
    }

    public void setValuer(UserProfile valuer) {
        this.valuer = valuer;
    }
}
