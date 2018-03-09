package wrapper.model.course;

import lombok.Data;
import wrapper.model.Entity;

import javax.persistence.*;
import java.io.Serializable;

@Data
@javax.persistence.Entity
public class Course extends Entity implements Serializable {

    @Id
    @GeneratedValue
    long course_id;

    String courseName;

    String courseDescription;

    @OneToOne
    CourseState courseState;


}
