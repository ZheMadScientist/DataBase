package database.model.user;

import database.model.course.CourseState;
import database.model.stat.log.UserLog;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "users", indexes = { @Index( name = "user_index",  columnList="name,middleName,lastName", unique = true ) })
public class User extends database.model.Entity {
    @Basic
    public String name;

    @Basic
    public String middleName;

    @Basic
    public String lastName;

    @OneToOne
    public UserLog userLog;

    @OneToMany(mappedBy = "students")
    public List<CourseState> user_courses;

    @ManyToOne
    public Access access;

    public User(){
        initDS();
    }

    public User(User other){
        initDS();
        name = other.name;
        middleName = other.middleName;
        lastName = other.lastName;
    }

    private void initDS (){
        userLog = new UserLog();
        user_courses = new ArrayList<>();
    }
}
