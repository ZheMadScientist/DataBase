package wrapper.model.stat.log;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
public class ModuleLog extends wrapper.model.Entity implements Serializable{

    @Id
    @GeneratedValue
    Integer module_log_id;

    @ElementCollection
    public List<String> logs;
}
