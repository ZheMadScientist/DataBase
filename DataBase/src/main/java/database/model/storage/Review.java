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

    @OneToOne
    public User user;

    @OneToOne
    public  Content content;

    @OneToOne
    public Tags tags;

    @OneToOne
    public LocalDate date;

    public Review () {}

}
