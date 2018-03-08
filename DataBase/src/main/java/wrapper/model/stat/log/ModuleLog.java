package wrapper.model.stat.log;

import lombok.Data;

import javax.persistence.Basic;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Data
@Entity
public class ModuleLog {

    @Id
    Integer module_log_id;

    @ElementCollection
    public List<String> logs;
}
