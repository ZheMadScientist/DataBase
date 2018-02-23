package wrapper.model.user;

import lombok.Data;
import wrapper.model.enums.UserRights;

import javax.persistence.*;

@Data
@Entity
public class User extends wrapper.model.Entity {

    @EmbeddedId
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Basic
    String name;

    @Basic
    String middleName;

    @Basic
    String lastName;

    @Basic
    UserRights userRights;
}
