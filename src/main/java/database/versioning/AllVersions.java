package database.versioning;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class AllVersions {

    /**
     * {@code Map <version , version description>}
     */
    public Map<String, String> versions;

    public AllVersions() {
        versions = new HashMap<>();
    }

    public void put(String key, String val) {
        versions.put(key, val);
    }

}
