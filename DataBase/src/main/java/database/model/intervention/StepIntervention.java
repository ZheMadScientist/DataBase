package database.model.intervention;

import database.model.Entity;
import lombok.Data;

@Data
@javax.persistence.Entity
public class StepIntervention extends Entity {

    public String message;
}
