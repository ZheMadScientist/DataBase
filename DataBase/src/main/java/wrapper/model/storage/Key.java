package wrapper.model.storage;

import lombok.Data;
import wrapper.model.Entity;

@Data
@javax.persistence.Entity
public class Key extends Entity{
    String key;
}
