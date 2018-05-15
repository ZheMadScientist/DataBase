package database.model;

import lombok.Data;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Класс, описывающий версию объекта
 */
@Data
@MappedSuperclass
public class Version {

    @NotNull
    public String version;


    public String versionDescription;

    /**
     * Дата создания объекта
     */
    public String date;

    public Version(){
        version = "1";
        versionDescription = "";
        setDate();
    }

    public Version(String version, String description){
        this.version = version;
        versionDescription = description;
        setDate();
    }

    private void setDate(){
        date = LocalDate.now().format(DateTimeFormatter.ISO_DATE);
    }
}
