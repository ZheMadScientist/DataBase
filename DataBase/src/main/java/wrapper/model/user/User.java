package wrapper.model.user;

import lombok.Data;
import wrapper.model.stat.log.UserLog;
import wrapper.model.course.CourseState;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "users")
public class User extends wrapper.model.Entity implements Serializable {

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "user", optional = false)
    @PrimaryKeyJoinColumn
    UserLog userLog;

    @Basic
    String name;

    @Basic
    String middleName;

    @Basic
    String lastName;

    @ManyToMany(mappedBy = "students")
    List<CourseState> user_courses;
}
