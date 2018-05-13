package database.model.step;

import database.model.storage.Task;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Класс, описывающий присвоенный пользователю логически завершенный блок заданий
 */
@Data
@Entity
public class AssigmentStep extends Step {

    /**
     * Список заданий
     */
    @OneToMany
    public List<Task> tasks;

    public AssigmentStep(){}

    public AssigmentStep(AssigmentStep old){
        this.tasks = old.tasks;
    }

}
