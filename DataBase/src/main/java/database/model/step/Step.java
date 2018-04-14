package database.model.step;

import lombok.Data;
import database.model.course.Module;
import database.model.intervention.StepIntervention;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Collection;

@Data
@Entity
public class Step extends database.model.Entity {

    @OneToMany
    public Collection<StepIntervention> interventions;

    @ManyToOne
    public Module module;
}
