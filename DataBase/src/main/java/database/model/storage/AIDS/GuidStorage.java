package database.model.storage.AIDS;

import java.util.TreeSet;

public class GuidStorage {

    static GuidStorage instance;

    TreeSet<Long> guids;

    GuidStorage(){
        //TODO: get all GUIDs via sql-request
    }

    public static GuidStorage getInstance() {
        if(instance == null)
            instance = new GuidStorage();

        return instance;
    }

    public boolean addGUID(long guid){
        return guids.add(guid);
    }

}
