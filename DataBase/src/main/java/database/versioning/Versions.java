package database.versioning;

import database.model.Entity;
import database.versioning.model.TokensWrapper;
import lombok.Data;
import lombok.NonNull;

import java.time.LocalDate;

@Data
@javax.persistence.Entity
public class Versions extends Entity {

    @NonNull
    public long entity_id;

    @NonNull
    public TokensWrapper tokensWrapper;

    @NonNull
    public String version;

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
