package wrapper.model.user;

import lombok.Data;
import wrapper.model.course.CourseState;
import wrapper.model.stat.log.UserLog;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "users")
public class User extends wrapper.model.Entity implements Serializable {

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "user", optional = false)
    @PrimaryKeyJoinColumn
    public UserLog userLog;

    @Basic
    public String name;

    @Basic
    public String middleName;

    @Basic
    public String lastName;

    @ManyToMany(mappedBy = "students")
    public List<CourseState> user_courses;
}
