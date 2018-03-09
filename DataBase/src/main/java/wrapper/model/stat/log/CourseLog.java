package wrapper.model.stat.log;

import lombok.Data;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
public class CourseLog extends wrapper.model.Entity implements Serializable{

    @Id
    Integer course_log_id;

    @ElementCollection
    List<String> logs;

}
