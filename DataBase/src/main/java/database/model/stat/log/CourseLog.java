package database.model.stat.log;

import lombok.Data;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import java.util.List;

@Data
@Entity
public class CourseLog extends database.model.Entity {

    @ElementCollection
    public List<String> logs;

}
