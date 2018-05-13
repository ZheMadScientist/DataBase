package database.versioning;

import database.model.Entity;
import database.versioning.model.TokensWrapper;
import lombok.Data;
import lombok.NonNull;

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
     * Объект класса, хранящего "разность" между предыдущей и последней версией
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
     * Дата создания сохраняемого объекта
     */
    @NonNull
    public LocalDate date;

    public Versions (){}

    public Versions(long guid, TokensWrapper tokensWrapper, String version, LocalDate date){
        this.entity_id = guid;
        this.date = date;
        this.tokensWrapper = tokensWrapper;
        this.version = version;
    }

}
