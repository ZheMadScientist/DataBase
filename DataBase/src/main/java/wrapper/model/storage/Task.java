package wrapper.model.storage;

import lombok.Data;
import wrapper.model.Entity;
import wrapper.model.enums.EntityType;
import wrapper.model.enums.TaskType;

@Data
@javax.persistence.Entity
public class Task extends Entity {
    TaskType taskType;

    public Task(TaskType taskType) {
        super(EntityType.Task);

        this.taskType = taskType;
    }
}
