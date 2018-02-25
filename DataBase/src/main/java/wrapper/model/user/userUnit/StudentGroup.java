package wrapper.model.user.userUnit;

import lombok.Data;
import wrapper.model.Entity;

import javax.persistence.*;

@Data
@javax.persistence.Entity
public class StudentGroup extends Entity {

    private long id;

    @Basic
    String groupName;

    /*
    //TODO: replace with collection of hLinks
    @ManyToOne
    Collection<Person> students;

    @OneToMany
    Collection<Course> courses;
    */

}
