package database.versioning.serialization.serializers;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import database.model.storage.Content;
import database.versioning.serialization.Constants;
import database.versioning.serialization.Serializer;

import javax.persistence.EntityManager;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

public class ContentSerializer implements Serializer<Content> {

    @Override
    public String serialize(Content src) {
        StringWriter sw = new StringWriter();
        JsonWriter writer = new JsonWriter(sw);

        try {
            writer.beginObject();

            writer.name(Constants.VERSION).value(src.version);
            writer.name(Constants.VERSION_DESCRIPTION_ID).value(src.versionDescription.version_description_id);
            writer.name(Constants.VERSION_DESCRIPTION).value(src.versionDescription.description);

            writer.name(Constants.CONTENT).value(src.content);

            writer.endObject();

        } catch (IOException e) {}

        return sw.toString();
    }

    @Override
    public Content deserialize(String src, EntityManager em) {
        Content content = new Content();
        JsonReader reader = new JsonReader(new StringReader(src));

        try {
            reader.beginObject();

            while (reader.hasNext()) {
                String name = reader.nextName();

                if (name.equals(Constants.VERSION)) {
                    content.version = reader.nextString();

                } else if (name.equals(Constants.VERSION_DESCRIPTION_ID)) {
                    content.versionDescription.version_description_id = reader.nextLong();

                } else if (name.equals(Constants.VERSION_DESCRIPTION)) {
                    content.versionDescription.description = reader.nextString();

                } else if (name.equals(Constants.CONTENT)) {
                    content.content = reader.nextString();

                } else {
                    reader.skipValue();
                }
            }

            reader.endObject();
            reader.close();

        } catch (IOException e) {}

        return content;
    }
}
