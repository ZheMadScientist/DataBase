package wrapper.model.course;

import lombok.Data;
import wrapper.model.Entity;

import javax.persistence.OneToOne;

@Data
@javax.persistence.Entity
public class Course extends Entity {

    public String courseName;

    public String courseDescription;

    @OneToOne
    public CourseState courseState;


}
