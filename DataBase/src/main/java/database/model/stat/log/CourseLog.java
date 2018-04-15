package database.model.stat.log;

import database.model.course.Course;
import lombok.Data;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.util.List;

@Data
@Entity
public class CourseLog extends database.model.Entity {

    @OneToOne
    Course course;

    @ElementCollection
    public List<String> logs;

}
