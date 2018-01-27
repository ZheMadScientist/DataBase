package wrapper.model.course;

import wrapper.model.Entity;
import wrapper.model.enums.EntityType;
import wrapper.model.storage.Material;
import wrapper.model.storage.Task;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Collection;

public class Course extends Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long courseID;

    String courseName;

    String courseDescription;

    Collection<Task> tasks;

    Collection<Material> materials;

    public Course() {
        super(EntityType.Course);
    }
}
