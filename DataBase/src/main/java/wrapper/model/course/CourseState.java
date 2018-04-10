package wrapper.model.course;

import lombok.Data;
import wrapper.model.Entity;
import wrapper.model.course.Course;
import wrapper.model.user.User;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@javax.persistence.Entity
public class CourseState extends Entity implements Serializable {

    @Basic
    String groupName;


    @ManyToMany
    List <User> students;

    @OneToOne
    Course course;

}
