package wrapper.model.course;

import lombok.Data;
import org.springframework.data.annotation.Persistent;
import wrapper.model.Entity;
import wrapper.model.storage.Material;
import wrapper.model.storage.Task;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.UUID;

@Data
@javax.persistence.Entity
public class Course extends Entity {

    String courseName;

    String courseDescription;

    //Collection<Task> tasks;

    //Collection<Material> materials;


}
