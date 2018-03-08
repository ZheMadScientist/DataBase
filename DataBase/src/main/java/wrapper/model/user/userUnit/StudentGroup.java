package wrapper.model.user.userUnit;

import lombok.Data;
import wrapper.model.Entity;

import javax.persistence.*;
import java.io.Serializable;

@Data
@javax.persistence.Entity
public class StudentGroup extends Entity implements Serializable {

    @Id
    long student_group_id;

    @Basic
    String groupName;

    /*
    //TODO: replace with collection of hLinks
    @ManyToOne
    Collection<User> students;

    @OneToMany
    Collection<Course> courses;
    */

}
