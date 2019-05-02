package database.repos;

import database.model.storage.Review;
import database.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Repository
public interface ReviewRepo extends JpaRepository<Review, Long> {

    Set<Review> getReviewsByUserAndReviewDateBetweenAndTags_tagsIn(User user, LocalDate fromDate, LocalDate toDate, List<String> tags);

    List<Review> getReviewsByUserAndReviewDateBetween(User user, LocalDate fromDate, LocalDate toDate);

    Set<Review> getReviewsByTags_tagsIn(List<String> tags);

    List<Review> getReviewsByReviewDateBetween(LocalDate from, LocalDate to);
}