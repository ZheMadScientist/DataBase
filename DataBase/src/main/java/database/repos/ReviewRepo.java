package database.repos;

import database.model.storage.Review;
import database.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReviewRepo extends JpaRepository<Review, Long> {

    List<Review> getReviewsByUserAndReviewDateBetweenAndTags_tagsContaining(User user, LocalDate fromDate, LocalDate toDate, List<String> tags);

    List<Review> getReviewsByUserAndReviewDateBetween(User user, LocalDate fromDate, LocalDate toDate);

    List<Review> getReviewsByTags_tagsContaining(List<String> tags);

    List<Review> getReviewsByReviewDateBetween(LocalDate from, LocalDate to);
}