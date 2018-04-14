package database.model.storage.AIDS;

import lombok.Data;

import java.util.TreeSet;

@Data
public class GuidStorage {
    public TreeSet<Long> guids;

    public GuidStorage(){
        //TODO: get guids from DB
    }
}
