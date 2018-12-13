package database.model.user;

import lombok.Data;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

/**
 * Класс, описывающий пользователя
 */
@Data
@Entity
@Table(name = "users")
public class User extends database.model.Entity {
    @Basic
    public String name;

    @Basic
    public String middleName;

    @Basic
    public String lastName;

    public Integer age;

    /**
     * default vals: <br>male - m
     * <br>female - f
     */
    public String gender;

    public boolean isValid() {
        return name != null || middleName != null || lastName != null || age != null;
    }

    public User(){ }

    public User(User other){
        this.name = other.name;
        this.middleName = other.middleName;
        this.lastName = other.lastName;
        this.age = other.age;
        this.gender = other.gender;
    }
}
