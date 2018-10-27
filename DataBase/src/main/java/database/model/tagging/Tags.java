package database.model.tagging;

import lombok.Data;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import java.util.List;

@Data
@Entity
public class Tags extends database.model.Entity {

    @ElementCollection
    public List<String> tags;

    public Tags() {}

}
