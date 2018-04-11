package wrapper.model.course;

import lombok.Data;
import wrapper.model.Entity;
import wrapper.model.user.User;

import javax.persistence.Basic;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Data
@javax.persistence.Entity
public class CourseState extends Entity {

    @Basic
    public String groupName;


    @ManyToMany
    public List <User> students;

    @OneToOne
    public Course course;

}
