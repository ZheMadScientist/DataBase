package database.model.user;

import database.model.constants.AccessType;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Access {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    public String courseState;

    public Access(){
        courseState = AccessType.RD_ONLY;
    }
}
