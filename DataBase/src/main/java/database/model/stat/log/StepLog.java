package database.model.stat.log;


import lombok.Data;
import database.model.user.User;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Data
@Entity
public class StepLog extends database.model.Entity {

    @ManyToOne
    public User user;

    public String log;
}
