package wrapper.model.person;

import wrapper.model.enums.PersonType;

public class Teacher extends Person {

    public Teacher(String name, String midName, String lastName) {
        super(PersonType.Teacher, name, midName, lastName);
    }

}
