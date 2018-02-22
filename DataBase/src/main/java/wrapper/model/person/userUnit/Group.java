package wrapper.model.person.userUnit;

import lombok.Data;
import wrapper.model.Entity;
import wrapper.model.course.Course;
import wrapper.model.enums.EntityType;
import wrapper.model.person.User;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Collection;

@Data
@javax.persistence.Entity
public class Group extends Entity {

    String groupName;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long groupID;

    //TODO: replace with collection of hLinks
    Collection<User> students;

    Collection<Course> courses;

    public Group() {
        super(EntityType.Group);
    }
}
