package wrapper.model.intervention;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class Hint extends wrapper.model.Entity{

    public String message;
}
