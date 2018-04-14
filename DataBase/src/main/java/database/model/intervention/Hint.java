package database.model.intervention;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

@Data
@Entity
@Table( indexes = { @Index( name = "hint_index",  columnList="message", unique = false ) } )
public class Hint extends database.model.Entity{

    public String message;
}
