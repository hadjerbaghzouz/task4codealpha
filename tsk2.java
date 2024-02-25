
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
public class tsk2 {
  
}
// Class representing a hotel
class Hotel {
    private String name;
    private List<Review> reviews;

    public Hotel(String name) {
        this.name = name;
        this.reviews = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void addReview(Review review) {
        reviews.add(review);
    }
}

// Class representing a review
class Review {
    private String user;
    private int rating;
    private String comment;

    public Review(String user, int rating, String comment) {
        this.user = user;
        this.rating = rating;
        this.comment = comment;
    }

    public String getUser() {
        return user;
    }

    public int getRating() {
        return rating;
    }

    public String getComment() {
        return comment;
    }
}

// Comparator for sorting reviews by rating
class RatingComparator implements Comparator<Review> {
    @Override
    public int compare(Review r1, Review r2) {
        return Integer.compare(r2.getRating(), r1.getRating());
    }
}

// Comparator for sorting reviews by user
class UserComparator implements Comparator<Review> {
    @Override
    public int compare(Review r1, Review r2) {
        return r1.getUser().compareTo(r2.getUser());
    }
}

 class HotelReviewSystem {
    public static void main(String[] args) {
        Hotel hotel1 = new Hotel("Hotel A");
        Hotel hotel2 = new Hotel("Hotel B");

        hotel1.addReview(new Review("User1", 4, "Nice hotel with good service"));
        hotel1.addReview(new Review("User2", 5, "Excellent experience, highly recommended"));
        hotel1.addReview(new Review("User3", 3, "Average stay, could be better"));

        hotel2.addReview(new Review("User4", 4, "Great location and comfortable rooms"));
        hotel2.addReview(new Review("User5", 2, "Disappointing service and cleanliness"));

        System.out.println("Reviews for " + hotel1.getName());
        displayReviews(hotel1.getReviews());

        System.out.println("\nReviews for " + hotel2.getName());
        displayReviews(hotel2.getReviews());

        // Sort reviews by rating
        Collections.sort(hotel1.getReviews(), new RatingComparator());
        System.out.println("\nSorted reviews for " + hotel1.getName() + " by rating:");
        displayReviews(hotel1.getReviews());

        // Sort reviews by user
        Collections.sort(hotel2.getReviews(), new UserComparator());
        System.out.println("\nSorted reviews for " + hotel2.getName() + " by user:");
        displayReviews(hotel2.getReviews());
    }

    public static void displayReviews(List<Review> reviews) {
        for (Review review : reviews) {
            System.out.println("User: " + review.getUser() + " | Rating: " + review.getRating() + " | Comment: " + review.getComment());
        }
    }
}
