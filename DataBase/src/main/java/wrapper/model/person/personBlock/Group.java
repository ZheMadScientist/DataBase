package wrapper.model.person.personBlock;

import lombok.Data;
import wrapper.model.Entity;
import wrapper.model.course.Course;
import wrapper.model.enums.EntityType;
import wrapper.model.person.Person;
import wrapper.model.person.Teacher;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Collection;

@Data
@javax.persistence.Entity
public class Group extends Entity {

    String groupName;

    Teacher teacher;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long groupID;

    //TODO: replace with collection of hLinks
    Collection<Person> students;

    Collection<Course> courses;

    public Group() {
        super(EntityType.Group);
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
