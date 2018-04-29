package database.model.step;

import lombok.Data;
import database.model.storage.Key;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Entity
public class TestStep extends AssigmentStep {

    @OneToMany
    public List<Key> keys;

    public TestStep () {}

    public TestStep (TestStep old) {
        this.keys = old.keys;
    }

}
