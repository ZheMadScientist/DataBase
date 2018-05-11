package database.model.course;

import database.model.Entity;
import database.model.stat.log.ModuleLog;
import lombok.Data;

import javax.persistence.OneToOne;

@Data
@javax.persistence.Entity
public class Module extends Entity{

    @OneToOne
    public ModuleLog moduleLog;
}
