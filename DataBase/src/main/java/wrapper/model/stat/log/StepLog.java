package wrapper.model.stat.log;


import lombok.Data;
import wrapper.model.user.User;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
public class StepLog extends wrapper.model.Entity implements Serializable{

    @ManyToOne
    User user;

    String log;
}
