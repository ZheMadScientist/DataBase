package wrapper.model.person;

import lombok.Data;
import wrapper.model.enums.PersonType;

import javax.persistence.Entity;

@Data
@Entity
public class Student extends Person {

    public  Student(String name, String middleName, String lastName){
        super(PersonType.Student, name, middleName, lastName);
    }
}
