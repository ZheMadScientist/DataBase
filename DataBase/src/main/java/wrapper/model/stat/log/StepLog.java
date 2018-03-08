package wrapper.model.stat.log;


import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.*;

@Data
@Entity
public class StepLog {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long stepLogID;


}
