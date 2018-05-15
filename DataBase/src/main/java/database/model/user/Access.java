package database.model.user;

import database.model.constants.AccessType;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Класс, хранящий права доступа для пользователя
 */
@Data
@Entity
public class Access {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;

    public String courseState;

    public String content;

    public String material;

    public String task;

    public String step;

    public String testStep;

    public String assigmentStep;

    public String key;

    public String users;

    public Access(){
        courseState = AccessType.RD_ONLY;
        content = AccessType.RD_ONLY;
        material = AccessType.RD_ONLY;
        task = AccessType.RD_ONLY;
        step = AccessType.RD_ONLY;
        testStep = AccessType.RD_ONLY;
        assigmentStep = AccessType.RD_ONLY;
        key = AccessType.RD_ONLY;
        users = AccessType.RD_ONLY;
    }
}
