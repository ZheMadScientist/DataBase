package database.model.intervention;

import database.model.Entity;
import lombok.Data;

/**
 * Класс, описывающий интервенцию "шага"
 */
@Data
@javax.persistence.Entity
public class StepIntervention extends Entity {

    public String message;
}
