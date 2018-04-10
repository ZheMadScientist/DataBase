package wrapper.model.step;

import lombok.Data;
import wrapper.model.storage.Key;

import javax.persistence.Entity;
import java.util.List;

@Data
@Entity
public class TestStep extends AssigmentStep {
    List<Key> keys;
}
