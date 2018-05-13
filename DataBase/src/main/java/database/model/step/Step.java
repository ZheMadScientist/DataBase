package database.model.step;

import database.model.course.Module;
import database.model.intervention.StepIntervention;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Collection;

/**
 * Класс, описывающий действие пользователя, влияющее на дальнейший процесс обучения
 */
@Data
@Entity
public class Step extends database.model.Entity {

    /**
     * Список возможных интервенций
     */
    @OneToMany
    public Collection<StepIntervention> interventions;


    @ManyToOne
    public Module module;

    public Step () {}

    public Step (Step old) {
        super(old.version, old.versionDescription.description);
        this.interventions = old.interventions;
        this.module = old.module;
    }

}
