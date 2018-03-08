package wrapper.model.stat.log;

import lombok.Data;
import org.springframework.data.annotation.Id;
import wrapper.model.user.User;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class UserLog{

    @javax.persistence.Id
    public long user_log_id;

    @ElementCollection
    public List <String> logs;

    @MapsId
    @OneToOne
    User user;

}
