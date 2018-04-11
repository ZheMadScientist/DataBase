package wrapper.model.descriptors;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Data
@Entity
public class VersionDescription {

    @Id
    @GeneratedValue
    public long version_description_id;

    public String description;

    public VersionDescription(String description){
        if(description != null)
            this.description = description;
        else description = "";
    }

}
