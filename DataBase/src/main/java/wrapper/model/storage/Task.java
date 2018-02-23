package wrapper.model.storage;

import lombok.Data;
import wrapper.model.Entity;

import javax.persistence.*;

@Data
@javax.persistence.Entity
public class Task extends Entity {

    @EmbeddedId
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long taskID;

    @Basic
    String content;
}
