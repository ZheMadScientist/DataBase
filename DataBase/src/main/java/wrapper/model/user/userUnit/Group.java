package wrapper.model.user.userUnit;

import lombok.Data;
import wrapper.model.Entity;
import wrapper.model.course.Course;
import wrapper.model.user.User;

import javax.persistence.*;
import java.util.Collection;

@Data
@javax.persistence.Entity
public class Group extends Entity {

    private long id;

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
