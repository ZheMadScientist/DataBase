package database.model.course;

import database.model.Entity;
import database.model.stat.log.ModuleLog;
import lombok.Data;

import javax.persistence.OneToOne;

/**
 * Класс, описывающий модуль
 */
@Data
@javax.persistence.Entity
public class Module extends Entity{

    public String name;

    public String startDate;

    public String endDate;

    @OneToOne
    public ModuleLog moduleLog;
}
