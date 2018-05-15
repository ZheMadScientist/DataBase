package database.model.stat.log;

import database.model.course.Course;
import lombok.Data;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.util.List;

/**
 * Класс, описывающий логи курса
 */
@Data
@Entity
public class CourseLog extends database.model.Entity {

    @OneToOne
    Course course;

    @ElementCollection
    public List<String> logs;

    public CourseLog () {}

    public CourseLog (CourseLog old) {
        super(old.version, old.versionDescription);
        this.course = old.course;
        this.logs = old.logs;
    }

}
