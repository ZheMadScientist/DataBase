package database.versioning.serialization.serializers;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import database.model.Entity;
import database.model.RequestInfo;
import database.model.storage.Material;
import database.model.storage.Task;
import database.versioning.serialization.Constants;
import database.versioning.serialization.Serializer;

import javax.persistence.EntityManager;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * Реализация интерфейса {@link Serializer}
 * для сериализации класса {@link Task}
 * */
public class TaskSerializer implements Serializer<Task> {

    /**
     * @see Serializer#serialize(Entity)
     */
    @Override
    public String serialize(Task src) {
        StringWriter sw = new StringWriter();
        JsonWriter writer = new JsonWriter(sw);

        try {
            writer.beginObject();

            writer.name(Constants.REQUEST_INFO_ENTRY).beginObject();

            writer.name(Constants.REQUEST_INFO_ONTOLOGY_LINK).value(src.requestInfo.ontology_link);

            if(src.requestInfo.links != null) {
                writer.name(Constants.REQUEST_INFO_LINKS).beginArray();

                for (long id : src.requestInfo.links)
                    writer.value(id);
                writer.endArray();
            }

            if(src.requestInfo.generation_params != null) {
                writer.name(Constants.REQUEST_INFO_GEN_PARAMS).beginArray();

                for (String tmp : src.requestInfo.generation_params)
                    writer.value(tmp);
                writer.endArray();
            }


            if(src.requestInfo.attributes != null) {
                writer.name(Constants.REQUEST_INFO_ATRRS).beginArray();

                for (String tmp : src.requestInfo.attributes)
                    writer.value(tmp);
                writer.endArray();
            }
            writer.name(Constants.REQUEST_INFO_END).endObject();

            writer.name(Constants.GUID).value(src.GUID);
            writer.name(Constants.VERSION).value(src.version);
            writer.name(Constants.VERSION_DESCRIPTION).value(src.versionDescription);

            writer.name(Constants.NAME).value(src.name);
            writer.name(Constants.DESCRIPTION).value(src.description);
            writer.name(Constants.MATERIAL_ID).value(src.material.GUID);

            writer.endObject();

        } catch (IOException e) {}

        return sw.toString();
    }

    /**
     * @see Serializer#deserialize(String, EntityManager)
     */
    @Override
    public Task deserialize(String src, EntityManager em) {
        Task task = new Task();
        task.material = new Material();
        task.requestInfo = new RequestInfo();

        JsonReader reader = new JsonReader(new StringReader(src));

        try {
            reader.beginObject();

            while (reader.hasNext()) {
                String name = reader.nextName();

                if(name.equals(Constants.REQUEST_INFO_ENTRY)) {
                    reader.beginObject();

                } else if(name.equals(Constants.REQUEST_INFO_ONTOLOGY_LINK)){
                    task.requestInfo.ontology_link = reader.nextLong();

                } else if (name.equals(Constants.REQUEST_INFO_LINKS)) {
                    reader.beginArray();
                    while (reader.hasNext())
                        task.requestInfo.links.add(reader.nextLong());
                    reader.endArray();

                } else if (name.equals(Constants.REQUEST_INFO_GEN_PARAMS)) {
                    reader.beginArray();
                    while (reader.hasNext())
                        task.requestInfo.generation_params.add(reader.nextString());
                    reader.endArray();

                } else if (name.equals(Constants.REQUEST_INFO_ATRRS)) {
                    reader.beginArray();
                    while (reader.hasNext())
                        task.requestInfo.generation_params.add(reader.nextString());
                    reader.endArray();

                } else if (name.equals(Constants.REQUEST_INFO_END)) {
                    reader.endObject();

                } else if (name.equals(Constants.GUID)) {
                    task.GUID = reader.nextLong();

                } else if (name.equals(Constants.VERSION)) {
                    task.version = reader.nextString();

                } else if (name.equals(Constants.VERSION_DESCRIPTION)) {
                    task.versionDescription = reader.nextString();

                } else if (name.equals(Constants.NAME)) {
                    task.name = reader.nextString();

                } else if (name.equals(Constants.DESCRIPTION)) {
                    task.description = reader.nextString();

                } else if (name.equals(Constants.MATERIAL_ID)) {
                    task.material.GUID = reader.nextLong();

                } else {
                    reader.skipValue();
                }
            }

            reader.endObject();
            reader.close();

        } catch (IOException e) {}

        task.material = em.find(Material.class, task.material.GUID);

        return task;
    }
}
