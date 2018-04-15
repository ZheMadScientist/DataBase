package database.model.course;

import database.model.stat.log.ModuleLog;
import lombok.Data;
import database.model.Entity;

import javax.persistence.OneToOne;

@Data
@javax.persistence.Entity
public class Module extends Entity{

    @OneToOne
    public ModuleLog moduleLog;
}
