package wrapper.model;

import lombok.Data;
import wrapper.model.descriptors.VersionDescription;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class Version {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    String version;

    VersionDescription versionDescription;

    public Version(String version, String description){
        this.version = version;
        versionDescription = new VersionDescription(description);
    }

    public Version() {
    }

    public long getId(){
        return id;
    }
}
