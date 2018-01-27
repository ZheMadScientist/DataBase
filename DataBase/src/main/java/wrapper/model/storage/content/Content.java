package wrapper.model.storage.content;

import lombok.Data;
import wrapper.model.Entity;
import wrapper.model.enums.ContentType;
import wrapper.model.enums.EntityType;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
public class Content extends Entity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public Content(ContentType contentType) {
        super(EntityType.Content);
    }
}
