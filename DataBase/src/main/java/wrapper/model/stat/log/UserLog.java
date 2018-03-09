package wrapper.model.stat.log;

import lombok.Data;
import wrapper.model.user.User;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
public class UserLog extends wrapper.model.Entity implements Serializable{

    @Id
    @GeneratedValue
    long user_log_id;

    @OneToOne
    User user;

    @ElementCollection
    List <String> logs;
}
