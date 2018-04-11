package wrapper.model;

import lombok.Data;
import wrapper.model.descriptors.VersionDescription;

import javax.persistence.Basic;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Data
public class Version {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Basic
    @NotNull
    public String version;

    public VersionDescription versionDescription;

    public Version(){}

    public Version(String version, String description){
        this.version = version;
        versionDescription = new VersionDescription(description);
    }

}
