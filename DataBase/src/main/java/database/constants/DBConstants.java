package database.constants;

/**
 * Класс, хранящий константы для работы с БД
 */
public class DBConstants {

    public static final String[] NON_ENTITY_EXTENDED_ELEMENTS = new String[] { "access", "version_description" };

    public static String USERNAME = "postgres";
    public static String PASSWORD = "qwerty";
    public static String URL = "jdbc:postgresql://localhost:5432/EduProcessBank";
}
