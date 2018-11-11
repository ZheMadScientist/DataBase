package database.repos;

import database.model.storage.Review;
import database.model.tagging.Tags;
import database.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReviewRepo extends JpaRepository<Review, Long> {

    List<Review> getReviewsByUserAndReviewDateBetweenAndTagsIn(User user, LocalDate fromDate, LocalDate toDate, Tags tags);

    //List<Review> getReviewsByUser

    List<Review> getReviewsByReviewDateBetween(LocalDate from, LocalDate to);
}