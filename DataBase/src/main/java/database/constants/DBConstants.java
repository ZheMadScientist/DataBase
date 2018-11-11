package database.constants;

import java.util.HashMap;

/**
 * Класс, хранящий константы для работы с БД
 */
public class DBConstants {

    public static final String[] NON_ENTITY_EXTENDED_ELEMENTS = new String[] { "access", "version_description" };

    public static final HashMap<String, String> ELEMENT_COLLECTION_ELEMENTS = new HashMap<>();
    static {
        ELEMENT_COLLECTION_ELEMENTS.put("tags_tags", "tags_guid");
    }

    public static String USERNAME = "makar";
    public static String PASSWORD = "makar";
    public static String URL = "jdbc:postgresql://localhost:5432/maindb";
}
