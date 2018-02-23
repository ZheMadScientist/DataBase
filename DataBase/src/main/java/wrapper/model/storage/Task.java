package wrapper.model.storage;

import lombok.Data;
import wrapper.model.Entity;

import javax.persistence.*;

@Data
@javax.persistence.Entity
public class Task extends Entity {


    @Basic
    String content;
}
