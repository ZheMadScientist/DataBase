package wrapper.model.thesaurus;

import lombok.Data;
import wrapper.model.enums.thesaurus.StatusOfApproval;
import wrapper.model.enums.thesaurus.StatusOfVisibility;
import wrapper.model.person.Person;
import wrapper.utils.GuidGenerator;

import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Collection;

@Data
@javax.persistence.Entity
public class Entity {

    @Id
    public final long GUID;

    public final long creatorId;

    public final LocalDate creationDate;

    public StatusOfVisibility visibility;

    public StatusOfApproval approval;

    boolean isReplaced;

    long replacedBy;

    public String name;

    public Collection<String> synonyms;

    public String sense;

    public String comments;

    public Collection<Relation> relations;

    public Entity(Person creator) {
        GUID = new GuidGenerator().issueNewGUID();
        creatorId = creator.getId();
        creationDate = LocalDate.now();

        visibility = StatusOfVisibility.NOT_INITIALIZED;
        approval = StatusOfApproval.NOT_INITIALIZED;

        isReplaced = false;
    }

    public void setReplacedBy(long replacedBy) {
        this.replacedBy = replacedBy;

        isReplaced = true;

        if(replacedBy == GUID)
            isReplaced = false;
    }
}
