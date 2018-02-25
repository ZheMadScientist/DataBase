package wrapper.model.user;

import lombok.Data;
import wrapper.model.enums.UserRights;

import javax.persistence.*;

@Data
@Entity
public class Person extends wrapper.model.Entity {

    @Basic
    String name;

    @Basic
    String middleName;

    @Basic
    String lastName;

    @Basic
    UserRights userRights;
}
