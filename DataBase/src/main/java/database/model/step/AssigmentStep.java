package database.model.step;

import lombok.Data;
import database.model.storage.Task;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Entity
public class AssigmentStep extends Step {

    @OneToMany
    public List<Task> tasks;
}
