package wrapper.model.stat.log;


import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
public class StepLog extends wrapper.model.Entity implements Serializable{

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long stepLogID;


}
