package database.model.stat.log;

import database.model.course.Module;
import lombok.Data;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.util.List;

/**
 * Класс, описывающий логи модуля
 */
@Data
@Entity
public class ModuleLog extends database.model.Entity {

    @OneToOne
    public Module module;

    @ElementCollection
    public List<String> logs;
}
