package database.model.step;

import database.model.storage.Key;
import lombok.Data;

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
