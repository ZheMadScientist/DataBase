package database.model.stat.log;


import database.model.user.User;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * Класс, описывающий логи "шага" пользователя
 */
@Data
@Entity
public class StepLog extends database.model.Entity {

    @ManyToOne
    public User user;

    public String log;
}
