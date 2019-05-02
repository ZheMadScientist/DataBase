package database.repos;

import database.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    User getUserByNameAndMiddleNameAndLastNameAndAgeAndGender(String name, String middleName, String lastName, int age, String gender);

    User getUserByNameOrMiddleNameOrLastNameAndAge(String name, String middleName, String lastName, int age);

    User getUserByNameOrMiddleNameOrLastName(String name, String middleName, String lastName);

    List<User> getUsersByAgeBetweenAndGender(int fromAge, int toAge, String gender);

    List<User> getUsersByAgeBetween(int fromAge, int toAge);
}
