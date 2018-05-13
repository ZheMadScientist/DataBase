package database.model.user;

import database.model.course.CourseState;
import database.model.stat.log.UserLog;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс, описывающий пользователя
 */
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

    /**
     * Объект, хранящий активность (логи) пользователя
     */
    @OneToOne
    public UserLog userLog = new UserLog();

    /**
     * Список курсов, в которых учавствует пользователь
     */
    @OneToMany(mappedBy = "students")
    public List<CourseState> user_courses = new ArrayList<>();

    /**
     * Объект, хранящий права доступа пользователя к другим сущностям бд
     * @see Access
     */
    @ManyToOne
    public Access access;

    public User(){ }

    public User(User other){
        name = other.name;
        middleName = other.middleName;
        lastName = other.lastName;
    }
}
