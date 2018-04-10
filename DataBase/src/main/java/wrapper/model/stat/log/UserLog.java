package wrapper.model.stat.log;

import lombok.Data;
import wrapper.model.user.User;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
public class UserLog extends wrapper.model.Entity implements Serializable{

    @OneToOne
    User user;

    @ElementCollection
    List <String> logs;
}
