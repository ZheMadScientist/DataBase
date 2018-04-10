package wrapper.model.step;

import lombok.Data;
import wrapper.model.course.Module;
import wrapper.model.intervention.StepIntervention;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Collection;

@Data
@Entity
public class Step extends wrapper.model.Entity {

    @OneToMany
    Collection<StepIntervention> interventions;

    @ManyToOne
    Module module;
}
