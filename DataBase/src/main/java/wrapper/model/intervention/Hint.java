package wrapper.model.intervention;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

@Data
@Entity
@Table( indexes = { @Index( name = "hint_index",  columnList="message", unique = true ) } )
public class Hint extends wrapper.model.Entity{

    public String message;
}
