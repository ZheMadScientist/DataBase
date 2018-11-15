package database.model.storage;

import database.model.Entity;
import database.model.tagging.Tags;
import database.model.user.User;
import lombok.Data;

import javax.persistence.OneToOne;
import java.time.LocalDate;

@Data
@javax.persistence.Entity
public class Review extends Entity {

    /**
     * Пользователь, которому принадлежит отзыв
     */
    @OneToOne
    public User user;

    /**
     * Сам отзыв
     */
    @OneToOne
    public Content content;

    /**
     * Тэги
     */
    @OneToOne
    public Tags tags;

    //@ElementCollection
    //public List<String> tags;

    //@Column(columnDefinition = "TIMESTAMP")
    public LocalDate reviewDate;

    public Review () {
        reviewDate = LocalDate.now();
    }

    public Review (Review another) {
        super(another.version, another.versionDescription);
        this.user = another.user;
        this.reviewDate = another.reviewDate;
        this.content = another.content;
        this.tags = another.tags;
    }

}
