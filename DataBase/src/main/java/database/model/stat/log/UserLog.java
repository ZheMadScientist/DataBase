package database.model.stat.log;

import lombok.Data;
import database.model.user.User;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.util.List;

@Data
@Entity
public class UserLog extends database.model.Entity {

    @OneToOne
    public User user;

    @ElementCollection
    public List <String> logs;
}
