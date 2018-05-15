package database.versioning.serialization.serializers;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import database.model.Entity;
import database.model.storage.Content;
import database.model.storage.Material;
import database.versioning.serialization.Constants;
import database.versioning.serialization.Serializer;

import javax.persistence.EntityManager;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * Реализация интерфейса {@link Serializer}
 * для сериализации класса {@link Material}
 * */
public class MaterialSerializer implements Serializer<Material> {

    /**
     * @see Serializer#serialize(Entity)
     */
    @Override
    public String serialize(Material src) {
        StringWriter sw = new StringWriter();
        JsonWriter writer = new JsonWriter(sw);

        try {
            writer.beginObject();

            writer.name(Constants.GUID).value(src.GUID);
            writer.name(Constants.VERSION).value(src.version);
            writer.name(Constants.VERSION_DESCRIPTION).value(src.versionDescription);

            writer.name(Constants.NAME).value(src.name);
            writer.name(Constants.DESCRIPTION).value(src.description);

            writer.name(Constants.ENTRY).beginObject();

            writer.name(Constants.INNER_VERSION).value(src.content.version);
            writer.name(Constants.INNER_VERSION_DESCRIPTION).value(src.content.versionDescription);

            writer.name(Constants.CONTENT_ID).value(src.content.GUID);
            writer.name(Constants.CONTENT).value(src.content.content);

            writer.endObject();
            writer.endObject();

        } catch (IOException e) {
        }

        return sw.toString();
    }


    /**
     * @see Serializer#deserialize(String, EntityManager)
     */
    @Override
    public Material deserialize(String src, EntityManager em) {
        Material material = new Material();
        material.content = new Content();
        JsonReader reader = new JsonReader(new StringReader(src));

        try {
            reader.beginObject();

            while (reader.hasNext()) {
                String name = reader.nextName();

                if (name.equals(Constants.GUID)) {
                    material.GUID = reader.nextLong();

                } else if (name.equals(Constants.VERSION)) {
                    material.version = reader.nextString();

                } else if (name.equals(Constants.VERSION_DESCRIPTION)) {
                    material.versionDescription = reader.nextString();

                } else if (name.equals(Constants.NAME)) {
                    material.name = reader.nextString();

                } else if (name.equals(Constants.DESCRIPTION)) {
                    material.description = reader.nextString();

                } else if (name.equals(Constants.ENTRY)) {
                    reader.beginObject();

                } else if (name.equals(Constants.INNER_VERSION)) {
                    material.content.version = reader.nextString();

                } else if (name.equals(Constants.INNER_VERSION_DESCRIPTION)) {
                    material.content.versionDescription = reader.nextString();

                } else if (name.equals(Constants.CONTENT_ID)) {
                    material.content.GUID = reader.nextLong();

                } else if (name.equals(Constants.CONTENT)) {
                    material.content.content = reader.nextString();
                    reader.endObject();

                } else {
                    reader.skipValue();
                }
            }

            reader.endObject();
            reader.close();

        } catch (IOException e) { }

        return material;
    }
}
