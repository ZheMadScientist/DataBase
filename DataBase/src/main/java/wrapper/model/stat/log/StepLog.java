package wrapper.model.stat.log;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class StepLog {

    @EmbeddedId
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long stepLogID;


}
