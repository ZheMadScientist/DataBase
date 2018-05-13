package database.versioning.serialization.serializers;

import com.google.gson.Gson;
import database.model.Entity;
import database.versioning.serialization.Serializer;

import javax.persistence.EntityManager;

/**
 * Дефолтная реализация интерфейса {@link Serializer}, использующая class mapping
 * для сериализации классов, наследующихся от {@link Entity}
 * */
public class DefaultSerializer<T extends Entity> implements Serializer<T> {

    Class<T> c;

    public DefaultSerializer (Class<T> c) {
        this.c = c;
    }

    /**
     * @see Serializer#serialize(Entity)
     */
    @Override
    public String serialize(T src) {
        Gson gson = new Gson();
        return gson.toJson(src);
    }

    /**
     * @see Serializer#deserialize(String, EntityManager)
     */
    @Override
    public T deserialize(String src, EntityManager em) {
        Gson gson = new Gson();
        return gson.fromJson(src, c);
    }

}
