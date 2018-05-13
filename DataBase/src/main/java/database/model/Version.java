package database.model;

import database.model.descriptors.VersionDescription;
import lombok.Data;

import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

/**
 * Класс, описывающий версию объекта
 */
@Data
@MappedSuperclass
public class Version {

    @NotNull
    public String version;

    // TODO: replace with String
    @OneToOne
    public VersionDescription versionDescription;

    /**
     * Дата создания объекта
     */
    public LocalDate date;

    public Version(){
        version = "1";
        versionDescription = new VersionDescription();
        setDate();
    }

    public Version(String version, String description){
        this.version = version;
        versionDescription = new VersionDescription(description);
        setDate();
    }

    private void setDate(){
        date = LocalDate.now();
    }
}
