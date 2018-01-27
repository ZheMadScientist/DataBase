package wrapper.model.person;

import wrapper.model.enums.PersonType;

public class Moderator extends Person {
    public Moderator(String name, String midName, String lastName) {
        super(PersonType.Moderator, name, midName, lastName);
    }
}
