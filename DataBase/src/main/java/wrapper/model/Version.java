package wrapper.model;

import lombok.Data;
import wrapper.model.descriptors.VersionDescription;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
public class Version {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Basic
    @NotNull
    String version;

    VersionDescription versionDescription;

    public Version(){}

    public Version(String version, String description){
        this.version = version;
        versionDescription = new VersionDescription(description);
    }

}
