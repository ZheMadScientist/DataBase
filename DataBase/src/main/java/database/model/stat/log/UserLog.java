package database.model.stat.log;

import database.model.user.User;
import lombok.Data;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс, описывающий логи пользователя
 */
@Data
@Entity
public class UserLog extends database.model.Entity {

    @OneToOne
    public User user;

    @ElementCollection
    public List <String> logs;

    public UserLog(){
        logs = new ArrayList<>();
    }

    public UserLog(UserLog old) {
        super(old.version, old.versionDescription.description);
        this.logs = old.logs;
        this.user = old.user;
    }
}
