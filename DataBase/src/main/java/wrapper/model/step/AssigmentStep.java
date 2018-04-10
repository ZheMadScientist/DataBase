package wrapper.model.step;

import lombok.Data;
import wrapper.model.storage.Task;

import javax.persistence.Entity;
import java.util.List;

@Data
@Entity
public class AssigmentStep extends Step {
    List<Task> tasks;
}
