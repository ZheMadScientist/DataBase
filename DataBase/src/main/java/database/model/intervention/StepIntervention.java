package database.model.intervention;

import lombok.Data;
import database.model.Entity;

@Data
@javax.persistence.Entity
public class StepIntervention extends Entity {

    public String message;
}
