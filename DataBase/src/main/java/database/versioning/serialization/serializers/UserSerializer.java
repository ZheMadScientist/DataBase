package database.versioning.serialization.serializers;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import database.model.Entity;
import database.model.user.Access;
import database.model.user.User;
import database.versioning.serialization.Constants;
import database.versioning.serialization.Serializer;

import javax.persistence.EntityManager;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * Реализация интерфейса {@link Serializer}
 * для сериализации класса {@link User}
 * */
public class UserSerializer implements Serializer <User> {

    /**
     * @see Serializer#serialize(Entity)
     */
    @Override
    public String serialize(User src) {
        StringWriter sw = new StringWriter();
        JsonWriter writer = new JsonWriter(sw);

        try {
            writer.beginObject();

            writer.name(Constants.GUID).value(src.GUID);
            writer.name(Constants.VERSION).value(src.version);
            writer.name(Constants.VERSION_DESCRIPTION).value(src.versionDescription);

            writer.name(Constants.NAME).value(src.name);
            writer.name(Constants.MIDDLE_NAME).value(src.middleName);
            writer.name(Constants.LAST_NAME).value(src.lastName);

            writer.name(Constants.INNER_ENTITY_ID).value(src.access.id);

            writer.endObject();

        } catch (IOException e) {}

        return sw.toString();
    }

    /**
     * @see Serializer#deserialize(String, EntityManager)
     */
    @Override
    public User deserialize(String src, EntityManager em) {
        User user = new User();
        JsonReader reader = new JsonReader(new StringReader(src));

        try {
            reader.beginObject();

            while (reader.hasNext()) {
                String name = reader.nextName();

                if (name.equals(Constants.GUID)) {
                    user.GUID = reader.nextLong();

                } else if (name.equals(Constants.VERSION)) {
                    user.version = reader.nextString();

                } else if (name.equals(Constants.VERSION_DESCRIPTION)) {
                    user.versionDescription = reader.nextString();

                } else if (name.equals(Constants.NAME)) {
                    user.name = reader.nextString();

                } else if (name.equals(Constants.MIDDLE_NAME)) {
                    user.middleName = reader.nextString();

                } else if (name.equals(Constants.LAST_NAME)) {
                    user.lastName = reader.nextString();

                } else if (name.equals(Constants.INNER_ENTITY_ID)) {
                    user.access.id = reader.nextLong();

                } else {
                    reader.skipValue();
                }
            }

            reader.endObject();
            reader.close();

        } catch (IOException e) { }

        user.access = em.find(Access.class, user.access.id);

        return user;
    }
}
