package wrapper.model.stat.log;

import lombok.Data;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import java.util.List;

@Data
@Entity
public class ModuleLog extends wrapper.model.Entity {

    @ElementCollection
    public List<String> logs;
}
