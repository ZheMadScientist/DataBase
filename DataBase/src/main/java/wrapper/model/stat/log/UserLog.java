package wrapper.model.stat.log;

import lombok.Data;
import wrapper.model.user.User;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.util.List;

@Data
@Entity
public class UserLog extends wrapper.model.Entity {

    @OneToOne
    public User user;

    @ElementCollection
    public List <String> logs;
}
