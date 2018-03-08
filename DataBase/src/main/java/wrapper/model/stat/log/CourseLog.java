package wrapper.model.stat.log;

import lombok.Data;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Set;

@Data
@Entity
public class CourseLog {

    @Id
    Integer course_log_id;

    @ElementCollection
    Set<String> logs;

}
