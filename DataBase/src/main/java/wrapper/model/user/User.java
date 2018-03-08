package wrapper.model.user;

import lombok.Data;
import wrapper.model.enums.UserRights;
import wrapper.model.stat.log.UserLog;

import javax.persistence.*;

@Data
@Entity
@Table(name = "users")
public class User extends wrapper.model.Entity {

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "user", optional = false)
    @PrimaryKeyJoinColumn
    UserLog userLog;

    @Basic
    String name;

    @Basic
    String middleName;

    @Basic
    String lastName;

    @Basic
    UserRights userRights;
}
