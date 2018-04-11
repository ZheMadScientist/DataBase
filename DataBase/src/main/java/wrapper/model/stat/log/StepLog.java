package wrapper.model.stat.log;


import lombok.Data;
import wrapper.model.user.User;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Data
@Entity
public class StepLog extends wrapper.model.Entity {

    @ManyToOne
    public User user;

    public String log;
}
