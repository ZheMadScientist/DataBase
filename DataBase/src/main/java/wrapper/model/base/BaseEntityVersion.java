package wrapper.model.base;

import java.util.Date;

public class BaseEntityVersion {
    long id;

    BaseEntity tuple;

    int versionNumber;

    Date verStartDate;

    Date verEndDate;

    String operation; // ???
}
