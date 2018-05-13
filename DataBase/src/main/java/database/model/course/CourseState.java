package database.model.course;

import database.model.Entity;
import database.model.user.User;
import lombok.Data;

import javax.persistence.Basic;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import java.util.List;

/**
 * Класс, описывающий состояние курса
 */
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
