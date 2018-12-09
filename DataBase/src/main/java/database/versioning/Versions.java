package database.versioning;

import database.model.Entity;
import database.versioning.model.TokensWrapper;
import lombok.Data;
import lombok.NonNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

/**
 * Класс для хранения версий объектов
 */
@Data
@javax.persistence.Entity
public class Versions extends Entity {

    /**
     * GUID версионируемого объекта
     */
    @NonNull
    public long entity_id;

    /**
     * Объект класса, хранящего "разность" между предыдущей<br> и последней версией
     * версионируемого объекта
     * @see TokensWrapper
     */
    @NonNull
    public TokensWrapper tokensWrapper;

    /**
     * Версия сохраняемого объекта
     */
    @NonNull
    public String version;

    /**
     * Описание версии сохраняемого объекта
     */
    @NonNull
    public String versionDescription;

    /**
     * Дата создания сохраняемого объекта
     */
    @NonNull
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    public LocalDate date;

    public Versions (){}

    public Versions(long guid, TokensWrapper tokensWrapper, String version, String versionDescription, LocalDate date){
        this.entity_id = guid;
        this.date = date;
        this.tokensWrapper = tokensWrapper;
        this.version = version;
        this.versionDescription = versionDescription;
    }

}
