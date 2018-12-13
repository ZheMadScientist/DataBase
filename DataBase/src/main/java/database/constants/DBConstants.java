package database.constants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * Класс, хранящий константы для работы с БД
 */
@Component
public class DBConstants {

    public static final String[] NON_ENTITY_EXTENDED_ELEMENTS = new String[] { "access", "version_description" };

    public static final HashMap<String, String> ELEMENT_COLLECTION_ELEMENTS = new HashMap<>();
    static {
        ELEMENT_COLLECTION_ELEMENTS.put("tags_tags", "tags_guid");
    }

    public static String USERNAME;

    public static String PASSWORD;

    public static String URL;

    @Autowired
    public DBConstants(@Value("${spring.datasource.username:server}") String username,
                       @Value("${spring.datasource.password:password}") String password,
                       @Value("${spring.datasource.url:jdbc:postgresql://localhost:5432/maindb}") String url) {

        USERNAME = username;
        PASSWORD = password;
        URL = url;
    }
}
