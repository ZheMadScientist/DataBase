package wrapper.model;

import lombok.Data;
import wrapper.model.descriptors.VersionDescription;

import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Data
@MappedSuperclass
public class Version {

    @NotNull
    public String version;

    @OneToOne
    public VersionDescription versionDescription;

    public Version(){
        version = "1";
    }

    public Version(String version, String description){
        this.version = version;
        versionDescription = new VersionDescription(description);
    }

}
