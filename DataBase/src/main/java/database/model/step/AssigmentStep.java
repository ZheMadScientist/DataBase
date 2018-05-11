package database.model.step;

import database.model.storage.Task;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Entity
public class AssigmentStep extends Step {

    @OneToMany
    public List<Task> tasks;

    public AssigmentStep(){}

    public AssigmentStep(AssigmentStep old){
        this.tasks = old.tasks;
    }

}
