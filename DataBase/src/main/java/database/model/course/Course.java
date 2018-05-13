package database.model.course;

import database.model.Entity;
import database.model.stat.log.CourseLog;
import lombok.Data;

import javax.persistence.OneToOne;

/**
 * Класс, описывающий курс (как учебную единицу)
 */
@Data
@javax.persistence.Entity
public class Course extends Entity {

    public String courseName;

    public String courseDescription;

    /**
     * Состояние курса
     * @see CourseState
     */
    @OneToOne
    public CourseState courseState;

    /**
     * Логи курса
     * @see CourseLog
     */
    @OneToOne
    public CourseLog courseLog;

    public Course () {}

    public Course (Course old) {
        super(old.version, old.versionDescription.description);
        this.courseName = old.courseName;
        this.courseDescription = old.courseDescription;
        this.courseState = old.courseState;
        this.courseLog = old.courseLog;

    }
}
