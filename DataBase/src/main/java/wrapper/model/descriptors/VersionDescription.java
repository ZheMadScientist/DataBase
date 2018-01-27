package wrapper.model.descriptors;

import lombok.Data;

@Data
public class VersionDescription {

    String description;

    public VersionDescription(String description){
        if(description != null)
            this.description = description;
        else description = "";
    }

}
